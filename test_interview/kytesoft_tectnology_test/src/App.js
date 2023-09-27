import logo from './logo.svg';
import './App.css';
import {Header} from "./component/Header";
import {Routes, Route} from "react-router-dom"
import React from "react";
import {Footer} from "./component/Footer";
import {HomePage} from "./component/HomePage";



function App() {



    return (
        <>
            <Header/>
            <HomePage/>
            <Footer/>
        </>
    );
}

export default App;
