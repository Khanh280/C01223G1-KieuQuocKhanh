import './App.css';
import React, {Component} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {


    constructor(props) {
        super(props);
        this.state = {
            list: ['Case Study'],
            item: ''
        }

    }

    handleChange = (value) => {
        this.setState({item: value})
        console.log(this.state.item)
    }

    handleAddItem = () => {
        if (this.state.item !== "") {
            this.setState((prev) => (
                {
                    list: [prev.item, ...prev.list],
                    item: ''
                }
            ))
        }
    }

    render() {
        return (
            <>
                <div align="center">
                    <input value={this.state.item} onChange={(event => this.handleChange(event.target.value))}/>
                    <button className="btn btn-sm btn-primary" onClick={() => this.handleAddItem()}>Add</button>
                </div>
                <table className="table table-hover">
                    <thead>
                    <tr>
                        <th className="col">STT</th>
                        <th className="col">Todo</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.list.map((todo, index) =>
                            (
                                <tr key={index}>
                                    <td>{index + 1}</td>
                                    <td>{todo}</td>
                                </tr>
                            )
                        )
                    }
                    </tbody>
                </table>
            </>
        );
    }
}

export default App;