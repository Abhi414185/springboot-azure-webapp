import React, { useState, useEffect } from 'react';
import { useHistory, useParams, Link, useNavigate } from 'react-router-dom';
import "./AddEdit.css";
import axios from 'axios';
import { toast } from "react-toastify";

const initialState = {
    roll: "",
    name: "",
    date_of_birth: "",
    score: "",

};

const AddEdit = () => {

    const [state, setState] = useState(initialState);
    const { roll, name, date_of_birth, score } = state;

    const {id} =useParams();

    useEffect(()=>{
        axios.get('http://localhost:5000/api/get/${id}').then((resp)=>setState({...resp.data[0]}));
    },[id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!roll || !name || !date_of_birth || !score) {
            toast.error("Please Provide value into each input field ");
        } else {
            if(!id){
            axios
                .post("http://localhost:5000/api/post", {
                    roll, name, date_of_birth, score
                })
                .then(() => {
                    setState({ roll: "", name: "", date_of_birth: "", score: "" });
                })
                .catch((err) => toast.error(err.response.data));
            toast.success("Student Added Successfully");
        }else{
            axios
            .put('http://localhost:5000/api/update/${id}', {
                roll, name, date_of_birth, score
            })
            .then(() => {
                setState({ roll: "", name: "", date_of_birth: "", score: "" });
            })
            .catch((err) => toast.error(err.response.data));
        toast.success("Student updated Successfully");
        }

        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setState({ ...state, [name]: value });
    };
    return (
        <div style={{ marginTop: "100px" }}>
            <form style={{
                margin: "auto",
                padding: "15px",
                maxWidth: "400px",
                alignContent: "center"
            }}
                onSubmit={handleSubmit}
            >
                <label htmlFor="roll">Roll No.</label>
                <input type="text" id="roll" name="roll" placeholder="Your Roll.." value={roll || ""} onChange={handleInputChange} />

                <label htmlFor="name">Name</label>
                <input type="text" id="name" name="name" placeholder="Your Name.." value={name || ""} onChange={handleInputChange} />

                <label htmlFor="date_of_birth">D.O.B</label>
                <input type="text" id="date_of_birth" name="date_of_birth" placeholder="Your D.O.B.." value={date_of_birth ||""} onChange={handleInputChange} />

                <label htmlFor="score">Score</label>
                <input type="text" id="Score" name="score" placeholder="Your Score.." value={score || ""} onChange={handleInputChange} />

                <input type="submit" value={id ? "update" :"save"} />
                <Link to="/">
                    <input type="button" value="Go Back" />
                </Link>

            </form>
        </div>
    )
}

export default AddEdit;