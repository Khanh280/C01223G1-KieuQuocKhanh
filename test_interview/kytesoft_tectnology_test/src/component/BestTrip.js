import clsx from "clsx";
import StarIcon from '@mui/icons-material/Star';
import StarBorderIcon from '@mui/icons-material/StarBorder';
import AccessTimeIcon from '@mui/icons-material/AccessTime';

import React from "react";
import styles from "../css/popular.module.scss"
import stylesBestTrip from "../css/bestTrip.module.scss"
import Grid from '@mui/material/Unstable_Grid2';

export function BestTrip() {
    return (
        <>
            <div className={clsx(styles.cartContent)}>
                <div className={clsx(styles.titlePopular)}>
                    <h1>Best Value Trips</h1>
                    <h6 className={clsx(styles.subTitlePopular)}>Best offers trips from us</h6>
                </div>
                <div>
                    <Grid container spacing={2}
                          style={{padding: "0 5rem", display: "flex", justifyContent: "space-between"}} md={12}>
                        <Grid  sm={12} md={3.7}>
                            <Grid className={clsx(stylesBestTrip.cardBestTrip)}>
                                <div className={clsx(stylesBestTrip.cardImage)}>
                                    <img
                                         src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/pexels-photo-211051-700x466.jpeg"
                                         alt=""/>
                                    <div className={clsx(stylesBestTrip.priceSale, styles.cartTitle)}>
                                        <h5>$5,000</h5>
                                    </div>
                                </div>
                                <div className={clsx(stylesBestTrip.subContent)}>
                                    <h2 style={{color: "black"}}>French Autumn</h2>
                                    <p>City Tours, Urban</p>
                                    <Grid container spacing={2} className={clsx(stylesBestTrip.subContentCart)}>
                                        <Grid lg={8}>
                                            <p className={clsx(stylesBestTrip.rating)}>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarBorderIcon/>
                                                <b>4 review</b>
                                            </p>
                                        </Grid>
                                        <Grid lg={4}>
                                            <p><AccessTimeIcon/> 5 <b>days</b></p>
                                        </Grid>
                                    </Grid>
                                </div>
                            </Grid>
                        </Grid>
                        <Grid  sm={12} md={3.7}>
                            <Grid className={clsx(stylesBestTrip.cardBestTrip)}>
                                <div className={clsx(stylesBestTrip.cardImage)}>
                                    <img
                                         src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/pexels-photo-197657-700x466.jpeg"
                                         alt=""/>
                                    <div className={clsx(stylesBestTrip.priceSale, styles.cartTitle)}>
                                        <h5>$6,000</h5>
                                    </div>
                                </div>
                                <div className={clsx(stylesBestTrip.subContent)}>
                                    <h2 style={{color: "black"}}>Grand Switzerland</h2>
                                    <p>City Tours, Urban</p>
                                    <Grid container spacing={2} className={clsx(stylesBestTrip.subContentCart)}>
                                        <Grid lg={8}>
                                            <p className={clsx(stylesBestTrip.rating)}>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarBorderIcon/>
                                                <b>4 review</b>
                                            </p>
                                        </Grid>
                                        <Grid lg={4}>
                                            <p><AccessTimeIcon/> 5 <b>days</b></p>
                                        </Grid>
                                    </Grid>
                                </div>
                            </Grid>
                        </Grid>
                        <Grid  sm={12} md={3.7}>
                            <Grid className={clsx(stylesBestTrip.cardBestTrip)}>
                                <div className={clsx(stylesBestTrip.cardImage)}>
                                    <img
                                         src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/pexels-photo-96420-700x466.jpeg"
                                         alt=""/>
                                    <div className={clsx(stylesBestTrip.priceSale, styles.cartTitle)}>
                                        <h5>
                                            <span>$3,000</span>
                                            $2,500
                                        </h5>
                                    </div>
                                    <div className={clsx(stylesBestTrip.saleIcon)}>
                                        <p>
                                            Sale
                                        </p>
                                    </div>
                                </div>
                                <div className={clsx(stylesBestTrip.subContent)}>
                                    <h2 style={{color: "black"}}>Discover Japan</h2>
                                    <p>City Tours, Urban</p>
                                    <Grid container spacing={2} className={clsx(stylesBestTrip.subContentCart)}>
                                        <Grid lg={8}>
                                            <p className={clsx(stylesBestTrip.rating)}>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                                                <StarBorderIcon/>
                                                <b>4 review</b>
                                            </p>
                                        </Grid>
                                        <Grid lg={4}>
                                            <p><AccessTimeIcon/> 5 <b>days</b></p>
                                        </Grid>
                                    </Grid>
                                </div>
                            </Grid>
                        </Grid>
                    </Grid>
                </div>
            </div>
        </>
    )
}