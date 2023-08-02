import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {ImageService} from "../../image.service";
import {map, switchMap} from "rxjs";
import {CategoriesService} from "../../categories.service";

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent {
  private file:File | null = null
  createCategory = new FormGroup({
    categoryName: new FormControl(null,Validators.required),
    categoryImage: new FormControl(null,Validators.required),
    categoryDescription: new FormControl(null,Validators.required),
    fileSource: new FormControl<File | null>(null,Validators.required),
  })

  constructor(private http:HttpClient,private imageService:ImageService,private categoriesService:CategoriesService) { }

  ngOnInit(): void {
  }
  onFileChange(event:Event) {
    this.file = ((event.target) as HTMLInputElement).files!![0]
    this.createCategory.patchValue({fileSource: this.file})
  }

  submit(){
    const formData = new FormData();
    formData.append('file',this.createCategory.get('fileSource')?.value!!)
    this.imageService.saveImage(formData).pipe(
      map(data => data.id),
      switchMap(data => this.categoriesService.saveCategory({
          "name":this.createCategory.controls['categoryName'].value!,
          "description":this.createCategory.controls['categoryDescription'].value!,
          "imageId":data
      })
      )
    ).subscribe(data => console.log(data));
  }
}
