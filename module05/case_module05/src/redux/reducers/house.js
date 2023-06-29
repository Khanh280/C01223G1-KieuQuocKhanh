import {
    CREATE_HOUSE,
    DELETE_HOUSE,
    GET_ALL_HOUSE,
    GET_HOUSE_BY_ID,
    UPDATE_HOUSE
} from "../actions/type";

const initialState = []
export const houseReducer = (house = initialState, action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_HOUSE:
            return payload
        case CREATE_HOUSE:
            return [...house, payload]
        case DELETE_HOUSE:
            return payload
        case GET_HOUSE_BY_ID:
            return payload
        case UPDATE_HOUSE:
            return house
        default:
            return house
    }
}