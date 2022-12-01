import logo from './logo.svg';
import './App.css';
import Header from './DepartmentCRUD/Header/Index.js'
import Department from './DepartmentCRUD/DepartmentHome/Index.js';
import Footer from './DepartmentCRUD/Footer/Index.js';
import AddDepartment from './DepartmentCRUD/AddDepartment/Index.js';
import FetchEmployee from './DepartmentCRUD/FetchEmployee/Index.js';
import Modify from './DepartmentCRUD/Modify/Index.js';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <Router>
      <div className="App">
        <Header/>
        <Routes>
          <Route exact path="/" element={<Department/>}></Route>
          <Route exact path="/Add" element={<AddDepartment/>}></Route>
          <Route exact path="/Fetch/:id" element={<FetchEmployee/>}></Route>
          <Route exact path="/Modify/:id" element={<Modify/>}></Route>
        </Routes>
      </div>
      <Footer/>
    </Router>
  );
}

export default App;