import {CREATE_ROOM, DELETE_ROOM, GET_ALL_ROOM, GET_ROOM_BY_ID, UPDATE_ROOM} from "../actions/type";

const initialState = []
export const roomReducer = (room = initialState, action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_ROOM:
            return payload
        case CREATE_ROOM:
            return [...room,payload]
        case DELETE_ROOM:
            return payload
        case GET_ROOM_BY_ID:
            return payload
        case UPDATE_ROOM:
            return room
        default:
            return room
    }
}