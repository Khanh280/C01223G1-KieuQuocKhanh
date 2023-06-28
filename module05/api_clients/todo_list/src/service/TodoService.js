import axios from "axios";

export const findAll = async () => {
    try {
        const res = await axios.get("http://localhost:8080/todo-list")
        return res.data;
    } catch (e) {
        console.log(e)
    }
}
export const save = async (values) => {
    try {
        await axios.post("http://localhost:8080/todo-list", values)
    } catch (e) {
        console.log(e)
    }
}