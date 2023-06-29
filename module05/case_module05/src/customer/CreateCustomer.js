import "../crud.css"
import React, {useEffect, useState} from "react";
import axios from "axios";
import {Field, Form, Formik} from "formik";
import Swal from "sweetalert2";
import {useDispatch} from "react-redux";

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
                    name: "khanh",
                    birthday: "28/08",
                    gender: "Male",
                    citizenshipId: "01234",
                    phoneNumber: "012345",
                    email: "khanh@gmail.com",
                    typeCustomerId: 1,
                    address: "Quang Nam"
                }}
                onSubmit={(values,{resetForm}) => {
                    const save = async () => {
                        await axios.post("http://localhost:8080/customer", values)
                    }
                    save()
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
                        <div className="h3 text-center font-weight-bold">CreateService Customer</div>
                        <div className="row my-4">
                            <div className="col-md-6">
                                <label>Customer Name</label> <Field type="text" name="name" placeholder=""/>
                            </div>
                            <div className="col-md-6 pt-md-0 pt-4">
                                <label>Birthday</label> <Field type="text" name="birthday" placeholder=""/>
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
                            </div>
                            <div className="col-md-6 pt-md-0 pt-4">
                                <label>Citizenship ID</label> <Field type="text" name="citizenshipId" placeholder=""/>
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
                                </label>
                            </div>
                            <div className="col-md-6">
                                <label>Address</label> <Field name="address" type="text" placeholder=""/>
                            </div>
                        </div>
                        <div className="row my-md-4 my-2">
                            <div className="col-md-6">
                                <label>Phone Number</label> <Field name="phoneNumber" type="text" placeholder=""/>
                            </div>
                            <div className="col-md-6 pt-md-0 pt-4">
                                <label>Email</label> <Field name="email" type="text" placeholder=""/>
                            </div>
                        </div>
                        <div className="d-flex justify-content-end">
                            <button className="btn btn-primary">Create Customer</button>
                        </div>
                    </div>
                </Form>
            </Formik>
        </>
    )
}

export default CreateCustomer;