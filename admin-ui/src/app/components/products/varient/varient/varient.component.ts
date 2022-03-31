import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder,FormArray } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { VarientService } from './varient.service';
@Component({
  selector: 'app-varient',
  templateUrl: './varient.component.html',
  styleUrls: ['./varient.component.scss']
})
export class VarientComponent implements OnInit {
varientData
varient
varientId
  constructor(private fb: FormBuilder,private _service : VarientService,private router : Router,private route : ActivatedRoute) { 
    this.varientData = new FormGroup({
      varientName : new FormControl('',Validators.required)
    });
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params.varientId;
    this.varientId = id;
    console.log(id);
    debugger
    if(this.varientId!=null) {
      this.getData(id);
      }
  }


  saveVarient() {
    
    // console.log(this.studentData.value)
    debugger;
   
    console.log(this.varientData.value)
    if(this.varientId==null) {
    this._service.addVarient(this.varientData.value).subscribe((result=>{
console.log(result),error => {
      
  console.log(error);
  
}
;
this.router.navigate(['/products/varient-list'])
    }))
    console.log(this.varientData.value)
  }else{
    this._service.updateVarient(this.varientId,this.varientData.value).subscribe(data => {
      console.log(data)
      this.router.navigate(['/products/varient-list'])
    },error => {
      
      console.log(error);
      
    })
  }
  }

  getData(id){
    this._service.getVarient(id).subscribe(res => {
      this.varient=res;
      console.log(this.varient)
      if(this.varient!=null) {
      this.varientData.patchValue({
        varientName : this.varient.varientName
      })
    }
    },error => {
      
      console.log(error);
      
    })
  }
}
