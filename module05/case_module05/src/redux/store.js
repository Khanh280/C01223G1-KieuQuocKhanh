import {rootReducer} from "./reducers/rootReducer";
import {applyMiddleware, createStore} from "redux";
import thunk from "redux-thunk";
const initialStore = {}
const middleWare = [thunk]

const store = createStore(rootReducer,initialStore,applyMiddleware(...middleWare))
export default store;