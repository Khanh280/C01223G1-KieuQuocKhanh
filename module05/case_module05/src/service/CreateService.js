import React, {useEffect, useState} from "react";

import {Formik, Form, Field, useFormik, ErrorMessage} from "formik";
import {useDispatch} from "react-redux";
import {createVilla} from "../redux/actions/villa/villa";
import Swal from "sweetalert2";
import {createHouse} from "../redux/actions/house/house";
import {createRoom} from "../redux/actions/room/room";
import * as yup from "yup"

function CreateService() {
    const [service, setService] = useState("1")
    const dispatch = useDispatch()
    return (
        <Formik
            initialValues={{
                // ...initialValueService
                id: '',
                name: "",
                useArea: '',
                rentalCost: '',
                maximumPeople: '',
                rentalType: "Hour",
                roomStandard: "1",
                description: "",
                poolArea: '',
                floorsNumber: '',
                freeService: '',
                image: "",
                serviceTypeId: 1
            }}
            validationSchema={yup.object({
                name: yup.string().required('Not Blank')
                    .matches(/^[A-Za-z]+([A-Za-z]+ )*([A-Za-z]+)*$/),
                useArea: yup.number().required('Not Blank').min(1),
                rentalCost: yup.number().required('Not Blank').min(1),
                maximumPeople: yup.number().required('Not Blank').min(1),
                rentalType: yup.string().required('Not Blank'),
                roomStandard: yup.string().required('Not Blank'),
                description: yup.string().required('Not Blank'),
                poolArea: yup.number().test('required-if-service-is-1', 'Pool Area > 0', function(value) {
                    if (service === "1" ) {
                        return yup.number().required('Not Blank').min(1).isValidSync(value);
                    }
                    return true;
                }),
                floorsNumber: yup.number().required('Not Blank').min(1),
                serviceTypeId: yup.string().required('Not Blank')
            })}
            onSubmit={(values, {setSubmitting, resetForm}) => {
                setSubmitting(false)
                let actions = null;
                let statusCreate = true;
                switch (+values.serviceTypeId) {
                    case 1:
                        actions = createVilla({
                            id: '',
                            name: values.name,
                            useArea: values.useArea,
                            rentalCost: values.rentalCost,
                            maximumPeople: values.maximumPeople,
                            rentalType: values.rentalType,
                            roomStandard: values.roomStandard,
                            description: values.description,
                            poolArea: values.poolArea,
                            floorsNumber: values.floorsNumber,
                            image: values.image,
                            serviceTypeId: +values.serviceTypeId
                        })

                        break;
                    case 2:
                        actions = createHouse({
                            id: '',
                            name: values.name,
                            useArea: values.useArea,
                            rentalCost: values.rentalCost,
                            maximumPeople: values.maximumPeople,
                            rentalType: values.rentalType,
                            roomStandard: values.roomStandard,
                            description: values.description,
                            floorsNumber: values.floorsNumber,
                            image: values.image,
                            serviceTypeId: +values.serviceTypeId
                        })
                        break;
                    case 3:
                        actions = createRoom({
                            id: '',
                            name: values.name,
                            useArea: values.useArea,
                            rentalCost: values.rentalCost,
                            maximumPeople: values.maximumPeople,
                            rentalType: values.rentalType,
                            roomStandard: values.roomStandard,
                            description: values.description,
                            floorsNumber: values.floorsNumber,
                            image: values.image,
                            serviceTypeId: +values.serviceTypeId
                        })
                        break;
                    default:
                        statusCreate = false
                        console.log(values)
                }
                if (statusCreate && actions != null) {
                    dispatch(actions)
                    Swal.fire({
                        icon: "success",
                        title: "Create Success",
                        timer: "2000"
                    })
                    resetForm();
                    setService("1")
                } else {
                    Swal.fire({
                        icon: "error",
                        title: "Create Fail",
                        timer: "2000"
                    })
                }
            }
            }>

            <Form>
                <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
                    <div className="h3 text-center font-weight-bold">Create Service</div>
                    <div>
                        <Field component="select" onClick={(event) => setService(event.target.value)}
                               name="serviceTypeId"
                               id="service">
                            <Field component="option" value="1">Villa</Field>
                            <Field component="option" value="2">House</Field>
                            <Field component="option" value="3">Room</Field>
                        </Field>
                        <ErrorMessage name="serviceTypeId" component="p" style={{color: "red"}}/>
                    </div>
                    <div className="row my-4">
                        <div className="col-md-6">
                            <label>Service Name</label> <Field autoFocus name="name" type="text" placeholder=""/>
                            <ErrorMessage name="name" component="p" style={{color: "red"}}/>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Usable area</label> <Field name="useArea" type="text" placeholder=""/>
                            <ErrorMessage name="useArea" component="p" style={{color: "red"}}/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>Rental cost</label> <Field name="rentalCost" type="text" placeholder=""/>
                            <ErrorMessage name="rentalCost" component="p" style={{color: "red"}}/>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Maximum number of guests</label>{" "}
                            <Field name="maximumPeople" type="text" placeholder=""/>
                            <ErrorMessage name="maximumPeople" component="p" style={{color: "red"}}/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>
                                Rental type
                                <Field component="select" name="rentalType" id="rentalType">
                                    <Field component="option" value="Year">Year</Field>
                                    <Field component="option" value="Month">Month</Field>
                                    <Field component="option" value="Date">Date</Field>
                                    <Field component="option" value="Hour">Hour</Field>
                                </Field>
                                <ErrorMessage name="rentalType" component="p" style={{color: "red"}}/>
                            </label>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>
                                Room standard
                                <Field component="select" name="roomStandard" id="standard">
                                    <Field component="option" value="5">5</Field>
                                    <Field component="option" value="4">4</Field>
                                    <Field component="option" value="3">3</Field>
                                    <Field component="option" value="2">2</Field>
                                    <Field component="option" value="1">1</Field>
                                </Field>
                                <ErrorMessage name="roomStandard" component="p" style={{color: "red"}}/>
                            </label>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>Facility description</label> <Field name="description" type="text" placeholder=""/>
                            <ErrorMessage name="description" component="p" style={{color: "red"}}/>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Number of floors</label> <Field name="floorsNumber" type="text" placeholder=""/>
                            <ErrorMessage name="floorsNumber" component="p" style={{color: "red"}}/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        {
                            service === '1' ?
                                <div className="col-md-6">
                                    <label>Pool area</label> <Field name="poolArea" type="text" placeholder=""/>
                                    <ErrorMessage name="poolArea" component="p" style={{color: "red"}}/>
                                </div>
                                :
                                service === '2' ?
                                    '' :
                                    service === '3' ?
                                        <div className="col-md-6">
                                            <label>Free Service</label> <Field name="freeService" type="text"
                                                                               placeholder=""/>
                                        </div> : ''
                        }
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Image</label> <Field name="image" type="text" placeholder=""/>
                            {/*<ErrorMessage name="floorsNumber" component="p" style={{color: "red"}}/>*/}
                        </div>
                    </div>
                    <div className="d-flex justify-content-end">
                        <button type="submit" className="btn btn-info">Create</button>
                    </div>
                </div>
            </Form>
        </Formik>
    )
}

export default CreateService;