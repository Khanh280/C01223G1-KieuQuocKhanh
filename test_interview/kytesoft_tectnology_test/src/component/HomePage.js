import clsx from "clsx";
import Grid from '@mui/material/Unstable_Grid2';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import SearchIcon from '@mui/icons-material/Search';
import DateRangeOutlinedIcon from '@mui/icons-material/DateRangeOutlined';
import ImportExportIcon from '@mui/icons-material/ImportExport';
import AttachMoneyIcon from '@mui/icons-material/AttachMoney';
import ExpandMoreOutlinedIcon from '@mui/icons-material/ExpandMoreOutlined';


import React, {useEffect} from "react";
import styles from "../css/home-page.module.scss"
import styleCartContent from "../css/popular.module.scss"
import styleCartDescriptionTrip from "../css/descriptionTrip.module.scss"
import {Popular} from "./Popular";
import {BestTrip} from "./BestTrip";
import {Tips} from "./Tips";

export function HomePage() {
    const dropDownOption = () => {
        let ulElement = document.getElementById('inputAdvanced')
        let ulIcon = document.getElementById('inputAdvancedIcon')

        ulIcon.style.transition = "transform 0.5s";
        if (ulElement.style.display === 'none') {
            ulElement.style.display = 'flex';
            ulIcon.style.transform = 'rotate(180deg)';
        } else {
            ulElement.style.display = 'none';
            ulIcon.style.transform = 'rotate(0deg)';
        }
    }
    useEffect(() => {
        dropDownOption()
    }, [])

    return (
        <>
            <div className={clsx(styles.videoHome)}>
                <div className={clsx(styles.videoHome)}>
                    <video controls autoPlay muted loop>
                        <source src="video-home.mp4" type="video/mp4"/>
                    </video>
                </div>

                <div className={clsx(styles.videoHomeContent)}>
                    <div className={clsx(styles.videoHomeTitle)}>
                        <h1>Where do you want to go?</h1>
                        <h6>Trips, experiences, and places. All in one service.</h6>
                    </div>

                    <div>
                        <Grid container spacing={2}>
                            <Grid xs={12} md={3} className={clsx(styles.inputField)}>
                                <input className={clsx(styles.videoHomeInput)} type="text"
                                       placeholder="  Destination, city"/>
                                <SearchIcon className={clsx(styles.inputIcon)}/>
                            </Grid>
                            <Grid xs={12} md={3} className={clsx(styles.inputField)}>
                                <select name="month" id="" className={clsx(styles.videoHomeInput)}>
                                    <option value="">Any Month</option>
                                    <option value="">January</option>
                                    <option value="">February</option>
                                    <option value="">March</option>
                                    <option value="">April</option>
                                    <option value="">May</option>
                                    <option value="">June</option>
                                    <option value="">July</option>
                                    <option value="">August</option>
                                    <option value="">September</option>
                                    <option value="">October</option>
                                    <option value="">November</option>
                                    <option value="">December</option>
                                </select>
                                <DateRangeOutlinedIcon className={clsx(styles.inputIcon)}/>
                            </Grid>
                            <Grid xs={12} md={3} className={clsx(styles.inputField)}>
                                <select name="date" id="" className={clsx(styles.videoHomeInput)}>
                                    <option value="">Sort By Date</option>
                                    <option value="">Price Low to High</option>
                                    <option value="">Price High to Low</option>
                                    <option value="">Sort By Name</option>
                                    <option value="">Sort By Popularity</option>
                                    <option value="">Sort By Review Score</option>
                                </select>
                                <ImportExportIcon className={clsx(styles.inputIcon)}/>
                            </Grid>
                            <Grid xs={12} md={3}>
                                <button className={clsx(styles.buttonSearch, styles.videoHomeInput)}>Search</button>
                            </Grid>
                        </Grid>

                        <Grid container spacing={2} id="inputAdvanced">
                            <Grid xs={12} md={3} className={clsx(styles.inputField)}>
                                <select name="date" id="" className={clsx(styles.videoHomeInput)}>
                                    <option value="">All Categories</option>
                                    <option value="">Mountain</option>
                                    <option value="">Rural</option>
                                    <option value="">Snow & Ice</option>
                                    <option value="">Wildlife</option>
                                </select>
                                <ExpandMoreOutlinedIcon className={clsx(styles.inputIcon)}/>
                            </Grid>
                            <Grid xs={12} md={3} className={clsx(styles.inputField)}>
                                <select name="date" id="" className={clsx(styles.videoHomeInput)}>
                                    <option value="">Any Destinations</option>
                                    <option value="">Tokyo</option>
                                    <option value="">Seoul</option>
                                    <option value="">Paris</option>
                                    <option value="">London</option>
                                    <option value="">Venice</option>
                                    <option value="">Miami</option>
                                    <option value="">Rome</option>
                                    <option value="">Prague</option>
                                    <option value="">California</option>
                                    <option value="">Kyoto</option>
                                    <option value="">Hong Kong</option>
                                    <option value="">Santorini</option>
                                </select>
                                <ExpandMoreOutlinedIcon className={clsx(styles.inputIcon)}/>
                            </Grid>
                            <Grid xs={12} md={3} className={clsx(styles.inputField)}>
                                <input className={clsx(styles.videoHomeInput)} type="text"
                                       placeholder="  Max budget ex. 500"/>
                                <AttachMoneyIcon className={clsx(styles.inputIcon)}/>
                            </Grid>
                        </Grid>
                        <Grid container>
                            <p onClick={() => dropDownOption()}>
                                <ExpandMoreIcon id="inputAdvancedIcon"/>
                                Advanced Search
                            </p>
                        </Grid>
                    </div>
                </div>
            </div>
            <Popular />
            <BestTrip/>
            <div className={clsx(styleCartContent.titlePopular)}>
                <h1>Why Choose Us</h1>
                <h6 className={clsx(styleCartContent.subTitlePopular)}>Here are reasons you should plan trip with
                    us</h6>
            </div>
            <Grid container spacing={2} style={{display: "flex", justifyContent: "center"}} md={12}>
                <Grid xs={12} md={4} className={clsx(styleCartDescriptionTrip.descriptionTrip)}>
                    <div>
                        <img className={clsx(styleCartDescriptionTrip.imageDescriptionTrip)}
                             src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/Map-Marker-300x300.png"
                             alt=""/>
                    </div>
                    <h4 className={clsx(styleCartDescriptionTrip.titleDescription)}>Handpicked Hotels</h4>
                    <p className={clsx(styleCartDescriptionTrip.contentDescriptionTrip)}>Lorem ipsum dolor sit amet, consect adipiscing elit. Aenean commodo ligula eget dolor. Aenean
                        massa</p>
                </Grid>
                <Grid xs={12} md={4} className={clsx(styleCartDescriptionTrip.descriptionTrip)}>
                    <div>
                        <img className={clsx(styleCartDescriptionTrip.imageDescriptionTrip)}
                             src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/Worldwide-Location-300x300.png"
                             alt=""/>
                    </div>
                    <h4 className={clsx(styleCartDescriptionTrip.titleDescription)}>World Class Service</h4>
                    <p className={clsx(styleCartDescriptionTrip.contentDescriptionTrip)}>Lorem ipsum dolor sit amet, consect adipiscing elit. Aenean commodo ligula eget dolor. Aenean
                        massa</p>
                </Grid>
                <Grid xs={12} md={4} className={clsx(styleCartDescriptionTrip.descriptionTrip)}>
                    <div>
                        <img className={clsx(styleCartDescriptionTrip.imageDescriptionTrip)}
                             src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/Hot-Air-Balloon-300x300.png"
                             alt=""/>
                    </div>
                    <h4 className={clsx(styleCartDescriptionTrip.titleDescription)}>Best Price Guarantee</h4>
                    <p className={clsx(styleCartDescriptionTrip.contentDescriptionTrip)}>Lorem ipsum dolor sit amet, consect adipiscing elit. Aenean commodo ligula eget dolor. Aenean
                        massa</p>
                </Grid>
            </Grid>
            <div className={clsx(styles.backgroundImage,styles.paddingY)}></div>
            <Tips/>
        </>
    )
}