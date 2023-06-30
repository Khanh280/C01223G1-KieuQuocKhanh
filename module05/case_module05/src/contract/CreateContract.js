import "../crud.css"
import React, {useEffect, useState} from "react";
import {Field, Form, Formik} from "formik";
import axios from "axios";
import {useNavigate, useParams} from "react-router";
import {useDispatch} from "react-redux";
import {createContract} from "../redux/actions/contract/contract";
import * as Swal from "sweetalert2";
import * as yup from "yup"

function CreateContract() {
    const param = useParams()
    const [customer, setCustomer] = useState()
    const [services, setService] = useState([])
    const [servicesSelect, setServiceSelect] = useState()
    const dispatch = useDispatch()
    const navigate = useNavigate()
    const getCustomerById = async () => {
        console.log(param.id)
        const res = await axios.get("http://localhost:8080/customer/" + param.id)
        setCustomer(res.data)
    }
    const getService = async ()=>{
        const res = await axios.get("http://localhost:8080/villa")
        setService(res.data)
    }
    const findService = async (event)=>{
        const res = await axios.get("http://localhost:8080/villa/" + event.target.value)
        console.log(res.data)
        setServiceSelect(res.data)
    }

    useEffect(() => {
        getService()
        getCustomerById()
    }, [])
    if (!customer) {
        return null;
    }
    return (
        <Formik
            initialValues={{
                id: '',
                customerId: customer?.id,
                startDate: '',
                endDate: '',
                deposit: '',
                paymentDeposit: services?.rentalCost,
                serviceId: 0,
            }}
            validationSchema={yup.object({
                startDate: yup.date().required('Not Blank'),
                endDate: yup.date().required('Not Blank')
            })}
            onSubmit={(values) => {
                dispatch(createContract({...values,customerId: +values.customerId,serviceId: +values.serviceId}))
                navigate("/contract")
                Swal.fire({
                    icon: "success",
                    title: "Create Contract Success",
                    timer: 2000
                })
            } }>
            <Form>
                <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
                    <div className="h1 text-center font-weight-bold">CreateService Contract</div>
                    <div className="row " align="center">
                        <div className="col-md-4"></div>
                        <div className="col-md-4 pt-md-0 pt-4"><h3 style={{color: "black"}}>Customer : {customer.name}</h3></div>
                        <div className="col-md-4"></div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-12">
                            <label>Select Service</label>
                            <Field as="select" name="serviceId" id="rentalType" placeholder="" onClick={(event)=>findService(event)}>
                                {
                                    services.map((service,index)=>(
                                        <option key={index} value={service.id}>{service.name}</option>
                                    ))
                                }
                            </Field>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>Start Date</label> <Field type="date" name="startDate" placeholder=""/>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>End Date</label> <Field type="date" name="endDate" placeholder=""/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>Deposit</label> <Field type="text" name="deposit" placeholder=""/>
                        </div>
                        <div className="col-md-6">
                            <label>Payment deposit</label> <Field type="text" name="paymentDeposit" placeholder=""/>
                        </div>
                    </div>
                    <div className="d-flex justify-content-end">
                        <button type="submit" className="btn btn-info">Create Contract</button>
                    </div>
                </div>
            </Form>
        </Formik>
    )
}

export default CreateContract;