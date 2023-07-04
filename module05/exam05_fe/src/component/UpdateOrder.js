import React, {useEffect, useState} from "react";
import axios from "axios";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate, useParams} from "react-router";
import * as yup from "yup"
import "react-toastify/dist/ReactToastify.css"
import Swal from "sweetalert2";
import {Link} from "react-router-dom";

export default function UpdateOrder() {
    const param = useParams()
    const [products, setProduct] = useState([])
    const [productSelect, setProductSelect] = useState(0)
    const [order, setOrder] = useState()
    const navigate = useNavigate()
    const getAllOrderById = async (id) => {
        await axios.get("http://localhost:8080/api/admin/order/"+id)
            .then(res => {
                setOrder(res.data)
                setProductSelect(res.data.product)
            })
            .catch(error => {
                console.log(error)
            })
    }
    const getAllProduct = async () => {
        await axios.get("http://localhost:8080/api/admin/product")
            .then(res => {
                setProduct(res.data)
            })
            .catch(error => {
                console.log(error)
            })
    }
    const updateOrder = async (order) => {
        await axios.put("http://localhost:8080/api/admin/order/update", order)
    }
    const getProductSelect = async (id) => {
        for (let product of products) {
            if (+id === product.id) {
                setProductSelect(product)
                break;
            }else if(+id === 0){
                setProductSelect(0)
            }
        }
    }
    useEffect(() => {
        getAllOrderById(param.id)
        getAllProduct()
    }, [])
    if (!order) {
        return null;
    }
    return (
        <div>
            <div className="container mt-5 mb-5">
                <div className="row height d-flex justify-content-center align-items-center">
                    <div className="col-md-6">
                        <div className="card px-5 py-4">

                            <div style={{textAlign: "center"}}>
                                <h1>Update Order</h1>
                            </div>
                            <Formik
                                initialValues={{
                                    id: order?.id,
                                    productId: order?.product?.id,
                                    buyDate: order?.buyDate,
                                    quantity: order?.quantity,
                                    totalPrice: order?.totalPrice
                                }}
                                validationSchema={yup.object({
                                    productId: yup.number().required('Please Select Product').min(1,'Please Select Product'),
                                    buyDate: yup.date().required('Please choose buy date').test("order", "Buy Date Not invalid",
                                        function (value) {
                                            const buyDate = value.getDay()
                                            const month = value.getMonth()
                                            const year = value.getFullYear()
                                            const dateNow = new Date()
                                            if (year <= dateNow.getFullYear()) {
                                                if (month < dateNow.getMonth()) {
                                                    return true
                                                } else if (month === dateNow.getMonth()) {
                                                    if (buyDate <= dateNow.getDay()) {
                                                        return true
                                                    }
                                                }
                                            }
                                            return false;
                                        }),
                                    quantity: yup.number().required('Not Blank').min(1, 'Quantity > 0')
                                })}
                                onSubmit={(values) => {
                                    updateOrder({
                                        ...values,
                                        product: productSelect,
                                        quantity: +values.quantity,
                                        productPrice: +productSelect?.price,
                                        totalPrice: +values.quantity * productSelect?.price
                                    })
                                    navigate("/")
                                    Swal.fire({
                                        icon: "success",
                                        title: "Create Success",
                                        timer: 2000
                                    })
                                }}>
                                <Form>
                                    <div className="mt-4 inputs">
                                        <Field type="number" as="select" name="productId" className="form-control"
                                               onClick={(event) => getProductSelect(event.target.value)}>
                                            <option value={0}>Select Product</option>
                                            {
                                                products.map((product, index) =>
                                                    <option key={index} value={product.id}>{product.name}</option>
                                                )
                                            }
                                        </Field>
                                        <ErrorMessage name="productId" component="p" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-2 inputs"><span>Price</span>
                                        <Field type="number" value={productSelect?.price || order?.productPrice} className="form-control"
                                               readOnly/>
                                    </div>
                                    <div className="mt-2 inputs"><span>Buy Date</span>
                                        <Field type="datetime-local" name="buyDate" className="form-control"/>
                                        <ErrorMessage name="buyDate" component="p" style={{color: "red"}}/>
                                    </div>


                                    <div className="mt-2 inputs"><span>Quantity</span>
                                        <Field type="number" name="quantity" className="form-control" id="confirm"/>
                                        <ErrorMessage name="quantity" component="p" style={{color: "red"}}/>
                                    </div>
                                    <div className="d-flex justify-content-between">
                                        <div className="text-center mt-4 btn-group">
                                            <Link to="/" className=" btn btn-dark">
                                                <b>Back</b>
                                            </Link>
                                        </div>
                                        <div className="text-center mt-4 btn-group">
                                            <button type="submit" className=" btn btn-success integration">
                                                <b>Update</b>
                                            </button>
                                        </div>
                                    </div>

                                </Form>

                            </Formik>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    )
}