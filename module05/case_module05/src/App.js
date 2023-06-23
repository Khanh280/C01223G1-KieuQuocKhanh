import logo from './logo.svg';
import './App.css';

import Header from "./header-footer/Header";
import List from "./service/List";
import Footer from "./header-footer/Footer";
import {Routes,Route,Link} from "react-router-dom"
import React from "react";

function App() {
    return (
        <>
            <Header/>
            {/*<List />*/}
            <Footer/>
        </>

    );
}

export default App;
