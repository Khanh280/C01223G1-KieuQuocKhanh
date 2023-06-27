import logo from './logo.svg';
import './App.css';
import {BookList} from "./component/BookList";
import React from "react";
import {BrowserRouter} from "react-router-dom";
import {Route, Routes} from "react-router";
import {Create} from "./component/Create";
import {ToastContainer} from "react-toastify";
import {Update} from "./component/Update";

function App() {
    return (
       <>
           <Routes>
               <Route path='/' element={<BookList/>}/>
               <Route path='/create' element={<Create/>}/>
               <Route path='/update/:id' element={<Update/>}/>
           </Routes>
           <ToastContainer/>
       </>
    );
}

export default App;
