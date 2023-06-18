import { Component, OnInit } from '@angular/core';
import { CategoriesService } from '../categories.service';
import { Category } from '../model/Category';

@Component({
  selector: 'app-categories-menu-homepage',
  templateUrl: './categories-menu-homepage.component.html',
  styleUrls: ['./categories-menu-homepage.component.css']
})
export class CategoriesMenuHomepageComponent implements OnInit{
  categories:Category[] = [];
  constructor(private categoryService:CategoriesService) {}
  
  ngOnInit(): void {
    this.categoryService.findAllCategories().subscribe(data => console.log(data));
  }
;


}
