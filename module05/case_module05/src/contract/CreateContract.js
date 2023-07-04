import "../crud.css"
import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
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
    const [servicesSelect, setServiceSelect] = useState(null)
    const dispatch = useDispatch()
    const navigate = useNavigate()
    const [initialValues, setInitialValues] = useState({
        id: '',
        customerId: '',
        startDate: '',
        endDate: '',
        deposit: '',
        paymentDeposit: '',
        serviceId: null
    });
    const getCustomerById = async () => {
        console.log(param.id)
        const res = await axios.get("http://localhost:8080/customer/" + param.id)
        setCustomer(res.data)
    }
    const getService = async () => {
        const villa = await axios.get("http://localhost:8080/villa")
        const house = await axios.get("http://localhost:8080/house")
        const room = await axios.get("http://localhost:8080/room")
        const service = [...villa.data, ...house.data, ...room.data]
        setService(service)
    }
    const findService = async (event) => {
        let res = {};
        switch (+event.target.selectedOptions[0].id) {
            case 1:
                res = await axios.get("http://localhost:8080/villa/" + event.target.value)
                break;
            case 2:
                res = await axios.get("http://localhost:8080/house/" + event.target.value)
                break;
            case 3:
                res = await axios.get("http://localhost:8080/room/" + event.target.value)
                break;
        }
        setServiceSelect(res.data)
        console.log(servicesSelect)
    }

    useEffect(() => {
        getService()
        getCustomerById()
    }, [])
    useEffect(() => {

    }, [servicesSelect]);
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
                paymentDeposit: 0,
                serviceId: servicesSelect?.id,
            }}
            validationSchema={yup.object({
                startDate: yup.date().required('Not Blank'),
                endDate: yup.date().required('Not Blank'),
                // serviceId: yup.number().required().min(1, 'Please choose Service'),
                deposit: yup.number().required().min(1, '> 0'),
            })}
            onSubmit={(values) => {
                dispatch(createContract({
                    ...values,
                    paymentDeposit: servicesSelect ? servicesSelect.rentalCost : '',
                    customerId: +values.customerId,
                    serviceId: servicesSelect ? servicesSelect.id : '',
                    serviceTypeId: servicesSelect ? servicesSelect.serviceTypeId : ''
                }));
                navigate("/contract")
                Swal.fire({
                    icon: "success",
                    title: "Create Contract Success",
                    timer: 2000
                })
            }}>
            <Form>
                <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
                    <div className="h1 text-center font-weight-bold">CreateService Contract</div>
                    <div className="row " align="center">
                        <div className="col-md-4"></div>
                        <div className="col-md-4 pt-md-0 pt-4"><h3 style={{color: "black"}}>Customer
                            : {customer.name}</h3></div>
                        <div className="col-md-4"></div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-12">
                            <label>Select Service</label>
                            <Field as="select" name="serviceId" id="rentalType" type="number" placeholder=""
                                   onChange={(event) => findService(event)}>
                                <option value={0}>Select Service</option>
                                {
                                    services.map((service, index) => (
                                        <option key={index} value={service.id}
                                                id={service.serviceTypeId}>{service.name}</option>
                                    ))
                                }
                            </Field>
                            <ErrorMessage name="serviceId" style={{color: "red"}} component="p"/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>Start Date <Field type="date" name="startDate" placeholder=""/>
                            </label>
                            <ErrorMessage name="startDate" style={{color: "red"}} component="p"/>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>End Date <Field type="date" name="endDate" placeholder=""/>
                            </label>
                            <ErrorMessage name="endDate" style={{color: "red"}} component="p"/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>Deposit</label> <Field type="text" name="deposit" placeholder=""/>
                            <ErrorMessage name="deposit" style={{color: "red"}} component="p"/>
                        </div>
                        <div className="col-md-6">
                            <label>Payment deposit</label>
                            <Field type="text" name="paymentDeposit"
                                   value={servicesSelect ? servicesSelect.rentalCost : ""}
                                   readonly
                                   placeholder=""/>
                            <ErrorMessage name="paymentDeposit" style={{color: "red"}} component="p"/>
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