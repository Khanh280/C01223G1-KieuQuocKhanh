import {combineReducers} from "redux";
import {userReducer} from "./usersReducer";

export const rootReducer = combineReducers({
    users: userReducer
})