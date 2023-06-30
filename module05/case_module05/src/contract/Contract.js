import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {getAllContract} from "../redux/actions/contract/contract";
import {getAllCustomer} from "../redux/actions/customer/customer";
import axios from "axios";
import {getAllRoom} from "../redux/actions/room/room";

function Contract() {
    const contracts = useSelector(state => state.contract)
    const dispatch = useDispatch()
    const [customers, setCustomer] = useState([])
    const [services, setService] = useState([])
    const [page, setPage] = useState()
    const getAllCustomer = async () => {
        const res = await axios.get("http://localhost:8080/customer")
        setCustomer(res.data)
    }
    const currentPage = () => {
        const items = [];
        for (let i = 1; i <= page; i++) {
            items.push(
                <li className="page-item">
                    <button className="page-link" data-abc="true" onClick={() => dispatch(getAllContract(i))}>
                        {i}
                    </button>
                </li>
            )
        }
        return items;
    }
    const getPage = async () => {
        const res = await axios.get(`http://localhost:8080/contract?_page=1&_limit=6`);
        setPage(Math.ceil((res.headers['x-total-count']) / 6));
    };
    const getService = async ()=>{
        const res = await axios.get("http://localhost:8080/villa")
        setService(res.data)
    }
    useEffect(() => {
        getPage()
        getService()
        dispatch(getAllContract())
        getAllCustomer()
    }, [])
    return (
        <div style={{height: "66vh"}}>
            <div align="center">
                <h1>Contract Service</h1>
                <Link to="/customer" className="btn btn-sm btn-info mb-2">Create Contract</Link>
            </div>
            <table className="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Contract Code</th>
                    <th>Customer</th>
                    <th>Service Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Deposit</th>
                    <th>Payment deposit</th>
                </tr>
                </thead>
                <tbody>
                {
                    contracts.map((contract, index) => (
                        <tr key={index}>
                            <td>CT{contract.id}</td>
                            <td>{
                                customers.find((customer) => customer.id === contract.customerId)?.name
                            }</td>
                            <td>{
                                services.find((service) => service.id === contract.serviceId)?.name
                            }</td>
                            <td>{contract.startDate}</td>
                            <td>{contract.endDate}</td>
                            <td>{contract.deposit}</td>
                            <td>{contract.paymentDeposit}</td>
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
        </div>

    )
}

export default Contract;