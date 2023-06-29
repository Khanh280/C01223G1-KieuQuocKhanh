import "bootstrap/dist/css/bootstrap-grid.css"
import "bootstrap/dist/js/bootstrap.bundle"
import "./List.css"
import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {deleteRoomById, getAllRoom} from "../redux/actions/room/room";
import Swal from "sweetalert2";

function Rooms() {
    const rooms = useSelector(state => state.room)
    const dispatch = useDispatch()
    const [roomDelete, setRoom] = useState({
        id: '',
        name: ''
    })

    const deleteRoom = (id) => {
        dispatch(deleteRoomById(id))
        dispatch(getAllRoom())
        Swal.fire({
            icon: "success",
            title: "Delete Success",
            timer: "2000"
        })
    }
    useEffect(() => {
        dispatch(getAllRoom())
    }, [])
    return (
        <>
            <div style={{
                backgroundImage: "url('https://furamavietnam.com/wp-content/uploads/2022/01/Exterior_Green_Oasis_Pool_Furama_Danang_Vietnam.jpg?id=17934')",
                backgroundSize: "cover", height: '40vh', position: "relative"
            }}>
                <h1 style={{
                    transform: 'translate(-50%, -50%)',
                    top: '50%',
                    position: 'absolute',
                    left: '50%',
                    color: 'white'
                }}>ROOMS & SUITES</h1>
            </div>
            <div className="container">
                <div className="row col-12">
                    {
                        rooms.map(rooms => (
                            <div className="card col-4 px-2 my-3" style={{border: 0}}>
                                <div className="image">
                                    <img
                                        src={rooms.image}
                                        className="card-img-top"
                                        alt="..."
                                    />
                                    <Link to="/create-service" className="btn btn-sm book-now">Book now</Link>
                                </div>
                                <div className="card-body" style={{backgroundColor: "#dee2e6"}}>
                                    <div className="row">
                                        <p className="card-text title">{rooms.name}</p>
                                    </div>
                                    <div className="row ">
                                        <div className="col-7">
                                            <p className="card-text area">
                                                Room size: <span>{rooms.useArea}</span> m<sup>2</sup>
                                            </p>
                                        </div>
                                        <div className="col-5 know-more d-flex">
                                            <i className="material-icons"></i>
                                            <p className="card-text">Know more</p>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col-6 d-flex justify-content-center">
                                            <Link to={`/edit-service/${rooms.id}/${rooms.serviceTypeId}`}
                                                  className="btn btn-sm btn-warning">Edit</Link>
                                        </div>
                                        <div className="col-6 d-flex justify-content-center">
                                            <button
                                                type="button"
                                                className="btn btn-sm btn-danger"
                                                data-bs-toggle="modal"
                                                data-bs-target="#exampleModal"
                                                onClick={() => setRoom({
                                                    id: rooms.id,
                                                    name: rooms.name
                                                })}
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
                            Do you confirm the removal of the <span style={{color: "red"}}>{roomDelete.name}</span>?
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
                                    onClick={() => deleteRoom(roomDelete.id)}>
                                Yes
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Rooms;