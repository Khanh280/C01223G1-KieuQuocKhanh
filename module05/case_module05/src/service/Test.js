import {villa} from "../facility/villa";
import React from "react";

function Test() {
    return (
        <table>
            <thead>
            <tr>
                <th>Service Name</th>
                <th>Usable area</th>
                <th>Rental Cost</th>
                <th>Maximum People number</th>
                <th>Rental type</th>
                <th>Room standard</th>
                <th>Description</th>
                <th>Number of floors</th>
                <th>Pool area</th>
            </tr>
            </thead>
            <tbody>
            {
                villa.map((villa) => (
                    <tr>
                        <td>{villa.name}</td>
                        <td>{villa.useArea}</td>
                        <td>{villa.rentalCost}</td>
                        <td>{villa.maximumPeople}</td>
                        <td>{villa.rentalType}</td>
                        <td>{villa.roomStandard}</td>
                        <td>{villa.description}</td>
                        <td>{villa.floorsNumber}</td>
                        <td>{villa.poolArea}</td>
                    </tr>

                ))
            }
            </tbody>
        </table>


    )
}

export default Test;