const express =require("express");
const app=express();
const bodyParser=require("body-parser");
const mysql=require("mysql2");
const cors=require("cors");

const db=mysql.createPool({
    host:"localhost",
    user:"root",
    password:"root",
    database:"result_management"
});

app.use(cors());
app.use(express.json());
app.use(bodyParser.urlencoded({extended:true}));

app.get("/api/get",(req,res)=>{
    const sqlGet="SELECT * FROM students";
    db.query(sqlGet,(error,result)=>{
        res.send(result);
    });
});

app.post("/api/post",(req,res)=>{
    const { roll,name,date_of_birth,score} =req.body;
    const sqlInsert=
    "INSERT INTO students (roll,name,date_of_birth,score) VALUES(?,?,?,?)";
    db.query(sqlInsert,[roll,name,date_of_birth,score],(error,result)=>{
        if(error){
            console.log(error);
        }
    });
});

app.delete("/api/remove/:id",(req,res)=>{
    const { id} =req.params;
    const sqlRemove=
    "DELETE FROM students WHERE id=?";
    db.query(sqlRemove,[id],(error,result)=>{
        if(error){
            console.log(error);
        }
    });
});

app.get("/api/get/:id",(req,res)=>{
    const {id} =req.params;
    const sqlGet="SELECT * FROM students WHERE id=?";
    db.query(sqlGet,id,(error,result)=>{
        if(error){
            console.log(error);
        }
        res.send(result);
    });
});

app.put("/api/update/:id",(req,res)=>{
    const {id}=req.params;
    const {roll,name,date_of_birth,score}=req.body;
    const sqlUpdate="SELECT * FROM students SET roll=?,name=?,date_of_birth=?,score=? WHERE id=?";
    db.query(sqlUpdate,[roll,name,date_of_birth,score,id],(error,result)=>{
        if(error){
            console.log(error);
        }
        res.send(result);

    });
});


app.get("/",(req,res)=>{
    // const sqlInsert = "INSERT INTO students (id,roll,name,date_of_birth,score) VALUES('1','1','raj','26/04/2000','85')";
    // db.query(sqlInsert,(error,result)=>{
    //     console.log("error",error);
    //     console.log("result",result);
    // })
    // res.send("hello express");
})

app.listen(5000,()=>{
    console.log("server is running on port 5000");
})