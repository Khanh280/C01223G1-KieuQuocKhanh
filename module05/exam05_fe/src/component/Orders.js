import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link} from "react-router-dom";
import {Field, Form, Formik} from "formik";
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap"


export default function Orders() {
    const [orders, setOrder] = useState([])
    const [products, setProduct] = useState([])
    const [orderDelete, setOrderDelete] = useState({
        id: '',
        name: ''
    })
    // const getAllOrder = async () => {
    //     // const orderRes = (await axios.get("http://localhost:8080/orders")).data
    //     // const productRes = (await axios.get("http://localhost:8080/products")).data
    //     // setProduct(productRes);
    //     //
    //     // for (let order of orderRes) {
    //     //     order.product = productRes.filter(p => p.id === order.productId)[0];
    //     // }
    //     // orderRes.sort((o1, o2) => o1.product.price - o2.product.price)
    //     // setOrder(orderRes);
    // }

    // const getAllProduct = async () => {
    //     const res = await axios.get("http://localhost:8080/products")
    //     setProduct(res.data)
    // }

    // const getOrder= async ()=>{
    //     axios.get("http://localhost:8080/api/admin/order")
    //         .then(res => {
    //             setOrder(res.data)
    //         }).catch(error=>{
    //         console.log(error)
    //     })
    // }
    const deleteOrder = async (id) => {
        axios.delete("http://localhost:8080/api/admin/order/" + id)
            .then(res => {
                setOrder(res.data)
            })
            .catch(error => {
                console.log(error)
            })
    }
    useEffect(() => {
        axios.get("http://localhost:8080/api/admin/order")
            .then(res => {
                setOrder(res.data)
            }).catch(error => {
            console.log(error)
        })
        // getOrder()
        // getAllOrder()
        // getAllProduct()
    }, [])
    return (
        <>
            <div align="center"><h1>Orders List</h1></div>
            <div align="center"><Link to="/create-order" className="btn btn-sm btn-primary">Create</Link>
            </div>
            <div align="center">
                <Formik
                    initialValues={{
                        startDate: '',
                        endDate: '',
                        productId: ''
                    }}
                    onSubmit={(values) => {
                        const searchOrder = async () => {
                            const res = (await axios.get("http://localhost:8080/orders?buyDate_lte=" + values.buyDate
                                + "&buyDate_gte=" + values.endDate
                                + "&productId_like=" + values.productId)).data
                            // for (let order of res) {
                            //     order.product = products.filter(p => p.id === order.productId)[0];
                            // }
                            //
                            // res.sort((o1, o2) => o1.product.price - o2.product.price)
                            // setOrder(res);
                        }
                        searchOrder()
                    }}>
                    <Form className="mt-2">
                        <div className="row col-12">
                            <div className="col-2"></div>


                            <div className="col-2">
                                <span>Start Date</span>
                                <Field className="form-control" name="endDate" type="date"/>
                            </div>
                            <div className="col-2">
                                <span>End Date</span>
                                <Field className="form-control" name="buyDate" type="date"/>
                            </div>

                            <div className="col-3">
                                <span>Product</span>
                                <Field type="text" as="select" name="productId" className="form-control">
                                    <option value="">Select Product</option>
                                    {
                                        products.map((product, index) =>
                                            <option key={index} value={product.id}>{product.name}</option>
                                        )
                                    }
                                </Field>
                            </div>
                            <div className="col-2"></div>

                        </div>
                        <div className="mt-2">
                            <button type="submit" className="btn btn-sm btn-primary">Search</button>
                        </div>
                    </Form>
                </Formik>
            </div>
            <div>
                {
                    orders.length > 0 ?
                        <table className="table table-hover">
                            <thead>
                            <tr>
                                <th>Index</th>
                                <th>Order Code</th>
                                <th>Product Name</th>
                                <th>Price(USD)</th>
                                <th>Types</th>
                                <th>Buy Date</th>
                                <th>Quantity</th>
                                <th>Total Price(USD)</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                orders.map((order, index) =>
                                    <tr key={index}>
                                        <td>{index + 1}</td>
                                        <td>{order.id}</td>
                                        <td>{
                                            order.product?.name
                                        }</td>
                                        <td>{
                                            order.product?.price
                                        }</td>
                                        <td>{
                                            order.product?.productType
                                        }</td>
                                        <td>{order.buyDate}</td>
                                        <td>{order.quantity}</td>
                                        <td>{
                                            order.totalPrice
                                        }</td>
                                        <td>
                                            <Link to={`/update-order/${order.id}`} className="btn btn-sm btn-warning">Edit</Link>
                                            <button className="btn btn-sm btn-danger ms-2"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#exampleModal"
                                                    onClick={() => setOrderDelete({
                                                        id: order.id,
                                                        name: order.product.name
                                                    })
                                                    }
                                            >Delete
                                            </button>
                                        </td>
                                    </tr>
                                )
                            }
                            </tbody>
                        </table>
                        :
                        <div align="center">
                            <h1>Order Not Found</h1>
                        </div>
                }
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
                                Delete Product
                            </h1>
                            <button
                                type="button"
                                className="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"
                            />
                        </div>
                        <div className="modal-body">
                            Do you confirm the removal of the <span style={{color: "red"}}>{orderDelete.name}</span>?
                        </div>
                        <div className="modal-footer">
                            <button
                                type="button"
                                className="btn btn-secondary"
                                data-bs-dismiss="modal"
                            >
                                No
                            </button>
                            <button onClick={() => deleteOrder(orderDelete.id)} type="button"
                                    data-bs-dismiss="modal"
                                    className="btn btn-danger"
                            >
                                Yes
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}