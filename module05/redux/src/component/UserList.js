import React from "react";
import {useDispatch, useSelector} from "react-redux";
import axios from "axios";
import {deleteUserById, getAllUsers} from "../redux/actions/users";
import {toast} from "react-toastify";
import Swal from "sweetalert2";

export function UserList() {
    const users = useSelector(state => state.users)
    const dispatch = useDispatch()
    const handleDeleteUser = (id) => {
        dispatch(deleteUserById(id))
        dispatch(getAllUsers())
        Swal.fire({
            icon: "success",
            title: "Delete Success",
            timer: "2000"
        })
    }
    return (
        <>
            {
                users.length > 0 ?
                    <table className="table table-hover">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Website</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            users.map((user) => (
                                <tr key={user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.name}</td>
                                    <td>{user.email}</td>
                                    <td>{user.website}</td>
                                    <td>
                                        <button className="btn btn-outline-danger"
                                                onClick={() => handleDeleteUser(user.id)}>Delete
                                            Users
                                        </button>
                                    </td>
                                </tr>
                            ))
                        }
                        </tbody>
                    </table>
                    :
                    ''
            }
        </>
    )
}