import logo from './logo.svg';
import './App.css';
import React, {useState} from "react";
import Counter1 from "./component/Counter1";
import Counter2 from "./component/Counter2";

function App() {
    return (
        <>
            <div align="center"><h1>[Bài tập] Xây dựng Component Counter</h1></div>
            <Counter1/>
            <Counter2/>
        </>
    )
}

export default App;
