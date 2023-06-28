import axios from "axios";
import {GET_ALL_VILLA} from "../type";

export const getAllVilla = () => async (dispatch) =>{
    try{
        const res = await axios.get("http://localhost:8080/villa")
        dispatch({
            type: GET_ALL_VILLA,
            payload: res.data
        })
    }catch (e) {

    }
}