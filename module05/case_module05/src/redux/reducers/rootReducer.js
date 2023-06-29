import {combineReducers} from "redux";
import {villaReducer} from "./villa";
import {houseReducer} from "./house";
import {roomReducer} from "./room";

export const rootReducer = combineReducers({
    villa: villaReducer,
    house: houseReducer,
    room: roomReducer
})