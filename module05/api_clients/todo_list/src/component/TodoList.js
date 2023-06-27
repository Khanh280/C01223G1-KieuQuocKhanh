import React, {useEffect, useState} from "react";
import axios from "axios";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {toast} from "react-toastify";
import * as todoService from "../service/TodoService"
import * as Yup from "yup"

export function TodoList() {
    const [todo, setTodo] = useState([])
    const fecthApi = async () => {
        const res = await todoService.findAll()
        setTodo(res);
    }
    useEffect(() => {
        fecthApi()
    }, [])
    return (
        <div>
            <div align='center'>
                <h2>Todo List</h2>
                <Formik
                    initialValues={{
                        task: ''
                    }}
                    validationSchema={Yup.object({
                        task: Yup.string().required('Not Blank')
                    })}
                    onSubmit={(values, {setSubmitting}) => {
                        setSubmitting(false)
                        const create = async () => {
                            await todoService.save(values)
                            toast(<h2>Create success</h2>)
                            fecthApi();
                        }
                        create();
                    }}>
                    <Form>
                        <Field name='task' placeholder='Task'/>
                        <ErrorMessage style={{color: 'red', margin: '0px'}} name='task' component='p'/>
                        <br/>
                        <button type='submit'>Submit</button>
                    </Form>
                </Formik>

                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Task Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        todo.map((todo) =>
                            <tr key={todo.id}>
                                <td>{todo.id}</td>
                                <td>{todo.task}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>

        </div>
    )
}