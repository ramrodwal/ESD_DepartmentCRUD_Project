import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios';
import './Index.css';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

export default function Index() {
    const {id}=useParams();
    const[emp_list,setL]=useState([]);
    
    useEffect(()=>{
        axios.get(`http://localhost:8080/backend-1.0-SNAPSHOT/api/department/get/${id}`).
        then(res=>{
            setL(res.data.emp_list);
        })
    },[])
    console.log(emp_list);
  return (
    <div className='container'>
        {emp_list.length===0? <p className='empty'>No Employee to display</p> :
        emp_list.map((item)=>{
        let path='./src/image/demo.jpg';   
        return(
            <ul class="list-group">
                <li class="list-group-item">
                    <div className="row">
                    <div className="col-9">
                        <ul className="list-group">
                        <li className="list-group-item">Employee_id : {item.employee_id}</li>
                        <li className="list-group-item">Email : {item.email}</li>
                        <li className="list-group-item">Name : {item.first_name} {item.last_name}</li>
                        <li className="list-group-item">Title : {item.title}</li>
                        </ul>
                    </div>
                    <div className="col-3">
                        <img src={`${item.photograph_path}`} class="img-fluid img-thumbnail rounded" alt="Responsive image"/>
                    </div>
                    </div>
                </li>
            </ul>
        )
        })}
        
    </div>
  )
}
