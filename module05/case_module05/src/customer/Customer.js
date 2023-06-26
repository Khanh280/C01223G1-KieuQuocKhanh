import {Link} from "react-router-dom";

function Customer() {
    return (
        <>
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
                <tr>
                    <td>Kieu Quoc Khanh</td>
                    <td>28/08/2001</td>
                    <td>Male</td>
                    <td>9999999999</td>
                    <td>0123221364</td>
                    <td>Khanhgazz50@gmail.com</td>
                    <td>Diamond</td>
                    <td>Duy Xuyen,Quang Nam</td>
                    <td style={{display: "flex",justifyContent: "space-evenly"}}>
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
                <tr>
                    <td>Nguyen Duc Thang</td>
                    <td>28/08/2001</td>
                    <td>Male</td>
                    <td>3245342545</td>
                    <td>0123221364</td>
                    <td>ducthang50@gmail.com</td>
                    <td>Diamond</td>
                    <td>Hoa Xuan,Da Nang</td>
                    <td style={{display: "flex",justifyContent: "space-evenly"}}>
                         <Link to="/edit-customer" className="btn  btn-warning">Edit</Link>
                        <button
                            type="button"
                            className="btn btn-sm btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                        >
                            Delete
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>Huynh Duc Dinh</td>
                    <td>28/08/2001</td>
                    <td>Male</td>
                    <td>7634573848</td>
                    <td>0123221364</td>
                    <td>ducdinh50@gmail.com</td>
                    <td>Diamond</td>
                    <td>Que Son,Quang Nam</td>
                    <td style={{display: "flex",justifyContent: "space-evenly"}}>
                         <Link to="/edit-customer" className="btn  btn-warning">Edit</Link>
                        <button
                            type="button"
                            className="btn btn-sm btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                        >
                            Delete
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>Phan Vu An Khang</td>
                    <td>28/08/2001</td>
                    <td>Male</td>
                    <td>9999999999</td>
                    <td>0123221364</td>
                    <td>ankhang50@gmail.com</td>
                    <td>Diamond</td>
                    <td>Hai Chau, Da Nang</td>
                    <td style={{display: "flex",justifyContent: "space-evenly"}}>
                         <Link to="/edit-customer" className="btn  btn-warning">Edit</Link>
                        <button
                            type="button"
                            className="btn btn-sm btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                        >
                            Delete
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>Truong Quoc Hoa</td>
                    <td>28/08/2001</td>
                    <td>Male</td>
                    <td>9999999999</td>
                    <td>0123221364</td>
                    <td>quochoa50@gmail.com</td>
                    <td>Diamond</td>
                    <td>Hai Chau, Da Nang</td>
                    <td style={{display: "flex",justifyContent: "space-evenly"}}>
                         <Link to="/edit-customer" className="btn  btn-warning">Edit</Link>
                        <button
                            type="button"
                            className="btn btn-sm btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                        >
                            Delete
                        </button>
                    </td>
                </tr>
                <tr>
                    <td>Ho Truong An</td>
                    <td>28/08/2001</td>
                    <td>Male</td>
                    <td>9999999999</td>
                    <td>0123221364</td>
                    <td>truonganzz50@gmail.com</td>
                    <td>Diamond</td>
                    <td>Da Nang</td>
                    <td style={{display: "flex",justifyContent: "space-evenly"}}>
                         <Link to="/edit-customer" className="btn  btn-warning">Edit</Link>
                        <button
                            type="button"
                            className="btn btn-sm btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                        >
                            Delete
                        </button>
                    </td>
                </tr>
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