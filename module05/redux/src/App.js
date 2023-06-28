import './App.css';
import {User} from "./component/User";
import React from "react";
import {Provider} from "react-redux";
import store from "./redux/store";
import {UserList} from "./component/UserList";
import {ToastContainer} from "react-toastify";

function App() {
    return (
        <Provider store={store}>
            <User/>
            <UserList/>
        </Provider>
    );
}

export default App;
