import React from "react";
import ReactDOM from "react-dom/client"; // import thư viện react-dom/client

const arr = [
    {
        name: 'khanh',
        gender: 'Male',
        address: 'Quang Nam'
    },
    {
        name: 'thang',
        gender: 'Male',
        address: 'Da Nang'
    },
    {
        name: 'hoa',
        gender: 'Male',
        address: 'Da Nang'
    }
]
let myList = arr.filter(elem => elem.gender === 'Male')
let map = myList.map((elem) => <p>Name : {elem.name} Gender: {elem.gender} Address: {elem.address}</p>)
const container = ReactDOM.createRoot(document.getElementById('root'))
container.render(map)
// Tạo component App
//     function App() {
//     return (<div><h1>Hello World!</h1> </div>);
// }
// Render component App vào "root"
// const root = ReactDOM.createRoot(document.getElementById("root"));
// root.render(<App />);