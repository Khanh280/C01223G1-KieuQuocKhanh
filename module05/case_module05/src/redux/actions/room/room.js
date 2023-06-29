import axios from "axios";
import {CREATE_ROOM, GET_ALL_ROOM} from "../type";

export const getAllRoom = () => async (dispatch) =>{
    try{
        const res = await axios.get("http://localhost:8080/room")
        dispatch({
            type: GET_ALL_ROOM,
            payload: res.data
        })
    }catch (e) {
        console.log(e)
    }
}
export const createRoom = (room) => async (dispatch) =>{
    try{
        const res = await axios.post("http://localhost:8080/room",room)
        dispatch({
            type: CREATE_ROOM,
            payload: res.data
        })
    }catch (e) {
        console.log(e)
    }
}