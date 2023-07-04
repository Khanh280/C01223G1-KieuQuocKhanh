import React, {useEffect, useState} from "react";
import axios from "axios";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate} from "react-router";
import * as yup from "yup"
import "react-toastify/dist/ReactToastify.css"
import Swal from "sweetalert2";
import {Link} from "react-router-dom";

export default function CreateOrder() {
    const [products, setProduct] = useState([])
    const [productSelect, setProductSelect] = useState(0)
    const navigate = useNavigate()
    const getAllProduct = async () => {
        await axios.get("http://localhost:8080/api/admin/product")
            .then(res => {
                setProduct(res.data)
            })
            .catch(error => {
                console.log(error)
            })
    }
    const createOrder = async (order) => {
        console.log("shahgdvbfhja")
        await axios.post("http://localhost:8080/api/admin/order/create", order)
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
        getAllProduct()
    }, [])
    if (!products) {
        return null;
    }
    return (
        <div>
            <div className="container mt-5 mb-5">
                <div className="row height d-flex justify-content-center align-items-center">
                    <div className="col-md-6">
                        <div className="card px-5 py-4">

                            <div style={{textAlign: "center"}}>
                                <h1>Create Order</h1>
                            </div>
                            <Formik
                                initialValues={{
                                    id: '',
                                    productId: '',
                                    buyDate: '',
                                    quantity: '',
                                    totalPrice: ''
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
                                    console.log(values.buyDate)
                                    createOrder({
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
                                        <Field type="number" value={productSelect?.price || 0} className="form-control"
                                               readOnly/>
                                    </div>
                                    <div className="mt-2 inputs"><span>Buy Date</span>
                                        <Field type="date" name="buyDate" className="form-control"/>
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
                                                <b>Create</b>
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