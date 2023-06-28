import {rootReducer} from "./reducers";
import thunk from "redux-thunk"
import {applyMiddleware, createStore} from "redux";

const initialStore = {}
const middleWare = [thunk]
const store = createStore(rootReducer, initialStore, applyMiddleware(...middleWare))
export default store;