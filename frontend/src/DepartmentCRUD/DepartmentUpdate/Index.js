import React from 'react'
import { useState, useEffect } from 'react';
import axios from 'axios';
import Modal from "react-bootstrap/Modal";
import ModalBody from "react-bootstrap/ModalBody";
export default function Index({data,hide}) {
    const[name,setName]=useState("");
    const[capacity,setCapacity]=useState("");
    const [length, setL]=useState(0);
      useEffect(()=>{
        axios.get(`http://localhost:8080/backend-1.0-SNAPSHOT/api/department/get/${data.i}`).
        then(res=>{setL(res.data.emp_list.length);setName(res.data.name);setCapacity(res.data.capacity)})
    },[])
    
      const submit=(e)=>{
        e.preventDefault();
        let dept={name:name,capacity:capacity};
        console.log(JSON.stringify(dept));
        if(capacity<length){
          alert("Current number of employee is ",length," which is more");
        }
        else{
          axios.put(`http://localhost:8080/backend-1.0-SNAPSHOT/api/department/update/${data.i}`,dept).
          then(res=>{console.log(res)});
          alert("Department updated successfully");
          hide();
        }
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

