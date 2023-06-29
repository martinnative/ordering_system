import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {finalize, map, switchMap} from "rxjs";
import {ImageService} from "../../image.service";
import {IngredientsService} from "../../ingredients.service";

@Component({
  selector: 'app-create-ingredient',
  templateUrl: './create-ingredient.component.html',
  styleUrls: ['./create-ingredient.component.css']
})
export class CreateIngredientComponent {
  private file:File | null = null
  createIngredient = new FormGroup({
    ingredientName: new FormControl(null,Validators.required),
    ingredientImage: new FormControl(null,Validators.required),
    fileSource: new FormControl<File | null>(null,Validators.required),
  })

  constructor(private http:HttpClient,private imageService:ImageService,private ingredientService:IngredientsService) { }

  ngOnInit(): void {
  }
  onFileChange(event:Event) {
    this.file = ((event.target) as HTMLInputElement).files!![0]
    this.createIngredient.patchValue({fileSource: this.file})
  }

  submit(){
    const formData = new FormData();
    formData.append('file',this.createIngredient.get('fileSource')?.value!!)
    this.imageService.saveImage(formData).pipe(
      map(data => data.id),
      switchMap(data => this.ingredientService.saveIngredient({
        "name":this.createIngredient.controls['ingredientName'].value!,
        "imageId":data}
        )
      ),
      finalize(() => window.parent.location.href = "http://localhost:4200")
    ).subscribe();
  }
}
