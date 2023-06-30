import axios from "axios";
import {CREATE_ROOM, DELETE_ROOM, GET_ALL_ROOM, GET_ROOM_BY_ID, UPDATE_ROOM} from "../type";

export const getAllRoom = (page) => async (dispatch) =>{
    try{
        const res = await axios.get(`http://localhost:8080/room?_page=${page || 1}&_limit=8`)
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
export const deleteRoomById = (id) => async (dispatch) => {
    try {
        await axios.delete("http://localhost:8080/room/" + id)
        const res = await axios.get(`http://localhost:8080/room?_page=1&_limit=8`)
        dispatch({
            type: DELETE_ROOM,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}

export const getRoomById = (id) => async (dispatch) => {
    try {
        const res = await axios.get("http://localhost:8080/room"+id)
        dispatch({
            type: GET_ROOM_BY_ID,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const updateRoom = (room) => async (dispatch) => {
    try {
        const res = await axios.put("http://localhost:8080/room/"+room.id,room)
        dispatch({
            type: UPDATE_ROOM,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}