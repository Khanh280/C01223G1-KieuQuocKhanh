import {CREATE_CONTRACT, DELETE_CONTRACT, GET_ALL_CONTRACT, GET_CONTRACT_BY_ID, UPDATE_CONTRACT} from "../actions/type";

const initialState = []
export const contractReducer = (contract = initialState, action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_CONTRACT:
            return payload
        case CREATE_CONTRACT:
            return [...contract,payload]
        case DELETE_CONTRACT:
            return payload
        case GET_CONTRACT_BY_ID:
            return payload
        case UPDATE_CONTRACT:
            return contract
        default:
            return contract
    }
}