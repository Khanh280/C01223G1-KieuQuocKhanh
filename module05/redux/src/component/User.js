import React, {useEffect} from "react";
import "bootstrap/dist/css/bootstrap.css"
import {useDispatch, useSelector} from "react-redux";
import {getAllUsers} from "../redux/actions/users";
import "react-toastify/dist/ReactToastify.css"
import {UserList} from "./UserList";

export function User() {
    // const users = useSelector(state => state.users)
    const dispatch = useDispatch();
    const getUsers = () => {
        dispatch(getAllUsers())
    }
    return (
        <div>
            <div align="center">
                <h1>User List</h1>
                <button className="btn btn-outline-dark" onClick={()=> getUsers()}>Get users</button>
            </div>
        </div>
    )
}