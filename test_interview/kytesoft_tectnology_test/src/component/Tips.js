import clsx from "clsx";
import StarIcon from '@mui/icons-material/Star';
import StarBorderIcon from '@mui/icons-material/StarBorder';
import AccessTimeIcon from '@mui/icons-material/AccessTime';
import ChevronRightIcon from '@mui/icons-material/ChevronRight';

import React from "react";
import styles from "../css/popular.module.scss"
import stylesBestTrip from "../css/bestTrip.module.scss"
import stylesTips from "../css/tips.module.scss"
import styleGlobal from "../css/global.module.scss"
import Grid from '@mui/material/Unstable_Grid2';
import Container from "@mui/material/Container";

export function Tips() {
    return (
        <>
            <div className={clsx(styles.cartContent)}>
                <div className={clsx(styles.titlePopular)}>
                    <h1>Articles & Tips</h1>
                    <h6 className={clsx(styles.subTitlePopular)}>Explore some of the best tips from around the
                        world</h6>
                </div>
                <div>
                    <Grid container spacing={2}
                          style={{padding: "0 5rem", display: "flex", justifyContent: "space-between"}} md={12}>
                        <Grid xs={12} ms={6} md={3.7}>
                            <Grid className={clsx(styleGlobal.cart)}>
                                <div className={clsx(stylesBestTrip.cardImage)}>
                                    <img className={clsx(styles.cartImage)}
                                         src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/photo-1469920783271-4ee08a94d42d-960x636.jpg"
                                         alt=""/>
                                </div>
                                <div className={clsx(stylesTips.subContent)}>
                                    <Grid md={12}>
                                        <b>DECEMBER 10,2016</b>
                                        <h4>Memorial Day to Someone Told Me to Travel</h4>
                                        <p>Meh synth Schlitz, tempor duis single-origin coffee ea next level ethnic
                                            fingerstache...</p>
                                    </Grid>
                                    <Grid md={12} className={clsx(stylesTips.readMore)}>
                                        <div className={clsx(stylesTips.subContentCart)}>
                                            <p>Read More <ChevronRightIcon/></p>
                                        </div>
                                    </Grid>
                                </div>
                            </Grid>
                        </Grid>
                        <Grid xs={12} ms={6} md={3.7}>
                            <Grid className={clsx(styleGlobal.cart)}>
                                <div className={clsx(stylesBestTrip.cardImage)}>
                                    <img className={clsx(styles.cartImage)}
                                         src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/pexels-photo-212388-960x636.jpeg"
                                         alt=""/>
                                </div>
                                <div className={clsx(stylesTips.subContent)}>
                                    <Grid md={12}>
                                        <b>DECEMBER 10,2016</b>
                                        <h4>7 Tips For Nomads On A Budget Trips</h4>
                                        <p>Meh synth Schlitz, tempor duis single-origin coffee ea next level ethnic
                                            fingerstache...</p>
                                    </Grid>
                                    <Grid md={12} className={clsx(stylesTips.readMore)}>
                                        <div className={clsx(stylesTips.subContentCart)}>
                                            <p>Read More <ChevronRightIcon/></p>
                                        </div>
                                    </Grid>
                                </div>
                            </Grid>
                        </Grid>
                        <Grid xs={12} ms={6} md={3.7}>
                            <Grid className={clsx(styleGlobal.cart)}>
                                <div className={clsx(stylesBestTrip.cardImage)}>
                                    <img className={clsx(styles.cartImage)}
                                         src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/pexels-photo-24484-960x636.jpg"
                                         alt=""/>
                                </div>
                                <div className={clsx(stylesTips.subContent)}>
                                    <Grid md={12}>
                                        <b>DECEMBER 10,2016</b>
                                        <h4>Taking A Travel Blog Victory Lap</h4>
                                        <p>Meh synth Schlitz, tempor duis single-origin coffee ea next level ethnic
                                            fingerstache...</p>
                                    </Grid>
                                    <Grid md={12} className={clsx(stylesTips.readMore)}>
                                        <div className={clsx(stylesTips.subContentCart)}>
                                            <p>Read More <ChevronRightIcon/></p>
                                        </div>
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