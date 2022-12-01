import axios from 'axios';
import React, {useState, useEffect} from 'react';
import "./Index.css";
import DepartmentUpdate from '../DepartmentUpdate/Index.js';
import Modal from "react-bootstrap/Modal";
import ModalBody from "react-bootstrap/ModalBody";
import ModalHeader from "react-bootstrap/ModalHeader";
import ModalFooter from "react-bootstrap/ModalFooter";
import ModalTitle from "react-bootstrap/ModalTitle";
import { useNavigate } from 'react-router-dom';
export default function Index() {
      const [dept, setDepartment]=useState([]);
      useEffect(()=>{
        axios.get("http://localhost:8080/backend-1.0-SNAPSHOT/api/department/getall").
        then(res=>{setDepartment(res.data);console.log(res.data)})
      },[]);
      const onDelete = (department_id)=>{
        axios.delete(`http://localhost:8080/backend-1.0-SNAPSHOT/api/department/delete/${department_id}`).
        then(res=>{console.log(res.data)});
        setDepartment(dept.filter((d)=>{
            return d.department_id !== department_id;
        }
        ))
      } 
      

      const navigate=useNavigate();
      const onGet_emp = (department_id)=>{
        console.log("I am onGet_emp",department_id);
        navigate(`/Fetch/${department_id}`);
      } 
      let d=[{i:0}]
      const onUpdate = (department_id)=>{
        console.log("I am onUpdate",department_id);
        navigate(`/Modify/${department_id}`)
        
      } 
      return (
        <div className='departmentlist-container container'>
            
            
            <h3>Department List</h3>
            <ul className="list-group">
            {dept.length===0? <p className='empty'>No Department to display</p> :
            dept.map((item)=>{
                return(
                    <li className="list-group-item dept">
                        <h4>Department Id : {item.department_id}</h4>
                        <h4>Department Name : {item.name}</h4>
                        <h4>Department Capacity : {item.capacity}</h4>
                        <button type="button" className="btn btn-danger" onClick={()=>onDelete(item.department_id)}>Delete</button>
                        <button type="button" className="btn btn-primary" onClick={()=>onGet_emp(item.department_id)}>Get Employees</button>
                        <button type="button" className="btn btn-warning" onClick={()=>onUpdate(item.department_id)}>Update</button>
                    </li>
                    )
                })}
            </ul>
        </div>
      )
}
