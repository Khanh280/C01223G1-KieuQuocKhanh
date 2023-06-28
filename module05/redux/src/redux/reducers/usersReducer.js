import {DELETE_USERS, GET_ALL_USERS} from "../actions/types";

const initialState = []
export const userReducer = (users = initialState, action) => {
    const {type,payload} = action
    switch (type) {
        case GET_ALL_USERS:
            return payload
        case DELETE_USERS:
            return users
        default:
            return users
    }
}