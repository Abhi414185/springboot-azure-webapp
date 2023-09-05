import React, { useState, useEffect } from 'react';
import { Link, renderMatches, useLoaderData } from "react-router-dom";
import "./Home.css";
import { toast } from "react-toastify";
import axios from "axios";


const Home = () => {
    const [data, setData] = useState([]);

    const loadData = async () => {
        const response = await axios.get("http://localhost:5000/api/get");
        setData(response.data);
    };

    useEffect(() => {
        loadData();
    }, []);

    const deleteStudent=(id)=> {
        if(window.confirm ("Are you sure to delete the record")){
            axios.delete('http://localhost:5000/api/remove/${id}');
            toast.success("Student deleted successfully");
            setTimeout(()=>loadData(),500);
        }
    };

        return (
            <div style={{ marginTop: "150px" }}>
                <Link to="/addStudent">
                    <button className="btn btn-contact">Add student</button>
                </Link>

                <table className="styled-table">
                    <thead>
                        <tr>
                            <th style={{ textAlign: "center" }}>ID</th>
                            <th style={{ textAlign: "center" }}>Roll No.</th>
                            <th style={{ textAlign: "center" }}>Name</th>
                            <th style={{ textAlign: "center" }}>D.O.B</th>
                            <th style={{ textAlign: "center" }}>Score</th>
                            <th style={{ textAlign: "center" }}>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((item, index) => {
                            return (
                                <tr key={item.id}>
                                    <th scop="row">{index+1}</th>
                                    <td>{item.roll}</td>
                                    <td>{item.name}</td>
                                    <td>{item.date_of_birth}</td>
                                    <td>{item.score}</td>
                                    <td>
                                        <Link to={'/update/${item.id}'}>
                                            <button className='btn btn-edit'>Edit</button>
                                        </Link>
                                        <button className="btn btn-delete" onClick={()=>deleteStudent(item.id)}>Delete</button>

                                    </td>
                                </tr>

                            )
                        })}
                    </tbody>
                </table>
            </div>
        )};


export default Home;
