import React from "react";
import {Link} from "react-router-dom";

function Contract() {
return(
    <>
        <div align="center">
            <h1>Contract Service</h1>
            <Link to="/create-contract" className="btn btn-sm btn-primary" >Create Contract</Link>
        </div>
        <table className="table table-striped table-hover">
            <thead>
            <tr>
                <th>Contract Code</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Deposit</th>
                <th>Payment deposit</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>VL-0001</td>
                <td>22/06/2023</td>
                <td>25/06/2023</td>
                <td>1000</td>
                <td>3000</td>
            </tr>
            <tr>
                <td>HO-0002</td>
                <td>22/06/2023</td>
                <td>23/06/2023</td>
                <td>1500</td>
                <td>2000</td>
            </tr>
            <tr>
                <td>RO-0001</td>
                <td>22/06/2023</td>
                <td>30/06/2023</td>
                <td>1000</td>
                <td>5000</td>
            </tr>
            <tr>
                <td>VL-0002</td>
                <td>22/06/2023</td>
                <td>25/06/2023</td>
                <td>1200</td>
                <td>3000</td>
            </tr>
            <tr>
                <td>VL-0003</td>
                <td>24/06/2023</td>
                <td>25/06/2023</td>
                <td>500</td>
                <td>1200</td>
            </tr>
            <tr>
                <td>HO-0002</td>
                <td>22/07/2023</td>
                <td>23/07/2023</td>
                <td>1000</td>
                <td>1500</td>
            </tr>
            </tbody>
        </table>
        <div className="page-content page-container" id="page-content">
            <nav>
                <ul className="pagination flex-wrap d-flex justify-content-center">
                    <li className="page-item">
                        <a className="page-link" href="#" data-abc="true">
                            <i className="fa fa-angle-left" />
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
                            <i className="fa fa-angle-right" />
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
export default Contract;