import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators, FormArray } from "@angular/forms";
import { HttpClient } from "@angular/common/http";
import { ImageService } from "../../image.service";
import { IngredientsService } from "../../ingredients.service";
import { map, switchMap } from "rxjs";
import { CategoriesService } from "../../categories.service";
import {Category} from "../../../model/Category";
import {Ingredient} from "../../../model/Ingredient";

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent {
  private file: File | null = null;
  createProduct = new FormGroup({
    productName: new FormControl(null, Validators.required),
    productPrice: new FormControl(null, Validators.required),
    productDescription: new FormControl(null, Validators.required),
    productIngredients: new FormArray([]),
    productCustomizable: new FormControl(false),
    productCategory: new FormControl(null, Validators.required),
    productAvailability: new FormControl(false),
    productImage: new FormControl(null, Validators.required),
    fileSource: new FormControl<File | null>(null, Validators.required),
  });
  categories: Category[] = []; // Array to store the categories
  ingredients: Ingredient[] = []; // Array to store the ingredients

  constructor(
    private http: HttpClient,
    private imageService: ImageService,
    private categoriesService: CategoriesService,
    private ingredientsService: IngredientsService
  ) {}

  ngOnInit(): void {
    this.loadCategories();
    this.loadIngredients();
  }

  loadCategories() {
    this.categoriesService.findAllCategories().subscribe(
      (data: Category[]) => {
        this.categories = data;
      },
      (error: any) => {
        console.error('Error retrieving categories:', error);
      }
    );
  }

  loadIngredients() {
    this.ingredientsService.findAllIngredients().subscribe(
      (data: Ingredient[]) => {
        this.ingredients = data;
      },
      (error: any) => {
        console.error('Error retrieving ingredients:', error);
      }
    );
  }

  onFileChange(event: Event) {
    this.file = ((event.target) as HTMLInputElement).files!![0];
    this.createProduct.patchValue({ fileSource: this.file });
  }

  addIngredient() {
    const control = new FormControl(null);
    (this.createProduct.get('productIngredients') as FormArray).push(control);
  }

  removeIngredient(index: number) {
    (this.createProduct.get('productIngredients') as FormArray).removeAt(index);
  }

  submit() {
    const formData = new FormData();
    formData.append('file', this.createProduct.get('fileSource')?.value!!);

    this.imageService.saveImage(formData).pipe(
      map(data => data.id),
      switchMap(data => this.categoriesService.saveCategory({
        "name": this.createProduct.controls['productName'].value!,
        "price": this.createProduct.controls['productPrice'].value!,
        "description": this.createProduct.controls['productDescription'].value!,
        "ingredients": this.createProduct.controls['productIngredients'].value!,
        "customizable": this.createProduct.controls['productCustomizable'].value,
        "category": this.createProduct.controls['productCategory'].value,
        "available": this.createProduct.controls['productAvailability'].value,
        "imageId": data,
        "pizzaNumber": 0 // Replace with actual pizza number
      }))
    ).subscribe(data => console.log(data));
  }
}
