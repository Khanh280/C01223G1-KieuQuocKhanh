import React, {useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup'
import {ToastContainer, toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import {ProgressBar} from "react-loader-spinner";
import "bootstrap/dist/css/bootstrap-grid.css"

export function FormContract() {
    return (
        <>
            <Formik
                initialValues={{
                    name: '',
                    email: '',
                    phone: '',
                    message: ''
                }}
                validationSchema={Yup.object({
                    name: Yup.string()
                        .required('Do not leave blank'),
                    email: Yup.string()
                        .required('Do not leave blank')
                        .matches(/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, 'Incorrect formatting (Ex: khanhgazz50@gmail.com)'),
                    phone: Yup.string()
                        .required('Do not leave blank')
                })
                }
                onSubmit={(values, {setSubmitting}) => {
                    setTimeout(() => {
                        setSubmitting(false)
                        console.log(values)
                        toast(<h4 style={{color: "black", textAlign: "center"}}>Create {values.name} ok</h4>);
                    }, 2000)
                }}>
                {
                    ({isSubmitting}) => (
                        <div className='row' style={{height: '100vh', alignItems: "center"}}>
                            <div className='col-3'></div>
                            <div className='col-6'>
                                <div align='center'><h1>Form Contract</h1></div>
                                <Form style={{border: '1px solid black', padding: '5px'}}>
                                    <div>
                                        <label className="form-label" htmlFor="name">Name</label>
                                        <Field className="form-control" type="text" id="name" name="name"/>
                                        <ErrorMessage name="name" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="email">Email</label>
                                        <Field className="form-control" type="text" id="email" name="email"/>
                                        <ErrorMessage name="email" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="phone">Phone</label>
                                        <Field className="form-control" type="text" id="phone" name="phone"/>
                                        <ErrorMessage name="phone" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="message">Message</label>
                                        <Field className="form-control" type="text" id="message" as="textarea" rows="3"
                                               name="message"/>
                                        <ErrorMessage name="message" component="span" style={{color: "red"}}/>
                                    </div>
                                    {
                                        isSubmitting ?
                                            <div className="d-flex justify-content-center">
                                                <ProgressBar
                                                    height="80"
                                                    width="80"
                                                    ariaLabel="progress-bar-loading"
                                                    wrapperStyle={{}}
                                                    wrapperClass="progress-bar-wrapper"
                                                    borderColor='black'
                                                    barColor='green'
                                                />
                                            </div> :
                                            <div className="d-flex justify-content-center mb-2">
                                                <button className="mt-3 btn btn-success" type="submit">Submit</button>
                                            </div>
                                    }
                                </Form>
                            </div>
                            <div className='col-3'></div>
                        </div>
                    )}
            </Formik>
            <ToastContainer
                position="top-center"
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
                theme="light"
            />
        </>
    )
}