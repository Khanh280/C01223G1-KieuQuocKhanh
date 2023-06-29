import {Link} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";

function Customer() {
    const [customers, setCustomer] = useState([])
    const [typeCustomers, setTypeCustomer] = useState([])
    const getAllCustomer = async () => {
        const res = await axios.get("http://localhost:8080/customer")
        setCustomer(res.data)
    }
    const getAllTypeCustomer = async () => {
        const res = await axios.get("http://localhost:8080/typeCustomer")
        setTypeCustomer(res.data)
    }
    useEffect(() => {
        getAllTypeCustomer()
        getAllCustomer()
    })
    return (
        <>
            <div align="center">
                <h1>Customer List</h1>
                <Link to="/create-customer" className="btn btn-sm btn-primary mb-2">Create</Link>
            </div>
            <table className="table table-striped table-hover">
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
                    customers.map((customer,index) => (
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
                                <Link to="/edit-customer" className="btn  btn-warning">Edit</Link>
                                <button
                                    type="button"
                                    className="btn  btn-danger"
                                    data-bs-toggle="modal"
                                    data-bs-target="#exampleModal"
                                >
                                    Delete
                                </button>
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
                        <li className="page-item active">
                            <a className="page-link" href="#" data-abc="true">
                                1
                            </a>
                        </li>
                        <li className="page-item">
                            <a className="page-link" href="#" data-abc="true">
                                2
                            </a>
                        </li>
                        <li className="page-item">
                            <a className="page-link" href="#" data-abc="true">
                                3
                            </a>
                        </li>
                        <li className="page-item">
                            <a className="page-link" href="#" data-abc="true">
                                4
                            </a>
                        </li>
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
                            Do you confirm the removal of the service?
                        </div>
                        <div className="modal-footer">
                            <button
                                type="button"
                                className="btn btn-secondary"
                                data-bs-dismiss="modal"
                            >
                                No
                            </button>
                            <button type="button" className="btn btn-danger">
                                Yes
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Customer;