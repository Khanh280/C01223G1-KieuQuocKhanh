import "bootstrap/dist/css/bootstrap-grid.css"
import "bootstrap/dist/js/bootstrap.bundle"
import "./List.css"
import React from "react";
import {Link} from "react-router-dom";
import { villa} from "../facility/villa";

function Service() {
    return (
        <>
            <div style={{backgroundImage: "url('https://furamavietnam.com/wp-content/uploads/2018/08/banner01.jpg?id=1433')",height: '40vh',position: "relative"}}>
                <h1 style={{    transform: 'translate(-50%, -50%)',
                    top: '50%',
                    position: 'absolute',
                    left: '50%',
                    color: 'white'}}>ROOMS & SUITES</h1>
            </div>
            <div className="container">
                <div className="row col-12">
                    {
                        villa.map(villa =>(
                            <div className="card col-4 px-2 my-3" style={{border: 0}}>
                                <div className="image">
                                    <img
                                        src={villa.image}
                                        className="card-img-top"
                                        alt="..."
                                    />
                                    <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>
                                </div>
                                <div className="card-body" style={{backgroundColor: "#dee2e6"}}>
                                    <div className="row">
                                        <p className="card-text title">{villa.name}</p>
                                    </div>
                                    <div className="row ">
                                        <div className="col-7">
                                            <p className="card-text area">
                                                Room size: <span>{villa.useArea}</span> m<sup>2</sup>
                                            </p>
                                        </div>
                                        <div className="col-5 know-more d-flex">
                                            <i className="material-icons"></i>
                                            <p className="card-text">Know more</p>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-6 d-flex justify-content-center">
                                            <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>
                                        </div>
                                        <div className="col-6 d-flex justify-content-center">
                                            <button
                                                type="button"
                                                className="btn btn-sm btn-danger"
                                                data-bs-toggle="modal"
                                                data-bs-target="#exampleModal"
                                            >
                                                Delete
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))
                    }
                {/*    <div className="card col-4 px-2 my-3" style={{border: 0}}>*/}
                {/*        <div className="image">*/}
                {/*            <img*/}
                {/*                src="https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Studio-Suite-F.jpg"*/}
                {/*                className="card-img-top"*/}
                {/*                alt="..."*/}
                {/*            />*/}
                {/*                                        <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>*/}

                {/*        </div>*/}
                {/*        <div className="card-body" style={{backgroundColor: "#dee2e6"}}>*/}
                {/*            <div className="row">*/}
                {/*                <p className="card-text title">OCEAN SUITE</p>*/}
                {/*            </div>*/}
                {/*            <div className="row ">*/}
                {/*                <div className="col-7">*/}
                {/*                    <p className="card-text area">*/}
                {/*                        Room size: 85.8 m<sup>2</sup>*/}
                {/*                    </p>*/}
                {/*                </div>*/}
                {/*                <div className="col-5 know-more d-flex">*/}
                {/*                    <i className="material-icons"></i>*/}
                {/*                    <p className="card-text">Know more</p>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*            <div className="row">*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>*/}
                {/*                </div>*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <button*/}
                {/*                        type="button"*/}
                {/*                        className="btn btn-sm btn-danger"*/}
                {/*                        data-bs-toggle="modal"*/}
                {/*                        data-bs-target="#exampleModal"*/}
                {/*                    >*/}
                {/*                        Delete*/}
                {/*                    </button>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*    <div className="card col-4 px-2 my-3" style={{border: 0}}>*/}
                {/*        <div className="image">*/}
                {/*            <img*/}
                {/*                src="https://furamavietnam.com/wp-content/uploads/2018/03/Furama_Ocean_Deluxe-2-872x563.jpg"*/}
                {/*                className="card-img-top"*/}
                {/*                alt="..."*/}
                {/*            />*/}
                {/*                                        <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>*/}

                {/*        </div>*/}
                {/*        <div className="card-body" style={{backgroundColor: "#dee2e6"}}>*/}
                {/*            <div className="row">*/}
                {/*                <p className="card-text title">OCEAN DELUXE</p>*/}
                {/*            </div>*/}
                {/*            <div className="row ">*/}
                {/*                <div className="col-7">*/}
                {/*                    <p className="card-text area">*/}
                {/*                        Room size: 85.8 m<sup>2</sup>*/}
                {/*                    </p>*/}
                {/*                </div>*/}
                {/*                <div className="col-5 know-more d-flex">*/}
                {/*                    <i className="material-icons"></i>*/}
                {/*                    <p className="card-text">Know more</p>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*            <div className="row">*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>*/}
                {/*                </div>*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <button*/}
                {/*                        type="button"*/}
                {/*                        className="btn btn-sm btn-danger"*/}
                {/*                        data-bs-toggle="modal"*/}
                {/*                        data-bs-target="#exampleModal"*/}
                {/*                    >*/}
                {/*                        Delete*/}
                {/*                    </button>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*    <div className="card col-4 px-2 my-3" style={{border: 0}}>*/}
                {/*        <div className="image">*/}
                {/*            <img*/}
                {/*                src="https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Lagoon-Superior-twin-bed-F.jpg"*/}
                {/*                className="card-img-top"*/}
                {/*                alt="..."*/}
                {/*            />*/}
                {/*                                        <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>*/}

                {/*        </div>*/}
                {/*        <div className="card-body" style={{backgroundColor: "#dee2e6"}}>*/}
                {/*            <div className="row">*/}
                {/*                <p className="card-text title">LAGOON SUPERIOR</p>*/}
                {/*            </div>*/}
                {/*            <div className="row ">*/}
                {/*                <div className="col-7">*/}
                {/*                    <p className="card-text area">*/}
                {/*                        Room size: 85.8 m<sup>2</sup>*/}
                {/*                    </p>*/}
                {/*                </div>*/}
                {/*                <div className="col-5 know-more d-flex">*/}
                {/*                    <i className="material-icons"></i>*/}
                {/*                    <p className="card-text">Know more</p>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*            <div className="row">*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>*/}
                {/*                </div>*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <button*/}
                {/*                        type="button"*/}
                {/*                        className="btn btn-sm btn-danger"*/}
                {/*                        data-bs-toggle="modal"*/}
                {/*                        data-bs-target="#exampleModal"*/}
                {/*                    >*/}
                {/*                        Delete*/}
                {/*                    </button>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*    <div className="card col-4 px-2 my-3" style={{border: 0}}>*/}
                {/*        <div className="image">*/}
                {/*            <img*/}
                {/*                src="https://furamavietnam.com/wp-content/uploads/2018/03/Furama_Garden-Deluxe-5-872x563.jpg"*/}
                {/*                className="card-img-top"*/}
                {/*                alt="..."*/}
                {/*            />*/}
                {/*                                        <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>*/}

                {/*        </div>*/}
                {/*        <div className="card-body" style={{backgroundColor: "#dee2e6"}}>*/}
                {/*            <div className="row">*/}
                {/*                <p className="card-text title">GARDEN DELUXE</p>*/}
                {/*            </div>*/}
                {/*            <div className="row ">*/}
                {/*                <div className="col-7">*/}
                {/*                    <p className="card-text area">*/}
                {/*                        Room size: 85.8 m<sup>2</sup>*/}
                {/*                    </p>*/}
                {/*                </div>*/}
                {/*                <div className="col-5 know-more d-flex">*/}
                {/*                    <i className="material-icons"></i>*/}
                {/*                    <p className="card-text">Know more</p>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*            <div className="row">*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>*/}
                {/*                </div>*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <button*/}
                {/*                        type="button"*/}
                {/*                        className="btn btn-sm btn-danger"*/}
                {/*                        data-bs-toggle="modal"*/}
                {/*                        data-bs-target="#exampleModal"*/}
                {/*                    >*/}
                {/*                        Delete*/}
                {/*                    </button>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*    <div className="card col-4 px-2 my-3" style={{border: 0}}>*/}
                {/*        <div className="image">*/}
                {/*            <img*/}
                {/*                src="https://furamavietnam.com/wp-content/uploads/2018/03/Presidential-Suite-F.jpg"*/}
                {/*                className="card-img-top"*/}
                {/*                alt="..."*/}
                {/*            />*/}
                {/*                                        <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>*/}

                {/*        </div>*/}
                {/*        <div className="card-body" style={{backgroundColor: "#dee2e6"}}>*/}
                {/*            <div className="row">*/}
                {/*                <p className="card-text title">PRESIDENTIAL SUITE</p>*/}
                {/*            </div>*/}
                {/*            <div className="row ">*/}
                {/*                <div className="col-7">*/}
                {/*                    <p className="card-text area">*/}
                {/*                        Room size: 85.8 m<sup>2</sup>*/}
                {/*                    </p>*/}
                {/*                </div>*/}
                {/*                <div className="col-5 know-more d-flex">*/}
                {/*                    <i className="material-icons"></i>*/}
                {/*                    <p className="card-text">Know more</p>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*            <div className="row">*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>*/}
                {/*                </div>*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <button*/}
                {/*                        type="button"*/}
                {/*                        className="btn btn-sm btn-danger"*/}
                {/*                        data-bs-toggle="modal"*/}
                {/*                        data-bs-target="#exampleModal"*/}
                {/*                    >*/}
                {/*                        Delete*/}
                {/*                    </button>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*    <div className="card col-4 px-2 my-3" style={{border: 0}}>*/}
                {/*        <div className="image">*/}
                {/*            <img*/}
                {/*                src="https://furamavietnam.com/wp-content/uploads/2018/08/Vietnam_Danang_Furama_Villas_Beach_Pool_Villas-_Exterior-1-F.jpg"*/}
                {/*                className="card-img-top"*/}
                {/*                alt="..."*/}
                {/*            />*/}
                {/*                                        <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>*/}

                {/*        </div>*/}
                {/*        <div className="card-body" style={{backgroundColor: "#dee2e6"}}>*/}
                {/*            <div className="row">*/}
                {/*                <p className="card-text title">BEACH FRONT VILLAS</p>*/}
                {/*            </div>*/}
                {/*            <div className="row ">*/}
                {/*                <div className="col-7">*/}
                {/*                    <p className="card-text area">*/}
                {/*                        Room size: 85.8 m<sup>2</sup>*/}
                {/*                    </p>*/}
                {/*                </div>*/}
                {/*                <div className="col-5 know-more d-flex">*/}
                {/*                    <i className="material-icons"></i>*/}
                {/*                    <p className="card-text">Know more</p>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*            <div className="row">*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>*/}
                {/*                </div>*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <button*/}
                {/*                        type="button"*/}
                {/*                        className="btn btn-sm btn-danger"*/}
                {/*                        data-bs-toggle="modal"*/}
                {/*                        data-bs-target="#exampleModal"*/}
                {/*                    >*/}
                {/*                        Delete*/}
                {/*                    </button>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*    <div className="card col-4 px-2 my-3" style={{border: 0}}>*/}
                {/*        <div className="image">*/}
                {/*            <img*/}
                {/*                src="https://furamavietnam.com/wp-content/uploads/2018/08/Vietnam_Danang_Furama_Villas_Pool_Villas-F.jpg"*/}
                {/*                className="card-img-top"*/}
                {/*                alt="..."*/}
                {/*            />*/}
                {/*                                        <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>*/}

                {/*        </div>*/}
                {/*        <div className="card-body" style={{backgroundColor: "#dee2e6"}}>*/}
                {/*            <div className="row">*/}
                {/*                <p className="card-text title">POOL VILLAS</p>*/}
                {/*            </div>*/}
                {/*            <div className="row ">*/}
                {/*                <div className="col-7">*/}
                {/*                    <p className="card-text area">*/}
                {/*                        Room size: 85.8 m<sup>2</sup>*/}
                {/*                    </p>*/}
                {/*                </div>*/}
                {/*                <div className="col-5 know-more d-flex">*/}
                {/*                    <i className="material-icons"></i>*/}
                {/*                    <p className="card-text">Know more</p>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*            <div className="row">*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>*/}
                {/*                </div>*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <button*/}
                {/*                        type="button"*/}
                {/*                        className="btn btn-sm btn-danger"*/}
                {/*                        data-bs-toggle="modal"*/}
                {/*                        data-bs-target="#exampleModal"*/}
                {/*                    >*/}
                {/*                        Delete*/}
                {/*                    </button>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*    <div className="card col-4 px-2 my-3" style={{border: 0}}>*/}
                {/*        <div className="image">*/}
                {/*            <img*/}
                {/*                src="https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-768x497.jpg"*/}
                {/*                className="card-img-top"*/}
                {/*                alt="..."*/}
                {/*            />*/}
                {/*                                        <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>*/}

                {/*        </div>*/}
                {/*        <div className="card-body" style={{backgroundColor: "#dee2e6"}}>*/}
                {/*            <div className="row">*/}
                {/*                <p className="card-text title">OCEAN SUITE</p>*/}
                {/*            </div>*/}
                {/*            <div className="row ">*/}
                {/*                <div className="col-7">*/}
                {/*                    <p className="card-text area">*/}
                {/*                        Room size: 85.8 m<sup>2</sup>*/}
                {/*                    </p>*/}
                {/*                </div>*/}
                {/*                <div className="col-5 know-more d-flex">*/}
                {/*                    <i className="material-icons"></i>*/}
                {/*                    <p className="card-text">Know more</p>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*            <div className="row">*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <Link to="/edit-service" className="btn btn-sm btn-warning">Edit</Link>*/}
                {/*                </div>*/}
                {/*                <div className="col-6 d-flex justify-content-center">*/}
                {/*                    <button*/}
                {/*                        type="button"*/}
                {/*                        className="btn btn-sm btn-danger"*/}
                {/*                        data-bs-toggle="modal"*/}
                {/*                        data-bs-target="#exampleModal"*/}
                {/*                    >*/}
                {/*                        Delete*/}
                {/*                    </button>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                </div>
            </div>
            <div className="page-content page-container" id="page-content">
                <div className="padding">
                    <div className="row container d-flex justify-content-center">
                        <div className="col-md-4 col-sm-6 grid-margin stretch-card">
                            <div className="card-body">
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
                        </div>
                    </div>
                </div>
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

export default Service;