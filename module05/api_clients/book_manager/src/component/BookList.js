import React, {useEffect, useState} from "react";
import "bootstrap/dist/css/bootstrap.css"
import {Link} from "react-router-dom";
import axios from "axios";
import * as bookService from "../service/BookService"
import {toast} from "react-toastify";

export function BookList() {
    const [book, setBook] = useState([])
    const fecthApi = async () => {
        const res = await bookService.findAll()
        setBook(res)
    }
    useEffect(() => {
        fecthApi()
    }, [])
    const handleDelete = async (id) => {
        await bookService.deletes(id)
        fecthApi();
        toast.success(<h2>Delete Success</h2>)
    }
    return (
        <div>
            <div className="d-flex justify-content-between">
                <h2>Library</h2>
                <Link to='/create' className="btn btn-sm btn-success">Add a new Book</Link>
            </div>
            <div>
                <table className="table table-hover">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        book.map((book) =>
                            <tr key={book.id}>
                                <td>{book.title}</td>
                                <td>{book.quantity}</td>
                                <td>
                                    <Link to={`/update/${book.id}`} className="btn btn-warning">Edit</Link>
                                    <button className="btn btn-danger ms-2" onClick={() => handleDelete(book.id)}>Delete
                                    </button>
                                </td>
                            </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        </div>
    )
}