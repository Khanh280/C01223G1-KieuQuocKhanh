function CreateService() {
    return (
        <div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
            <div className="h3 text-center font-weight-bold">Create Service</div>
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
            {/*    <label class="mt-md-0 mt-2">Company Size</label>*/}
            {/*    <div class="d-lg-flex justify-content-between align-items-center pb-4">*/}
            {/*        <div class="size"><label class="option"> <input type="radio" name="radio">&lt; 250 <span*/}
            {/*                class="checkmark"></span> </label></div>*/}
            {/*        <div class="size"><label class="option"> <input type="radio" name="radio">251 - 1000 <span*/}
            {/*                class="checkmark"></span> </label></div>*/}
            {/*        <div class="size"><label class="option"> <input type="radio" name="radio">1001 - 5000 <span*/}
            {/*                class="checkmark"></span> </label></div>*/}
            {/*        <div class="size"><label class="option"> <input type="radio" name="radio">5001 - 10,000 <span*/}
            {/*                class="checkmark"></span> </label></div>*/}
            {/*        <div class="size"><label class="option"> <input type="radio" name="radio">&gt; 10,000 <span*/}
            {/*                class="checkmark"></span> </label></div>*/}
            {/*    </div>*/}
            <div className="d-flex justify-content-end">
                <button className="btn btn-primary">Create</button>
            </div>
        </div>
    )
}
export  default CreateService;