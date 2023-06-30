import axios from "axios";
import {CREATE_CUSTOMER, DELETE_CUSTOMER, GET_ALL_CUSTOMER, GET_CUSTOMER_BY_ID, UPDATE_CUSTOMER} from "../type";

export const getAllCustomer = (page) => async (dispatch) => {
    try {
        const res = await axios.get(`http://localhost:8080/customer?_page=${page || 1}&_limit=6`)
        dispatch({
            type: GET_ALL_CUSTOMER,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const createCustomer = (customer) => async (dispatch) => {
    try {
        const res = await axios.post("http://localhost:8080/customer", customer)
        dispatch({
            type: CREATE_CUSTOMER,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const deleteCustomerById = (id) => async (dispatch) => {
    try {
        await axios.delete("http://localhost:8080/customer/" + id)
        const res = await axios.get(`http://localhost:8080/customer?_page=1&_limit=6`)
        dispatch({
            type: DELETE_CUSTOMER,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}

export const getCustomerById = (id) => async (dispatch) => {
    try {
        const res = await axios.get("http://localhost:8080/customer"+id)
        dispatch({
            type: GET_CUSTOMER_BY_ID,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const updateCustomer = (customer) => async (dispatch) => {
    try {
        const res = await axios.put("http://localhost:8080/customer/"+customer.id,customer)
        dispatch({
            type: UPDATE_CUSTOMER,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}