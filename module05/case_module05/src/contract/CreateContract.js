import "../crud.css"
import React from "react";
function CreateContract() {
return(
    <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
        <div className="h3 text-center font-weight-bold">CreateService Contract</div>
        <div className="row my-md-4 my-2">
            <div className="col-md-12">
                <label>Contract Code</label> <input type="text" placeholder="" />
            </div>
                    {/*<div className="col-md-6 pt-md-0 pt-4"><label>Birthday</label> <input type="text" placeholder=""/></div>*/}
        </div>
        <div className="row my-md-4 my-2">
            <div className="col-md-6">
                <label>Start Date</label> <input type="date" placeholder="" />
            </div>
            <div className="col-md-6 pt-md-0 pt-4">
                <label>End Date</label> <input type="date" placeholder="" />
            </div>
        </div>
        <div className="row my-md-4 my-2">
            <div className="col-md-6">
                <label>Deposit</label> <input type="text" placeholder="" />
            </div>
            <div className="col-md-6">
                <label>Payment deposit</label> <input type="text" placeholder="" />
            </div>
        </div>
        {/*<div className="row my-md-4 my-2"></div>*/}
        <div className="d-flex justify-content-end">
            <button className="btn btn-primary">CreateService</button>
        </div>
    </div>
)
}
export default CreateContract;