import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import axios from "axios";
import {useNavigate} from "react-router";
import {toast} from "react-toastify";
import "react-toastify/dist/ReactToastify.css"
import * as bookService from "../service/BookService"
import * as Yup from "yup"
import {useParams} from "react-router-dom"

export function Update() {
    const [book, setBook] = useState()
    const navigate = useNavigate()
    const param = useParams()

    useEffect(() => {
        const findById = async () => {
            const res = await bookService.findById(param.id)
            setBook(res)
        }
        findById()
    }, [param.id])

    // conditional rendering
    if (!book) {
        return null;
    }

    return (
        <>
            <div align="center">
                <h1>Update Book</h1>
            </div>
            <div className="row">
                <div className="col-3"></div>
                <div className="col-6">
                    <Formik
                        initialValues={{
                            id: book.id,
                            title: book.title,
                            quantity: book.quantity
                        }}
                        validationSchema={Yup.object({
                            title: Yup.string().required('Not Blank'),
                            quantity: Yup.string().required('Not Blank').matches(/^[1-9][0-9]*$/, 'Number > 0')
                        })}
                        onSubmit={(values, {setSubmitting}) => {
                            setSubmitting(false)
                            const update = async () => {
                                await bookService.update(values)
                                toast.success(<h2>Update Success</h2>)
                                navigate("/")
                            }
                            update();
                        }
                        }>
                        <Form>
                            <div className="mb-3">
                                <label className="form-label" htmlFor="title">Title</label>
                                <Field className="form-control" id="title" name='title'/>
                                <ErrorMessage style={{color: 'red', margin: '0px'}} component='p' name='title'/>
                            </div>
                            <div className="mb-3">
                                <label className="form-label" htmlFor="quantity">Quantity</label>
                                <Field className="form-control" id="quantity" name='quantity'/>
                                <ErrorMessage style={{color: 'red', margin: '0px'}} component='p' name='quantity'/>
                            </div>
                            <div className="mb-3">
                                <button type="submit" className="btn btn-success">Update</button>
                            </div>
                        </Form>
                    </Formik>
                </div>
                <div className="col-3"></div>
            </div>
        </>

    )
}