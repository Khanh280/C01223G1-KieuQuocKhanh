import {GET_ALL_VILLA} from "../actions/type";

const initialState = []
export const villaReducer = (villa = initialState, action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_VILLA:
            return payload
        default:
            return villa
    }
}