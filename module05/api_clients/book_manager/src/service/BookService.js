import axios from "axios";

export const findAll = async () => {
    try {
        const res = await axios.get("http://localhost:8080/book")
        return res.data;
    } catch (e) {

    }
}
export const findById = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/book/"+id)
        return res.data;
    } catch (e) {

    }
}
export const create = async (value) => {
    try {
        const res = await axios.post("http://localhost:8080/book",value)
    } catch (e) {

    }
}
export const update = async (value) => {
    try {
        const res = await axios.put("http://localhost:8080/book/"+value.id,value)
    } catch (e) {

    }
}
export const deletes = async (id) => {
    try {
        const res = await axios.delete("http://localhost:8080/book/" + id)
    } catch (e) {

    }
}
