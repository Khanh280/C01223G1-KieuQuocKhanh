import {combineReducers} from "redux";
import {villaReducer} from "./villa";
import {houseReducer} from "./house";
import {roomReducer} from "./room";
import {customerReducer} from "./customer";

export const rootReducer = combineReducers({
    villa: villaReducer,
    house: houseReducer,
    room: roomReducer,
    customer: customerReducer
})