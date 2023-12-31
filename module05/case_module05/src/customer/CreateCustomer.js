import "../crud.css"
import React, {useEffect, useState} from "react";
import axios from "axios";
import {ErrorMessage, Field, Form, Formik} from "formik";
import Swal from "sweetalert2";
import {useDispatch} from "react-redux";
import {createCustomer} from "../redux/actions/customer/customer";
import * as yup from "yup"

function CreateCustomer() {
    const [typeCustomers, setTypeCustomer] = useState([])
    const dispatch = useDispatch()
    const getAllTypeCustomer = async () => {
        const res = await axios.get("http://localhost:8080/typeCustomer")
        setTypeCustomer(res.data)
    }
    useEffect(() => {
        getAllTypeCustomer()
    })
    return (
        <>
            <Formik
                initialValues={{
                    id: "",
                    name: "",
                    birthday: "",
                    gender: "",
                    citizenshipId: "",
                    phoneNumber: "",
                    email: "",
                    typeCustomerId: 1,
                    address: ""
                }}
                validationSchema={yup.object({
                    name: yup.string().required('Not Blank')
                        .matches(/^[A-Z][A-Za-z]* ([A-Z][A-Za-z]* )*[A-Z][A-Za-z]*$/,'Ex: Kieu Quoc Khanh'),
                    phoneNumber: yup.string().required('Not Blank')
                        .matches(/^(090)|(091)|(\(84\)\+90)|(\(84\)\+91)[0-9]{7}$/,'090XXXXXXX/091XXXXXXX/(84)+90XXXXXXX/(84)+91XXXXXXX'),
                    citizenshipId: yup.string().required('Not Blank')
                        .matches(/^[0-9]{9}$/,'XXXXXXXXX (X : 0-9)'),
                    email: yup.string().required('Not Blank')
                        .matches(/^[A-Za-z0-9]+@[A-Za-z]{2,}\.[A-Za-z]{2,}$/,'Ex: khanhgazz50@gmail.com'),
                    birthday: yup.date().required('Not Blank'),
                    address: yup.string().required('Not Blank')
                })}
                onSubmit={(values,{resetForm}) => {
                    dispatch(createCustomer({...values,typeCustomerId: +values.typeCustomerId}))
                    resetForm()
                    Swal.fire({
                        icon: "success",
                        title: "Create Customer Success",
                        timer: "2000"
                    })
                }
                }>
                <Form>
                    <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
                        <div className="h3 text-center font-weight-bold">Create Customer</div>
                        <div className="row my-4">
                            <div className="col-md-6">
                                <label>Customer Name</label> <Field type="text" name="name" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="name"/>
                            </div>
                            <div className="col-md-6 pt-md-0 pt-4">
                                <label>Birthday</label> <Field  type="date" name="birthday" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="birthday"/>
                            </div>
                        </div>
                        <div className="row my-md-4 my-2">
                            <div className="col-md-6">
                                <label>Gender
                                    <Field as="select" name="gender" id="rentalType">
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
                                    </Field>
                                </label>
                                <ErrorMessage style={{color: "red"}} component="p" name="gender"/>
                            </div>
                            <div className="col-md-6 pt-md-0 pt-4">
                                <label>Citizenship ID</label> <Field type="text" name="citizenshipId" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="citizenshipId"/>
                            </div>
                        </div>
                        <div className="row my-md-4 my-2">
                            <div className="col-md-6">
                                <label>
                                    Customer type
                                    <Field as="select" name="typeCustomerId" id="rentalType">
                                        {
                                            typeCustomers.map((type, index) => (
                                                <option key={index} value={type.id}>{type.name}</option>
                                            ))
                                        }
                                    </Field>
                                    <ErrorMessage style={{color: "red"}} component="p" name="typeCustomerId"/>
                                </label>
                            </div>
                            <div className="col-md-6">
                                <label>Address</label> <Field name="address" type="text" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="address"/>
                            </div>
                        </div>
                        <div className="row my-md-4 my-2">
                            <div className="col-md-6">
                                <label>Phone Number</label> <Field name="phoneNumber" type="text" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="phoneNumber"/>
                            </div>
                            <div className="col-md-6 pt-md-0 pt-4">
                                <label>Email</label> <Field name="email" type="text" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="email"/>
                            </div>
                        </div>
                        <div className="d-flex justify-content-end">
                            <button className="btn btn-info">Create Customer</button>
                        </div>
                    </div>
                </Form>
            </Formik>
        </>
    )
}

export default CreateCustomer;