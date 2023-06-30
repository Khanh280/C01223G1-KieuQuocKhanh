import {Link} from "react-router-dom";
import React, {useEffect, useState} from "react";
import axios from "axios";
import {useDispatch, useSelector} from "react-redux";
import {deleteCustomerById, getAllCustomer} from "../redux/actions/customer/customer";
import Swal from "sweetalert2";
import {getAllRoom} from "../redux/actions/room/room";


function Customer() {
    const customers = useSelector(state => state.customer)
    const [typeCustomers, setTypeCustomer] = useState([])
    const [customersDelete, setCustomerDelete] = useState({})
    const dispatch = useDispatch()
    const [page, setPage] = useState()
    const deleteCustomer = (id) => {
        dispatch(deleteCustomerById(id))
        Swal.fire({
            icon: "success",
            title: "Delete Customer Success",
            timer: "2000"
        })
    }
    const currentPage = () => {
        const items = [];
        for (let i = 1; i <= page; i++) {
            items.push(
                <li className="page-item">
                    <button className="page-link" data-abc="true" onClick={() => dispatch(getAllCustomer(i))}>
                        {i}
                    </button>
                </li>
            )
        }
        return items;
    }
    const getAllTypeCustomer = async () => {
        const res = await axios.get("http://localhost:8080/typeCustomer")
        setTypeCustomer(res.data)
    }
    useEffect(() => {
        dispatch(getAllCustomer())
        getAllTypeCustomer()
    }, [])
    useEffect(()=>{
        const getPage = async () => {
            const res = await axios.get(`http://localhost:8080/customer?_page=1&_limit=6`);
            setPage(Math.ceil((res.headers['x-total-count']) / 6));
        };
        getPage()
    },[customers])
    return (
        <div className="" style={{height: "83vh"}}>
            <div align="center">
                <h1>Customer List</h1>
                <Link to="/create-customer" className="btn btn-sm btn-info mb-2">Create Customer</Link>
            </div>
            <table className="table table-striped table-hover ">
                <thead>
                <tr>
                    <th>Customer Name</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>Citizenship ID</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Types Customer</th>
                    <th>Address</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    customers.map((customer, index) => (
                        <tr key={index}>
                            <td>{customer.name}</td>
                            <td>{customer.birthday}</td>
                            <td>{customer.gender}</td>
                            <td>{customer.citizenshipId}</td>
                            <td>{customer.phoneNumber}</td>
                            <td>{customer.email}</td>
                            <td>{typeCustomers.find((type) => type.id === customer.typeCustomerId)?.name}</td>
                            <td>{customer.address}</td>
                            <td style={{display: "flex", justifyContent: "space-evenly"}}>
                                <Link to={`/edit-customer/${customer.id}`} className="btn  btn-warning ">Edit</Link>
                                <button
                                    type="button"
                                    className="btn  btn-danger "
                                    data-bs-toggle="modal"
                                    data-bs-target="#exampleModal"
                                    onClick={() => setCustomerDelete({
                                        id: customer.id,
                                        name: customer.name
                                    })}
                                >
                                    Delete
                                </button>
                                <Link to={`/create-contract/${customer.id}`}
                                    type="button"
                                    className="btn b btn-info m-0 p-1"
                                >
                                    Create Contract
                                </Link>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            <div className="page-content page-container" id="page-content">
                <nav>
                    <ul className="pagination flex-wrap d-flex justify-content-center">
                        <li className="page-item">
                            <a className="page-link" href="#" data-abc="true">
                                <i className="fa fa-angle-left"/>
                            </a>
                        </li>
                        {
                            currentPage()
                        }
                        <li className="page-item">
                            <a className="page-link" href="#" data-abc="true">
                                <i className="fa fa-angle-right"/>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div
                className="modal fade"
                id="exampleModal"
                tabIndex={-1}
                aria-labelledby="exampleModalLabel"
                aria-hidden="true"
            >
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h1 className="modal-title fs-5" id="exampleModalLabel">
                                Delete Service
                            </h1>
                            <button
                                type="button"
                                className="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"
                            />
                        </div>
                        <div className="modal-body">
                            Do you confirm the removal of the <span style={{color: "red"}}>{customersDelete.name}</span>?
                        </div>
                        <div className="modal-footer">
                            <button
                                type="button"
                                className="btn btn-secondary"
                                data-bs-dismiss="modal"
                            >
                                No
                            </button>
                            <button type="button" className="btn btn-danger" data-bs-dismiss="modal"
                                    onClick={() => deleteCustomer(customersDelete.id)}>
                                Yes
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Customer;