import axios from "axios";
import {CREATE_HOUSE, DELETE_HOUSE, GET_ALL_HOUSE, GET_HOUSE_BY_ID, UPDATE_HOUSE} from "../type";

export const getAllHouse = () => async (dispatch) =>{
    try{
        const res = await axios.get("http://localhost:8080/house")
        dispatch({
            type: GET_ALL_HOUSE,
            payload: res.data
        })
    }catch (e) {
        console.log(e)
    }
}
export const createHouse = (house) => async (dispatch) =>{
    try{
        const res = await axios.post("http://localhost:8080/house",house)
        dispatch({
            type: CREATE_HOUSE,
            payload: res.data
        })
    }catch (e) {
        console.log(e)
    }
}
export const deleteHouseById = (id) => async (dispatch) => {
    try {
        await axios.delete("http://localhost:8080/house/" + id)
        const res = await axios.get("http://localhost:8080/house")
        dispatch({
            type: DELETE_HOUSE,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}

export const getHouseById = (id) => async (dispatch) => {
    try {
        const res = await axios.get("http://localhost:8080/house"+id)
        dispatch({
            type: GET_HOUSE_BY_ID,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const updateHouse = (house) => async (dispatch) => {
    try {
        const res = await axios.put("http://localhost:8080/house/"+house.id,house)
        dispatch({
            type: UPDATE_HOUSE,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}