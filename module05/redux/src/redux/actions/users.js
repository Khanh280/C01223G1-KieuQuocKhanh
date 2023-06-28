import axios from "axios";
import {DELETE_USERS, GET_ALL_USERS} from "./types";

export const getAllUsers = () =>
    async (dispatch) => {
        try {
            const res = await axios.get("http://localhost:8080/users")
            console.log(res.data)
            dispatch({
                type: GET_ALL_USERS,
                payload: res.data
            })
        } catch (e) {

        }
    }
export const deleteUserById = (id) =>
    async (dispatch) => {
        try {
            await axios.delete("http://localhost:8080/users/" + id)
            dispatch({
                type: DELETE_USERS,
                payload: []
            })
        } catch (e) {

        }
    }