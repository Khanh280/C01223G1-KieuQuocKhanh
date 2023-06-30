import "../crud.css"
import {ErrorMessage, Field, Form, Formik} from "formik";
import {createCustomer, updateCustomer} from "../redux/actions/customer/customer";
import Swal from "sweetalert2";
import React, {useEffect, useState} from "react";
import {useDispatch} from "react-redux";
import {useNavigate, useParams} from "react-router";
import axios from "axios";
import * as yup from "yup";

function UpdateCustomer() {
    const [customers, setCustomer] = useState()
    const [typeCustomers, setTypeCustomer] = useState([])
    const navigate = useNavigate()
    const param = useParams()
    const dispatch = useDispatch()
    const getAllTypeCustomer = async () => {
        const res = await axios.get("http://localhost:8080/typeCustomer")
        setTypeCustomer(res.data)
    }
    useEffect(()=>{
        getAllTypeCustomer()
        const getCustomerById = async ()=>{
            const res = await  axios.get("http://localhost:8080/customer/" + param.id)
            setCustomer(res.data)
        }
        getCustomerById()
    },[param.id])
    if(!customers){
        return null;
    }
    return (
        <>
            <Formik
                initialValues={{
                    id: customers?.id,
                    name: customers?.name,
                    birthday: customers?.birthday,
                    gender: customers?.gender,
                    citizenshipId: customers?.citizenshipId,
                    phoneNumber: customers?.phoneNumber,
                    email: customers?.email,
                    typeCustomerId: customers?.typeCustomerId,
                    address: customers?.address
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
                onSubmit={(values) => {
                    dispatch(updateCustomer({...values, typeCustomerId: +values.typeCustomerId}))
                    navigate("/customer")
                    Swal.fire({
                        icon: "success",
                        title: "Update Customer Success",
                        timer: "2000"
                    })
                }
                }>
                <Form>
                    <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
                        <div className="h3 text-center font-weight-bold">Update Customer</div>
                        <div className="row my-2">
                            <div className="col-md-6">
                                <label>Customer Name</label> <Field type="text" name="name" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="name"/>
                            </div>
                            <div className="col-md-6 pt-md-0 pt-4">
                                <label>Birthday</label> <Field  type="date" name="birthday" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="birthday"/>
                            </div>
                        </div>
                        <div className="row my-md-2 my-2">
                            <div className="col-md-6">
                                <label>Gender
                                    <Field as="select" name="gender" id="rentalType">
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
                                    </Field>
                                    <ErrorMessage style={{color: "red"}} component="p" name="gender"/>
                                </label>
                            </div>
                            <div className="col-md-6 pt-md-0 pt-4">
                                <label>Citizenship ID</label> <Field type="text" name="citizenshipId" placeholder=""/>
                                <ErrorMessage style={{color: "red"}} component="p" name="citizenshipId"/>
                            </div>
                        </div>
                        <div className="row my-md-2 my-2">
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
                        <div className="row my-md-2 my-2">
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
                            <button className="btn btn-info">Update Customer</button>
                        </div>
                    </div>
                </Form>
            </Formik>
        </>
    )
}

export default UpdateCustomer;