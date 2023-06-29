import {CREATE_CUSTOMER, DELETE_CUSTOMER, GET_ALL_CUSTOMER, GET_CUSTOMER_BY_ID, UPDATE_CUSTOMER} from "../actions/type";

const initialState = []
export const customerReducer = (customer = initialState, action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_CUSTOMER:
            return payload
        case CREATE_CUSTOMER:
            return [...customer,payload]
        case DELETE_CUSTOMER:
            return payload
        case GET_CUSTOMER_BY_ID:
            return payload
        case UPDATE_CUSTOMER:
            return customer
        default:
            return customer
    }
}