import React from 'react'
import { useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
export default function Index() {
    const {id}=useParams();
    const[name,setName]=useState("");
  const[capacity,setCapacity]=useState("");
  const submit=async (e)=>{
    e.preventDefault();
    let dept={
      name:name,
      capacity:capacity
    };
    console.log(JSON.stringify(dept));
    await axios.put(`http://localhost:8080/backend-1.0-SNAPSHOT/api/department/update/${id}`,dept);
    setName("");
    setCapacity("");
    alert("Department updated successfully");
  }
  return (
    <div className='container'>
        <form onSubmit={submit}>
        <div className="form-group">
            <label htmlFor="Name">Name</label>
            <input type="text" className="form-control" id="name" placeholder="Enter name" value={name} onChange={(e)=>{setName(e.target.value)}} required/>
        </div>
        <div className="form-group">
            <label htmlFor="Capacity">Capacity</label>
            <input type="number" className="form-control" id="capacity" placeholder="Enter capacity" min="20" max="100" value={capacity} onChange={(e)=>{setCapacity(e.target.value)}} required/>
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
        </form>
    </div>
    
  )
}
