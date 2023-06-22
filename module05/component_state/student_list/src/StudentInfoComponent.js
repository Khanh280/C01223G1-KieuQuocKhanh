import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";


class StudentInfoComponent extends Component {
    constructor() {
        super();
        this.state = {
            studentList: [
                {
                    id: 1,
                    name: 'Kieu Quoc Khanh',
                    age: 21,
                    address: 'Duy Xuyen,Quang Nam'
                },
                {
                    id: 2,
                    name: 'Nguyen Duc Thang',
                    age: 21,
                    address: 'Hoa Xuan,Da Nang'
                },
                {
                    id: 3,
                    name: 'Truong QUoc Hoa',
                    age: 25,
                    address: 'Hai Chau, Da Nang'
                },
                {
                    id: 4,
                    name: 'Huynh Duc Dinh',
                    age: 20,
                    address: 'Que Son, Quang Nam'
                }
            ]
        }
    }

    render() {
        return (
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                </tr>
                {
                    this.state.studentList.map((student) =>
                        (
                            <tr>
                                <td>{student.id}</td>
                                <td>{student.name}</td>
                                <td>{student.age}</td>
                                <td>{student.address}</td>
                            </tr>
                        ))
                }
            </table>
        );
    }
}

export default StudentInfoComponent;
