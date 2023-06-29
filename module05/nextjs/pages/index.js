
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/css/bootstrap.css"
import Covid from "./component/Covid";

export default function Home() {
    return (
        <div style={{height: '100vh', backgroundColor: "white"}}>
            <div align="center">
                <h1>Vietnam's COVID-19 Infomation</h1>
                <a className="btn btn-sm btn-primary" href="component/Covid">Covid List</a>
            </div>
        </div>
    )
}
