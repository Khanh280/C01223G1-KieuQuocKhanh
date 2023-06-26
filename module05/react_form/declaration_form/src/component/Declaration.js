import {ErrorMessage, Field, Form, Formik} from "formik";
import React from "react";
import * as Yup from "yup"
import {ProgressBar} from "react-loader-spinner";
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

export function Declaration() {
    return (
        <>
            <Formik
                initialValues={
                    {
                        name: 'Kieu Quoc Khanh',
                        identityCard: '0123456789',
                        yearOfBirth: '2001',
                        gender: '0',
                        nationality: 'Viet Nam',
                        company: 'CodeGym',
                        part: 'Student',
                        insurance: [],
                        provinces: 'Quang Nam',
                        districts: 'Duy Xuyen',
                        wards: 'Duy Hai',
                        numberOfHouse: '28',
                        phoneNumber: '0234563882',
                        email: 'khanhga50@gmail.com',
                        territories: 'America, ThaiLan',
                        manifestation: [],
                        exposure: ''
                    }
                }
                validationSchema={Yup.object({
                    name: Yup.string().required('Do not leave blank'),
                    identityCard: Yup.string().required('Do not leave blank'),
                    yearOfBirth: Yup.string().required('Do not leave blank').matches(/^(19((0[1-9])|([1-9][0-9])))|[2-9][0-9]{3}$/, 'Year of birth >1900'),
                    gender: Yup.string(),
                    nationality: Yup.string().required('Do not leave blank'),
                    company: Yup.string(),
                    part: Yup.string(),
                    insurances: Yup.string(),
                    provinces: Yup.string().required('Do not leave blank'),
                    districts: Yup.string().required('Do not leave blank'),
                    wards: Yup.string().required('Do not leave blank'),
                    numberOfHouse: Yup.string().required('Do not leave blank'),
                    phoneNumber: Yup.string().required('Do not leave blank'),
                    email: Yup.string().required('Do not leave blank').matches(/^[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z]{2,}$/, 'Invalid email address')

                })}
                onSubmit={(values, {setSubmitting}) => {
                    setTimeout(() => {
                        setSubmitting(false)
                        console.log(values)
                        toast.success(<h5>Successful declaration</h5>)
                    }, 1000)
                }
                }>
                {
                    ({isSubmitting}) => (
                        <div className='row' style={{height: '100vh', alignItems: "center"}}>
                            <div align="center"><h2>Declaration Form</h2></div>
                            <div className='col-3'></div>
                            <div className='col-6'>
                                <Form style={{border: '1px solid black', padding: '5px'}}>
                                    <div>
                                        <label className="form-label" htmlFor="name"><h6>Name</h6></label>
                                        <Field className="form-control" type="text" id="name" name="name"/>
                                        <ErrorMessage name="name" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="identityCard"><h6>Identity Card</h6>
                                        </label>
                                        <Field className="form-control" type="text" id="identityCard"
                                               name="identityCard"/>
                                        <ErrorMessage name="identityCard" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="yearOfBirth"><h6>Year Of Birth</h6>
                                        </label>
                                        <Field className="form-control" type="text" id="yearOfBirth"
                                               name="yearOfBirth"/>
                                        <ErrorMessage name="yearOfBirth" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="gender"><h6>Gender</h6></label>
                                        <Field type="radio" id="male" rows="3"
                                               name="gender" value='0' className='ms-2'/>
                                        <label className="form-label" htmlFor="male">Male</label>
                                        <Field type="radio" id="female" rows="3"
                                               name="gender" value='1' className='ms-2'/>
                                        <label className="form-label" htmlFor="female">Female</label>
                                        <ErrorMessage name="gender" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="nationality"><h6>Nationality</h6></label>
                                        <Field className="form-control" type="text" id="nationality" rows="3"
                                               name="nationality"/>
                                        <ErrorMessage name="nationality" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="company"><h6>Company</h6></label>
                                        <Field className="form-control" type="text" id="company" rows="3"
                                               name="company"/>
                                        <ErrorMessage name="company" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="part"><h6>Part</h6></label>
                                        <Field className="form-control" type="text" id="part" rows="3"
                                               name="part"/>
                                        <ErrorMessage name="part" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="insurance"><h6>Insurance</h6></label>
                                        <Field type="checkbox" id="insurance" rows="3"
                                               name="insurance" value='YES' className="ms-2"/>
                                        <ErrorMessage name="insurance" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3" align="center">
                                      <h4>Contacts in Vietnam</h4>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="provinces"><h6>Provinces</h6></label>
                                        <Field className="form-control" type="text" id="provinces" rows="3"
                                               name="provinces"/>
                                        <ErrorMessage name="provinces" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="districts"><h6>Districts</h6></label>
                                        <Field className="form-control" type="text" id="districts" rows="3"
                                               name="districts"/>
                                        <ErrorMessage name="districts" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="wards"><h6>Wards</h6></label>
                                        <Field className="form-control" type="text" id="wards" rows="3"
                                               name="wards"/>
                                        <ErrorMessage name="wards" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="numberOfHouse"><h6>Number Of House</h6>
                                        </label>
                                        <Field className="form-control" type="text" id="numberOfHouse" rows="3"
                                               name="numberOfHouse"/>
                                        <ErrorMessage name="numberOfHouse" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="phoneNumber"><h6>Phone Number</h6>
                                        </label>
                                        <Field className="form-control" type="text" id="phoneNumber" rows="3"
                                               name="phoneNumber"/>
                                        <ErrorMessage name="phoneNumber" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="enail"><h6>Email</h6></label>
                                        <Field className="form-control" type="text" id="email" rows="3"
                                               name="email"/>
                                        <ErrorMessage name="email" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="territories"><h6>Within the last 14 days,
                                            which country/territory have you visited (Can travel through multiple
                                            countries)</h6>
                                        </label>
                                        <Field className="form-control" type="text" id="territories" rows="3"
                                               component="textarea"
                                               name="territories"/>
                                        <ErrorMessage name="territories" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="manifestation"><h6>
                                            In the past 14 days, have you shown any of the following signs
                                        </h6></label>
                                        <br/>
                                        <Field type="checkbox" id="manifestation" rows="3"
                                               name="manifestation" value='Fever'/>
                                        <label className="form-label ms-2" htmlFor="manifestation">Fever </label>
                                        <br/>
                                        <Field type="checkbox" id="manifestation" rows="3"
                                               name="manifestation" value='Cough'/>
                                        <label className="form-label ms-2" htmlFor="manifestation">Cough </label>
                                        <br/>
                                        <Field type="checkbox" id="manifestation" rows="3"
                                               name="manifestation" value='Shortness of breath'/>
                                        <label className="form-label ms-2" htmlFor="manifestation">Shortness of
                                            breath </label>
                                        <br/>
                                        <Field type="checkbox" id="manifestation" rows="3"
                                               name="manifestation" value='Pneumonia'/>
                                        <label className="form-label ms-2" htmlFor="manifestation">Pneumonia </label>
                                        <br/>
                                        <Field type="checkbox" id="manifestation" rows="3"
                                               name="manifestation" value='Sore throat'/>
                                        <label className="form-label ms-2" htmlFor="manifestation">Sore throat </label>
                                        <br/>
                                        <Field type="checkbox" id="manifestation" rows="3"
                                               name="manifestation" value='Tired'/>
                                        <label className="form-label ms-2" htmlFor="manifestation">Tired </label>
                                        <ErrorMessage name="manifestation" component="span" style={{color: "red"}}/>
                                    </div>
                                    <div className="mt-3">
                                        <label className="form-label" htmlFor="exposure"><h6>In the past 14 days, have
                                            you been exposed to ?</h6></label>
                                        <br/>
                                        <Field type="checkbox" id="exposure" rows="3"
                                               name="exposure"
                                               value='People who are sick or suspected of having COVID-19'/>
                                        <label className="form-label ms-2" htmlFor="exposure">People who are sick or
                                            suspected of having COVID-19</label>
                                        <br/>
                                        <Field type="checkbox" id="exposure" rows="3"
                                               name="exposure" value='People from countries with COVID-19'/>
                                        <label className="form-label ms-2" htmlFor="exposure">People from countries with
                                            COVID-19</label>
                                        <br/>
                                        <Field type="checkbox" id="exposure" rows="3"
                                               name="exposure"
                                               value='People with manifestations (fever, cough, difficulties, pneumonia)'/>
                                        <label className="form-label ms-2" htmlFor="exposure">People with manifestations
                                            (fever, cough, difficulties, pneumonia)</label>
                                        <ErrorMessage name="exposure" component="span" style={{color: "red"}}/>
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
                    )
                }
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