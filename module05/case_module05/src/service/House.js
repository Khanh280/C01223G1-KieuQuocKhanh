import "bootstrap/dist/css/bootstrap-grid.css"
import "bootstrap/dist/js/bootstrap.bundle"
import "./List.css"
import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {deleteHouseById, getAllHouse} from "../redux/actions/house/house";
import {deleteVillaById, getAllVilla} from "../redux/actions/villa/villa";
import Swal from "sweetalert2";
import axios from "axios";

function House() {
    const house = useSelector(state => state.house)
    const dispatch = useDispatch();
    const [page, setPage] = useState()
    const [houseDelete, setHouse] = useState({
        id: '',
        name: ''
    })

    const currentPage = () => {
        const items = [];
        for (let i = 1; i <= page; i++) {
            items.push(
                <li className="page-item">
                    <button className="page-link" data-abc="true" onClick={() => dispatch(getAllHouse(i))}>
                        {i}
                    </button>
                </li>
            )
        }
        return items;
    }
    const deleteHouse = (id) => {
        dispatch(deleteHouseById(id))
        dispatch(getAllHouse())
        Swal.fire({
            icon: "success",
            title: "Delete Success",
            timer: "2000"
        })
    }
    useEffect(() => {

        dispatch(getAllHouse())
    }, [])
    useEffect(()=>{
        const getPage = async () => {
            const res = await axios.get(`http://localhost:8080/house?_page=1&_limit=8`);
            setPage(Math.ceil((res.headers['x-total-count']) / 8));
        };
        getPage()
    },[house])
    if (!house) return null
    return (
        <>
            <div style={{
                backgroundImage: "url('https://furamavietnam.com/wp-content/uploads/2018/10/Vietnam_Danang_Furama_Resort_Exterior-Courtyard-Ocean-Pool.jpg?id=2350')",
                backgroundSize: "cover", height: '40vh', position: "relative"
            }}>
                <h1 style={{
                    transform: 'translate(-50%, -50%)',
                    top: '50%',
                    position: 'absolute',
                    left: '50%',
                    color: 'white'
                }}>HOUSE & SUITES</h1>
            </div>
            <div className="container" style={{height: "83vh"}}>
                <div className="row col-12">
                    {
                        house.map(house => (
                            <div className="card col-3 px-2 mt-3" style={{border: 0}}>
                                <div className="image" style={{height: "20.3vh"}}>
                                    <img
                                        src={house.image}
                                        className="card-img-top"
                                        alt="Image Not Found"
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
                                            <Link to={`/edit-service/${house.id}/${house.serviceTypeId}`}
                                                  className="btn btn-sm btn-warning">Edit</Link>
                                        </div>
                                        <div className="col-6 d-flex justify-content-center">
                                            <button
                                                type="button"
                                                className="btn btn-sm btn-danger"
                                                data-bs-toggle="modal"
                                                data-bs-target="#exampleModal"
                                                onClick={() => setHouse({
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
                            <button type="button" className="btn btn-danger" data-bs-dismiss="modal"
                                    onClick={() => deleteHouse(houseDelete.id)}>
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