import clsx from "clsx";
import PhoneAndroidOutlinedIcon from '@mui/icons-material/PhoneAndroidOutlined';
import LocationOnOutlinedIcon from '@mui/icons-material/LocationOnOutlined';
import AlarmOnOutlinedIcon from '@mui/icons-material/AlarmOnOutlined';
import FacebookOutlinedIcon from '@mui/icons-material/FacebookOutlined';
import TwitterIcon from '@mui/icons-material/Twitter';
import YouTubeIcon from '@mui/icons-material/YouTube';
import PinterestIcon from '@mui/icons-material/Pinterest';
import InstagramIcon from '@mui/icons-material/Instagram';
import styles from "../css/footer.module.scss"

import React from "react";
import Grid from "@mui/material/Grid";

export function Footer() {
    return (
        <>
            <div className={clsx(styles.footer)}>
                <Grid container>
                    <Grid sm={12} md={4} >
                        <div className={clsx(styles.content)}>
                            <h2>Our Awards</h2>
                            <p>London is a megalopolis of people, ideas and frenetic energy. The capital and largest
                                city of
                                the United Kingdom.</p>
                        </div>
                        <img style={{width:"15rem",height: "auto"}}
                            src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/awards.png"
                            alt=""/>
                    </Grid>
                    <Grid sm={12} md={4} className={clsx(styles.content)}>
                        <h2>Contact Info</h2>
                        <p><PhoneAndroidOutlinedIcon/> 1-567-124-44227</p>
                        <p><LocationOnOutlinedIcon/> 184 Main Street East Perl Habour 8007</p>
                        <p><AlarmOnOutlinedIcon/> Mon - Sat 8.00 - 18.00 Sunday CLOSED</p>
                        <div className={clsx(styles.iconFooter)}>
                            <FacebookOutlinedIcon className={clsx(styles.facebookIcon)}/>
                            <TwitterIcon className={clsx(styles.twitterIcon)}/>
                            <YouTubeIcon className={clsx(styles.youtubeIcon)}/>
                            <PinterestIcon className={clsx(styles.pinterestIcon)}/>
                            <InstagramIcon className={clsx(styles.instagramIcon)}/>
                        </div>
                    </Grid>
                    <Grid sm={12} md={4} className={clsx(styles.content)}>
                        <h2>Recent Trips</h2>
                            <Grid container className={clsx(styles.imageGroup)}>
                                <Grid xs={4} ms={4} md={4}>
                                    <img className={clsx(styles.imageFooter)} src="https://live.staticflickr.com/8688/28760131762_e4a64b20c4_q.jpg" alt=""/>
                                </Grid>
                                <Grid xs={4} ms={4} md={4}>
                                    <img className={clsx(styles.imageFooter)} src="https://live.staticflickr.com/7519/27308262031_a6ebf0572e_q.jpg" alt=""/>
                                </Grid>
                                <Grid xs={4} ms={4} md={4}>
                                    <img className={clsx(styles.imageFooter)} src="https://live.staticflickr.com/7160/27287965356_60355f51d7_q.jpg" alt=""/>
                                </Grid>
                                <Grid xs={4} ms={4} md={4}>
                                    <img className={clsx(styles.imageFooter)} src="https://live.staticflickr.com/7365/27138570412_d25002a5c9_q.jpg" alt=""/>
                                </Grid>
                                <Grid xs={4} ms={4} md={4}>
                                    <img className={clsx(styles.imageFooter)} src="https://live.staticflickr.com/7543/26520497604_1df03a02bc_q.jpg" alt=""/>
                                </Grid>
                                <Grid xs={4} ms={4} md={4}>
                                    <img className={clsx(styles.imageFooter)} src="https://live.staticflickr.com/7502/27012097142_f1511b67bc_q.jpg" alt=""/>
                                </Grid>
                            </Grid>
                    </Grid>
                </Grid>
            </div>
        </>
    )
}