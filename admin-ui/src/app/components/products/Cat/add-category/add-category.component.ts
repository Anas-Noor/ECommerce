import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder,FormArray } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.scss']
})
export class AddCategoryComponent implements OnInit {
  categoryData
  constructor(private fb: FormBuilder,private router : Router,private route : ActivatedRoute) {
    this.categoryData = new FormGroup({
      name : new FormControl('',Validators.required),
      thumbnail : new FormControl('',Validators.required),
    });
   }
  ngOnInit(): void {
  }

  saveCat() {
    console.log(this.categoryData.value);
    
  }
}
