import './App.css';
import React from "react";
import {Routes, Route} from "react-router-dom"

import Orders from "./component/Orders";

import CreateOrder from "./component/CreateOrder";
import UpdateOrder from "./component/UpdateOrder";

function App() {
    return (
        <Routes>
            <Route path="/" element={<Orders/>}/>
            <Route path="/create-order" element={<CreateOrder/>}/>
            <Route path="/update-order/:id" element={<UpdateOrder/>}/>
        </Routes>
    );
}

export default App;
