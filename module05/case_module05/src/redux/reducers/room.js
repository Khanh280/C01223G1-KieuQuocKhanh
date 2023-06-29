import {CREATE_ROOM, GET_ALL_ROOM} from "../actions/type";

const initialState = []
export const roomReducer = (room = initialState, action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_ROOM:
            return payload
        case CREATE_ROOM:
            return [...room,payload]
        default:
            return room
    }
}