import React, {useState} from "react";

import {Formik, Form, Field} from "formik";

function CreateService() {
    const [service, setService] = useState('villa')
    // const handleService = (value) => {
    //     setService(value)
    //     console.log(service)
    // }
    return (
        <Formik
            initialValues={{
                id: 1,
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
                service: service
            }}
            onSubmit={values => {
                console.log(values.service)
            }

            }>
            <Form>
                <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
                    <div className="h3 text-center font-weight-bold">Create Service</div>
                    <div>
                        <Field component="select" onChange={(event)=> setService(event.target.value)} value={service} name="service" id="service">
                            <Field component="option" value="villa">Villa</Field>
                            <Field component="option" value="house">House</Field>
                            <Field component="option" value="room">Room</Field>
                        </Field>
                    </div>
                    <div className="row my-4">
                        <div className="col-md-6">
                            <label>Service Name</label> <Field name="name" type="text" placeholder=""/>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Usable area</label> <Field name="useArea" type="text" placeholder=""/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>Rental cost</label> <Field name="rentalCost" type="text" placeholder=""/>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Maximum number of guests</label>{" "}
                            <Field name="maximumPeople" type="text" placeholder=""/>
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
                            </label>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        <div className="col-md-6">
                            <label>Facility description</label> <Field name="description" type="text" placeholder=""/>
                        </div>
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Number of floors</label> <Field name="floorsNumber" type="text" placeholder=""/>
                        </div>
                    </div>
                    <div className="row my-md-4 my-2">
                        {
                            service === 'villa' ?
                                <div className="col-md-6">
                                    <label>Pool area</label> <Field name="poolArea" type="text" placeholder=""/>
                                </div>
                                : service === 'house' ?
                                '' : service === 'room' ?
                                    <div className="col-md-6">
                                        <label>Free Service</label> <Field name="freeService" type="text"
                                                                           placeholder=""/>
                                    </div> : ''
                        }
                        <div className="col-md-6 pt-md-0 pt-4">
                            <label>Image</label> <Field name="image" type="text" placeholder=""/>
                        </div>
                    </div>
                    {/*    <label class="mt-md-0 mt-2">Company Size</label>*/}
                    {/*    <div class="d-lg-flex justify-content-between align-items-center pb-4">*/}
                    {/*        <div class="size"><label class="option"> <Field name" type="radio" name="radio">&lt; 250 <span*/}
                    {/*                class="checkmark"></span> </label></div>*/}
                    {/*        <div class="size"><label class="option"> <Field name" type="radio" name="radio">251 - 1000 <span*/}
                    {/*                class="checkmark"></span> </label></div>*/}
                    {/*        <div class="size"><label class="option"> <Field name" type="radio" name="radio">1001 - 5000 <span*/}
                    {/*                class="checkmark"></span> </label></div>*/}
                    {/*        <div class="size"><label class="option"> <Field name" type="radio" name="radio">5001 - 10,000 <span*/}
                    {/*                class="checkmark"></span> </label></div>*/}
                    {/*        <div class="size"><label class="option"> <Field name" type="radio" name="radio">&gt; 10,000 <span*/}
                    {/*                class="checkmark"></span> </label></div>*/}
                    {/*    </div>*/}
                    <div className="d-flex justify-content-end">
                        <button type="submit" className="btn btn-primary">Create</button>
                    </div>
                </div>
            </Form>
        </Formik>
    )
}

export default CreateService;