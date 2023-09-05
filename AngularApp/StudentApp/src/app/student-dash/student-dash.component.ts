import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ApiService } from '../shared/api.service';
import { StudentData } from './student.model';


@Component({
  selector: 'app-student-dash',
  templateUrl: './student-dash.component.html',
  styleUrls: ['./student-dash.component.css']
})
export class StudentDashComponent implements OnInit {

  formValue!: FormGroup
  studentModelObj: StudentData = new StudentData
  allStudentData: any;
  showAdd!:boolean;
  showbtn!:boolean;

  constructor(private formBuilder: FormBuilder, private api: ApiService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      rollNo: [''],
      name: [''],
      dateOfBirth: [''],
      scores: [''],
    })
    this.getAllData()
  }

  clickAddStudent(){
    this.formValue.reset();
    this.showAdd=true;
    this.showbtn=false;
  }

  addStudent() {
    this.studentModelObj.rollNo = this.formValue.value.rollNo;
    this.studentModelObj.name = this.formValue.value.name;
    this.studentModelObj.dateOfBirth = this.formValue.value.dateOfBirth;
    this.studentModelObj.scores = this.formValue.value.scores;

    this.api.postStudent(this.studentModelObj).subscribe(res => {
      console.log(res);
      alert("Student Record Added Successfully");
      let ref = document.getElementById('clear');
      ref?.click();
      this.formValue.reset()
      this.getAllData();
    },
      err => {
        alert("Something Went Wrong");
      })

  }

  getAllData() {
    this.api.getStudent().subscribe(res => {
      this.allStudentData = res;
    })
  }

  deleteStudent(data: any) {
    this.api.deleteStudent(data.id).subscribe(res => {
      alert("Student Records Deleted")
      this.getAllData();
    })
  }

  onEditStudent(data: any) {
    this.showAdd=false;
    this.showbtn=true;
    this.studentModelObj.id=data.id
    this.formValue.controls['rollNo'].setValue(data.rollNo);
    this.formValue.controls['name'].setValue(data.name);
    this.formValue.controls['dateOfBirth'].setValue(data.dateOfBirth);
    this.formValue.controls['scores'].setValue(data.scores);
  }

  updateStudent(){

    this.studentModelObj.rollNo = this.formValue.value.rollNo;
    this.studentModelObj.name = this.formValue.value.name;
    this.studentModelObj.dateOfBirth = this.formValue.value.dateOfBirth;
    this.studentModelObj.scores = this.formValue.value.scores;

    this.api.updateStudent(this.studentModelObj,this.studentModelObj.id).subscribe(res=>{
      alert("Student Record Updated")
      let ref = document.getElementById('clear');
      ref?.click();
      this.formValue.reset()
      this.getAllData();

    })

  }

}
