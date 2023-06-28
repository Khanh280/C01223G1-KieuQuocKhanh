import {combineReducers} from "redux";
import {villaReducer} from "./villa";

export const rootReducer = combineReducers({
    villa: villaReducer
})