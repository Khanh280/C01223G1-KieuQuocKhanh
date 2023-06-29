import {CREATE_VILLA, DELETE_VILLA, GET_ALL_VILLA, GET_VILLA_BY_ID, UPDATE_VILLA} from "../actions/type";

const initialState = []
export const villaReducer = (villa = initialState, action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_VILLA:
            return payload
        case CREATE_VILLA:
            return [...villa,payload]
        case DELETE_VILLA:
            return payload
        case GET_VILLA_BY_ID:
            return payload
        case UPDATE_VILLA:
            return villa
        default:
            return villa
    }
}