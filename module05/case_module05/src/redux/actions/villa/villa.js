import axios from "axios";
import {CREATE_VILLA, DELETE_VILLA, GET_ALL_VILLA, GET_VILLA_BY_ID, UPDATE_VILLA} from "../type";

export const getAllVilla = (page) => async (dispatch) => {
    try {
        const res = await axios.get(`http://localhost:8080/villa?_page=${page || 1}&_limit=8`)
        dispatch({
            type: GET_ALL_VILLA,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const createVilla = (villa) => async (dispatch) => {
    try {
        const res = await axios.post("http://localhost:8080/villa", villa)
        dispatch({
            type: CREATE_VILLA,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const deleteVillaById = (id) => async (dispatch) => {
    try {
        await axios.delete("http://localhost:8080/villa/" + id)
        const res = await axios.get(`http://localhost:8080/villa?_page=1&_limit=8`)
        dispatch({
            type: DELETE_VILLA,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}

export const getVillaById = (id) => async (dispatch) => {
    try {
        const res = await axios.get("http://localhost:8080/villa"+id)
        dispatch({
            type: GET_VILLA_BY_ID,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const updateVilla = (villa) => async (dispatch) => {
    try {
        const res = await axios.put("http://localhost:8080/villa/"+villa.id,villa)
        dispatch({
            type: UPDATE_VILLA,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}