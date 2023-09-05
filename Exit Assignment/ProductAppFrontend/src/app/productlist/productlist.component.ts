import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgserviceService } from '../ngservice.service';
import { Product } from '../product';
import { User } from '../user';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  products:any;
  name:any;

  
  constructor(private _service:NgserviceService,private _router: Router) { }

  public findUserByName(){
    let resp=this._service.getProductByName(this.name)
    resp.subscribe((data)=>this.products=data);
  }

  ngOnInit() {

    this.fetchProductListFromRemote()
      
  }

  private fetchProductListFromRemote(){
  this._service.fetchProductListFromRemote().subscribe(
    data=>{
      this.products=data;
    }
    
    );
  
  }

  gotoViewProduct(id:number){
    console.log("id"+id);
    this._router.navigate(['/viewproduct',id]);
  }

  gotologin(){
    this._router.navigate(['/login']);
  }

}
