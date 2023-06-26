import React from "react";
import "../crud.css"
function UpdateService() {
    return (
        <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
            <div className="h3 text-center font-weight-bold">Update Service</div>
            <div className="row my-4">
                <div className="col-md-6">
                    <label>Service Name</label> <input type="text" placeholder=""/>
                </div>
                <div className="col-md-6 pt-md-0 pt-4">
                    <label>Usable area</label> <input type="text" placeholder=""/>
                </div>
            </div>
            <div className="row my-md-4 my-2">
                <div className="col-md-6">
                    <label>Rental cost</label> <input type="text" placeholder=""/>
                </div>
                <div className="col-md-6 pt-md-0 pt-4">
                    <label>Maximum number of guests</label>{" "}
                    <input type="text" placeholder=""/>
                </div>
            </div>
            <div className="row my-md-4 my-2">
                <div className="col-md-6">
                    <label>
                        Rental type
                        <select name="country" id="rentalType">
                            <option value="ind">Year</option>
                            <option value="us">Month</option>
                            <option value="uk">Date</option>
                            standard
                            <option value="uk">Hour</option>
                        </select>
                    </label>
                </div>
                <div className="col-md-6 pt-md-0 pt-4">
                    <label>
                        Room standard{" "}
                        <select name="country" id="standard">
                            <option value="ind">5</option>
                            <option value="us">4</option>
                            <option value="uk">3</option>
                            <option value="aus">2</option>
                        </select>
                    </label>
                </div>
            </div>
            <div className="row my-md-4 my-2">
                <div className="col-md-6">
                    <label>Facility description</label> <input type="text" placeholder=""/>
                </div>
                <div className="col-md-6 pt-md-0 pt-4">
                    <label>Number of floors</label> <input type="text" placeholder=""/>
                </div>
            </div>
            <div className="row my-md-4 my-2">
                <div className="col-md-6">
                    <label>Pool area</label> <input type="text" placeholder=""/>
                </div>
                <div className="col-md-6 pt-md-0 pt-4">
                    <label>Free service included</label> <input type="text" placeholder=""/>
                </div>
            </div>
            <div className="d-flex justify-content-end">
                <button className="btn btn-primary">Update</button>
            </div>
        </div>
    )
}
export default UpdateService;