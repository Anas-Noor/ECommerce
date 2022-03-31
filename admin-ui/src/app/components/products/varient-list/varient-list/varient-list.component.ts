import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder,FormArray } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { VarientService } from '../../varient/varient/varient.service';

@Component({
  selector: 'app-varient-list',
  templateUrl: './varient-list.component.html',
  styleUrls: ['./varient-list.component.scss']
})
export class VarientListComponent implements OnInit {

  constructor(private fb: FormBuilder,private _service : VarientService,private router : Router) { }
  varients:any;
  ngOnInit(): void {
    this.getVarients()
  }
  deleteVarient(varientId) {
    console.log(varientId);
    this._service.deleteVarient(varientId).subscribe(data => {
      console.log(data)})
      location.reload()
  }

  getVarients() {
    this._service.getAllVarient().subscribe(res => {
      this.varients = res ;
      console.log(this.varients)
    },error => {

    })
  }
  updateVarient(varientId) {
    this.router.navigate(['products/varient',varientId])
  }
}
