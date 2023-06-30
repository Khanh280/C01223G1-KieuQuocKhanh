import React, {useEffect, useState} from "react";
import "../crud.css"
import {useParams, useSearchParams} from "react-router-dom";
import {createVilla, deleteVillaById, getVillaById, updateVilla} from "../redux/actions/villa/villa";
import {createHouse, deleteHouseById, updateHouse} from "../redux/actions/house/house";
import {createRoom, deleteRoomById, updateRoom} from "../redux/actions/room/room";
import Swal from "sweetalert2";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useDispatch} from "react-redux";
import axios from "axios";
import {useNavigate} from "react-router";
import * as yup from "yup";

function UpdateService() {
    const navigate = useNavigate()
    const {id, serviceTypeId} = useParams();
    const [serviceNow, setServiceNow] = useState()
    const [service, setService] = useState()
    const dispatch = useDispatch();
    const typeService = (serviceTypeId) => {
        switch (+serviceTypeId) {
            case 1:
                return "villa"
            case 2:
                return "house"
            case 3:
                return "room"
        }
    }
    const findServiceById = async () => {
        const res = await axios.get(`http://localhost:8080/` + typeService(serviceTypeId) + `/` + parseInt(id))
        console.log(res.data.serviceTypeId)
        setServiceNow(res.data)
        setService(res.data.serviceTypeId)
    }
    useEffect(() => {
        findServiceById()
    }, [id])
    if (!serviceNow) {
        return null;
    }
    return (
        <Formik
            initialValues={{
                id: serviceNow.id,
                name: serviceNow.name,
                useArea: serviceNow.useArea,
                rentalCost: serviceNow.rentalCost,
                maximumPeople: serviceNow.maximumPeople,
                rentalType: serviceNow.rentalType,
                roomStandard: serviceNow.roomStandard,
                description: serviceNow.description,
                poolArea: serviceNow.poolArea,
                floorsNumber: serviceNow.floorsNumber,
                freeService: serviceNow.freeService,
                image: serviceNow.image,
                serviceTypeId: serviceNow.serviceTypeId
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
                poolArea: yup.number().test('required-if-service-is-1', 'Pool Area > 0', function (value) {
                    if (service.toString() === "1") {
                        return yup.number().required('Not Blank').min(1).isValidSync(value);
                    }
                    return true;
                }),
                floorsNumber: yup.number().required('Not Blank').min(1),
                serviceTypeId: yup.string().required('Not Blank')
            })}
            onSubmit={(values, {setSubmitting}) => {
                setSubmitting(false)
                let actions = null;
                let statusCreate = true;
                let urlService = '';
                switch (+values.serviceTypeId) {
                    case 1:
                        actions = updateVilla({
                            id: +values.id,
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
                        urlService = '/villa'
                        break;
                    case 2:
                        actions = updateHouse({
                            id: +values.id,
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
                        urlService = '/house'
                        break;
                    case 3:
                        actions = updateRoom({
                            id: +values.id,
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
                        urlService = '/room'
                        break;
                    default:
                        statusCreate = false
                        console.log(values)
                }
                if (statusCreate && actions != null) {
                    console.log(+serviceNow.serviceTypeId)
                    if (+serviceNow.serviceTypeId !== +values.serviceTypeId) {
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
                        }
                        dispatch(actions)
                        switch (+serviceNow.serviceTypeId) {
                            case 1:
                                dispatch(deleteVillaById(+id))
                                break;
                            case 2:
                                dispatch(deleteHouseById(+id))
                                break;
                            case 3:
                                dispatch(deleteRoomById(+id))
                                break;

                        }
                    } else {
                        dispatch(actions)
                    }
                    Swal.fire({
                        icon: "success",
                        title: "Update Success",
                        timer: "2000"
                    })
                } else {
                    Swal.fire({
                        icon: "error",
                        title: "Update Fail",
                        timer: "2000"
                    })
                }
                navigate(urlService)
            }
            }>

            <Form>
                <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
                    <div className="h3 text-center font-weight-bold">Update Service</div>
                    <div className="row">
                        <label> Service Type
                            <Field component="select" onClick={(event) => setService(event.target.value)}
                                   name="serviceTypeId"
                                   id="rentalType">
                                <Field component="option" value="1">Villa</Field>
                                <Field component="option" value="2">House</Field>
                                <Field component="option" value="3">Room</Field>
                            </Field>
                        </label>
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
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Number of floors</label> <Field name="floorsNumber" type="text" placeholder=""/>
                            <ErrorMessage name="floorsNumber" component="p" style={{color: "red"}}/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        {
                            service.toString() === "1" ?
                                <div className="col-md-6">
                                    <label>Pool area</label> <Field name="poolArea" type="text" placeholder=""/>
                                    <ErrorMessage name="poolArea" component="p" style={{color: "red"}}/>
                                </div>
                                :
                                service.toString() === "2" ?
                                    '' :
                                    service.toString() === "3" ?
                                        <div className="col-md-6">
                                            <label>Free Service</label> <Field name="freeService" type="text"
                                                                               placeholder=""/>
                                        </div> : ''
                        }
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Image</label> <Field name="image" type="text" placeholder=""/>
                        </div>
                    </div>
                    <div className="d-flex justify-content-end">
                        <button type="submit" className="btn btn-info">Update</button>
                    </div>
                </div>
            </Form>
        </Formik>
    )
}

export default UpdateService;