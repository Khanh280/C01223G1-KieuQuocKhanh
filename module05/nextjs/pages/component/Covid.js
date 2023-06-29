import axios from "axios";
import "bootstrap/dist/css/bootstrap.css"

export default function Home({covid}) {
    return (
            <div style={{height: '100vh', backgroundColor: "white"}}>
                <div align="center">
                    <h1>Vietnam's COVID-19 Infomation</h1>
                </div>
                <table className="table table-hover">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Confirmed</th>
                        <th>Active</th>
                        <th>Recovered</th>
                        <th>Deaths</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        covid.map((covid) => (
                            <tr>
                                <td>{covid.date}</td>
                                <td>{covid.confirmed}</td>
                                <td>{covid.active}</td>
                                <td>{covid.recovered}</td>
                                <td>{covid.deaths}</td>
                            </tr>
                        ))
                    }
                    </tbody>
                </table>
            </div>
    )
}
export const getStaticProps=async ()=>{
    const res =await  axios.get("http://localhost:8080/covid")
    return {
        props: {
            covid: res.data
        }
    }
}
