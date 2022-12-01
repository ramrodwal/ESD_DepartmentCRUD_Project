import React, { useState } from 'react'
import axios from "axios";
export default function Index() {
  const[name,setName]=useState("");
  const[capacity,setCapacity]=useState("");
  const submit=async (e)=>{
    e.preventDefault();
    let dept={
      name:name,
      capacity:capacity
    };
    console.log(JSON.stringify(dept));
    await axios.post("http://localhost:8080/backend-1.0-SNAPSHOT/api/department/add",dept);
    setName("");
    setCapacity("");
    alert("Department added successfully");
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

