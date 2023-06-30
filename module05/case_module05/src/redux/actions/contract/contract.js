import axios from "axios";
import {CREATE_CONTRACT, DELETE_CONTRACT, GET_ALL_CONTRACT, GET_CONTRACT_BY_ID, UPDATE_CONTRACT} from "../type";

export const getAllContract = (page) => async (dispatch) => {
    try {
        const res = await axios.get(`http://localhost:8080/contract?_page=${page || 1}&_limit=6 `)
        dispatch({
            type: GET_ALL_CONTRACT,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
export const createContract = (contract) => async (dispatch) => {
    try {
        const res = await axios.post("http://localhost:8080/contract", contract)
        dispatch({
            type: CREATE_CONTRACT,
            payload: res.data
        })
    } catch (e) {
        console.log(e)
    }
}
// export const deleteContractById = (id) => async (dispatch) => {
//     try {
//         await axios.delete("http://localhost:8080/contract/" + id)
//         const res = await axios.get("http://localhost:8080/contract")
//         dispatch({
//             type: DELETE_CONTRACT,
//             payload: res.data
//         })
//     } catch (e) {
//         console.log(e)
//     }
// }
//
// export const getContractById = (id) => async (dispatch) => {
//     try {
//         const res = await axios.get("http://localhost:8080/contract"+id)
//         dispatch({
//             type: GET_CONTRACT_BY_ID,
//             payload: res.data
//         })
//     } catch (e) {
//         console.log(e)
//     }
// }
// export const updateContract = (contract) => async (dispatch) => {
//     try {
//         const res = await axios.put("http://localhost:8080/contract/"+contract.id,contract)
//         dispatch({
//             type: UPDATE_CONTRACT,
//             payload: res.data
//         })
//     } catch (e) {
//         console.log(e)
//     }
// }