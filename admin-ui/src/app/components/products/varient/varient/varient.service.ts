import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class VarientService {

  constructor(private http : HttpClient) { }
  url = "http://localhost:8090/varient"

  addVarient(varientData) {
    return this.http.post(this.url,varientData)
  }
  deleteVarient(id) {
    return this.http.delete(`${this.url}/${id}`,id)
  }
  getAllVarient(){
    return this.http.get(this.url)
  }
  updateVarient(id,varient) {
    return this.http.put(`${this.url}/${id}`,varient)
  }
  getVarient(id) {
    return this.http.get(`${this.url}/${id}`)
  }
}
