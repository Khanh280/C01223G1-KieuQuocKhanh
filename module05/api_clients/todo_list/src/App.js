
import './App.css';
import {TodoList} from "./component/TodoList";
import React from "react";
import {ToastContainer} from "react-toastify";

function App() {
    return (
       <>
          <TodoList/>
          <ToastContainer/>
       </>
    )
}

export default App;
