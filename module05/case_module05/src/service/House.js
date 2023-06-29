import "bootstrap/dist/css/bootstrap-grid.css"
import "bootstrap/dist/js/bootstrap.bundle"
import "./List.css"
import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {deleteHouseById, getAllHouse} from "../redux/actions/house/house";
import {deleteVillaById, getAllVilla} from "../redux/actions/villa/villa";
import Swal from "sweetalert2";

function House() {
    const house = useSelector(state => state.house)
    const dispatch = useDispatch();
    const [houseDelete, setHouse] = useState({
        id: '',
        name: ''
    })
    useEffect(()=>{
        dispatch(getAllHouse())
    },[])
    const deleteHouse = (id) =>{
        dispatch(deleteHouseById(id))
        dispatch(getAllHouse())
        Swal.fire({
            icon: "success",
            title: "Create Success",
            timer: "2000"
        })
    }
    if(!house) return null
    return (
        <>
            <div style={{backgroundImage: "url('https://furamavietnam.com/wp-content/uploads/2018/10/Vietnam_Danang_Furama_Resort_Exterior-Courtyard-Ocean-Pool.jpg?id=2350')",
                backgroundSize: "cover",height: '40vh',position: "relative"}}>
                <h1 style={{    transform: 'translate(-50%, -50%)',
                    top: '50%',
                    position: 'absolute',
                    left: '50%',
                    color: 'white'}}>HOUSE & SUITES</h1>
            </div>
            <div className="container">
                <div className="row col-12">
                    {
                        house.map(house =>(
                            <div className="card col-4 px-2 my-3" style={{border: 0}}>
                                <div className="image">
                                    <img
                                        src={house.image}
                                        className="card-img-top"
                                        alt="..."
                                    />
                                    <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>
                                </div>
                                <div className="card-body" style={{backgroundColor: "#dee2e6"}}>
                                    <div className="row">
                                        <p className="card-text title">{house.name}</p>
                                    </div>
                                    <div className="row ">
                                        <div className="col-7">
                                            <p className="card-text area">
                                                Room size: <span>{house.useArea}</span> m<sup>2</sup>
                                            </p>
                                        </div>
                                        <div className="col-5 know-more d-flex">
                                            <i className="material-icons"></i>
                                            <p className="card-text">Know more</p>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-6 d-flex justify-content-center">
                                            <Link to={`/edit-service/${house.id}/${house.serviceTypeId}`} className="btn btn-sm btn-warning">Edit</Link>
                                        </div>
                                        <div className="col-6 d-flex justify-content-center">
                                            <button
                                                type="button"
                                                className="btn btn-sm btn-danger"
                                                data-bs-toggle="modal"
                                                data-bs-target="#exampleModal"
                                                onClick={()=>setHouse({
                                                    id: house.id,
                                                    name: house.name
                                                })
                                                }
                                            >
                                                Delete
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))
                    }
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
                            Do you confirm the removal of the <span style={{color: "red"}}>{houseDelete.name}</span>?
                        </div>
                        <div className="modal-footer">
                            <button
                                type="button"
                                className="btn btn-secondary"
                                data-bs-dismiss="modal"
                            >
                                No
                            </button>
                            <button type="button" className="btn btn-danger" data-bs-dismiss="modal" onClick={()=> deleteHouse(houseDelete.id)}>
                                Yes
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default House;