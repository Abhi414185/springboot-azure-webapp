import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class NgserviceService {

  constructor(private _http:HttpClient) { }

  getProductByName(name){
    return this._http.get("http://localhost:8085/getproductbyName/"+name)
  }

  fetchProductListFromRemote():Observable<Product[]>{
    return this._http.get<Product[]>("http://localhost:8085/getproductlist");
  }
  
  fetchProductByidFromRemote(id:number):Observable<any>{
    return this._http.get<any>("http://localhost:8085/getproductbyid/"+id)
  }

}
