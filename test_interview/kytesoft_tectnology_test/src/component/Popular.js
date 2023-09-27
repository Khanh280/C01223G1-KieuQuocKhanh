import clsx from "clsx";

import React from "react";
import styles from "../css/popular.module.scss"
import Grid from '@mui/material/Unstable_Grid2';
import Container from "@mui/material/Container";

export function Popular() {
    return (
        <>
            <div className={clsx(styles.cartContent)}>
                <div className={clsx(styles.titlePopular)}>
                    <h1>Popular Destinations</h1>
                    <h6 className={clsx(styles.subTitlePopular)}>World's best tourist destinations</h6>
                </div>
                    <Grid container spacing={2}
                          style={{padding: "0 5rem", display: "flex", justifyContent: "space-between"}} md={12}>
                        <Grid sm={6} md={2.7}>
                            <Grid className={clsx(styles.cart)}>
                                <img className={clsx(styles.cartImage)}
                                     src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/Tokyo_Dollarphotoclub_72848283-copy-700x466.jpg"
                                     alt=""/>
                                <h2 className={clsx(styles.cartTitle)}>Tokyo</h2>
                            </Grid>
                        </Grid>
                        <Grid sm={6} md={2.7}>
                            <Grid className={clsx(styles.cart)}>
                                <img className={clsx(styles.cartImage)}
                                     src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/bf1202aedf2c5b6a57d379575619a488-700x466.jpg"
                                     alt=""/>
                                <h2 className={clsx(styles.cartTitle)}>Seoul</h2>
                            </Grid>
                        </Grid>
                        <Grid sm={6} md={2.7}>
                            <Grid className={clsx(styles.cart)}>
                                <img className={clsx(styles.cartImage)}
                                     src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/1600x1200-4-700x466.jpg"
                                     alt=""/>
                                <h2 className={clsx(styles.cartTitle)}>Paris</h2>
                            </Grid>
                        </Grid>
                        <Grid sm={6} md={2.7}>
                            <Grid className={clsx(styles.cart)}>
                                <img className={clsx(styles.cartImage)}
                                     src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/pexels-photo-1-700x466.jpg"
                                     alt=""/>
                                <h2 className={clsx(styles.cartTitle)}>London</h2>
                            </Grid>
                        </Grid>
                    </Grid>
            </div>
        </>
    )
}