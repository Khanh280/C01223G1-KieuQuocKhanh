import "../crud.css"

function CreateCustomer() {
    return (<div className="wrapper d-flex justify-content-center flex-column px-md-5 px-1">
            <div className="h3 text-center font-weight-bold">CreateService Customer</div>
            <div className="row my-4">
                <div className="col-md-6">
                    <label>Customer Name</label> <input type="text" placeholder=""/>
                </div>
                <div className="col-md-6 pt-md-0 pt-4">
                    <label>Birthday</label> <input type="text" placeholder=""/>
                </div>
            </div>
            <div className="row my-md-4 my-2">
                <div className="col-md-6">
                    <label>Gender</label> <input type="text" placeholder=""/>
                </div>
                <div className="col-md-6 pt-md-0 pt-4">
                    <label>Citizenship ID</label> <input type="text" placeholder=""/>
                </div>
            </div>
            <div className="row my-md-4 my-2">
                <div className="col-md-6">
                    <label>
                        Customer type
                        <select name="country" id="rentalType">
                            <option value="ind">Diamond</option>
                            <option value="us">Platinium</option>
                            <option value="uk">Gold</option>
                            <option value="uk">Silver</option>
                            <option value="uk">Member</option>
                        </select>
                    </label>
                </div>
                <div className="col-md-6">
                    <label>Address</label> <input type="text" placeholder=""/>
                </div>
            </div>
            <div className="row my-md-4 my-2">
                <div className="col-md-6">
                    <label>Phone Number</label> <input type="text" placeholder=""/>
                </div>
                <div className="col-md-6 pt-md-0 pt-4">
                    <label>Email</label> <input type="text" placeholder=""/>
                </div>
            </div>
            <div className="row my-md-4 my-2"></div>
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
                <button className="btn btn-primary">CreateService</button>
            </div>
        </div>
    )
}

export default CreateCustomer;