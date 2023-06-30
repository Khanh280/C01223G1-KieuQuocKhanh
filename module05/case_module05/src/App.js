import logo from './logo.svg';


import React from "react";
import Header from "./header-footer/Header";
import Villa from "./service/Villa";
import Footer from "./header-footer/Footer";
import {Routes, Route, Link} from "react-router-dom"
import UpdateService from "./service/UpdateService";
import './App.css';
import CreateService from "./service/CreateService";
import Customer from "./customer/Customer";
import UpdateCustomer from "./customer/UpdateCustomer";
import CreateCustomer from "./customer/CreateCustomer";
import CreateContract from "./contract/CreateContract";
import Contract from "./contract/Contract";
import Test from "./service/Test";
import House from "./service/House";
import Rooms from "./service/Rooms";
import {Provider} from "react-redux";
import store from "./redux/store";


function App() {

    return (
        <>
            <Provider store={store}>
                <Header/>
                <Routes>
                    <Route path="/" element={<Villa/>}/>
                    <Route path="/villa" element={<Villa/>}/>
                    <Route path="/house" element={<House/>}/>
                    <Route path="/room" element={<Rooms/>}/>
                    <Route path="/edit-service/:id/:serviceTypeId" element={<UpdateService/>}/>
                    <Route path="/create-service" element={<CreateService/>}/>
                    <Route path="/customer" element={<Customer/>}/>
                    <Route path="/edit-customer/:id" element={<UpdateCustomer/>}/>
                    <Route path="/create-customer" element={<CreateCustomer/>}/>
                    <Route path="/contract" element={<Contract/>}/>
                    <Route path="/create-contract/:id" element={<CreateContract/>}/>
                    <Route path="*" element={<Villa/>}/>
                </Routes>
                <Footer/>
                {/*<Test />*/}
            </Provider>
        </>

    );
}

export default App;
