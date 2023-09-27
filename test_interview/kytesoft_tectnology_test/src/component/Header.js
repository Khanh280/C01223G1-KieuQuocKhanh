import clsx from "clsx"
import KeyboardArrowDownRoundedIcon from '@mui/icons-material/KeyboardArrowDownRounded';


import React from "react";
import styles from "../css/header.module.scss"
import 'bootstrap/dist/css/bootstrap.min.css';
import Drawer from "@mui/material/Drawer";
import Box from "@mui/material/Box";
import CancelIcon from '@mui/icons-material/Cancel';
import Grid from "@mui/material/Unstable_Grid2";
import stylesBestTrip from "../css/bestTrip.module.scss";
import stylesGlobal from "../css/global.module.scss";

import StarIcon from "@mui/icons-material/Star";
import StarBorderIcon from "@mui/icons-material/StarBorder";
import AccessTimeIcon from "@mui/icons-material/AccessTime";
import FacebookOutlinedIcon from "@mui/icons-material/FacebookOutlined";
import TwitterIcon from "@mui/icons-material/Twitter";
import YouTubeIcon from "@mui/icons-material/YouTube";
import PinterestIcon from "@mui/icons-material/Pinterest";
import InstagramIcon from "@mui/icons-material/Instagram";


export function Header() {
    const [state, setState] = React.useState({
        top: false,
        left: false,
        bottom: false,
        right: false,
    });
    const toggleDrawer = (anchor, open) => (event) => {
        if (event.type === 'keydown' && (event.key === 'Tab' || event.key === 'Shift')) {
            return;
        }

        setState({...state, [anchor]: open});
    }
    const list = (anchor) => (
            <Box
                sx={{width: anchor === 'top' || anchor === 'bottom' ? 'auto' : 250}}
                role="presentation"
                onClick={toggleDrawer(anchor, false)}
                onKeyDown={toggleDrawer(anchor, false)}
                className={clsx(styles.boxNavigate)}
            >
                <div className={clsx(styles.closeButton)}>
                    <CancelIcon className={clsx(styles.closeIcon)}/>
                </div>
                <ul className={clsx(styles.navigateList)}>
                    <li>
                        <b>Home</b>
                    </li>
                    <li>
                        <b>Tours</b>
                    </li>
                    <li>
                        <b>Booking</b>
                    </li>
                    <li>
                        <b>Destinations</b>
                    </li>
                    <li>
                        <b>Pages</b>
                    </li>
                    <li>
                        <b>Blog</b>
                    </li>
                    <li>
                        <b>Shortcodes</b>
                    </li>
                    <li>
                        <b>Shop</b>
                    </li>
                </ul>
                <hr style={{margin: "0 1rem"}}/>
                <Grid container>
                    <Grid md={12} className={clsx(styles.imageSidebarHeader)}>
                        <img
                            src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/pexels-photo-131729-700x466.jpeg"
                            alt="" style={{width: "100%"}}/>
                        <p className={clsx(styles.imageSidebarHeaderPrice)}>$3,900</p>
                        <div>
                            <h3>Swiss Alps Trips</h3>
                            <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                            <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                            <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                            <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                            <StarBorderIcon/>
                        </div>
                    </Grid>
                    <Grid md={12} className={clsx(styles.imageSidebarHeader)}>
                        <img
                            src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/uploads/2016/12/pexels-photo-225630-700x466.jpeg"
                            alt="" style={{width: "100%"}}/>
                        <p className={clsx(styles.imageSidebarHeaderPrice)}><span>$4,900</span>$4,200</p>
                        <div>
                            <h3>5 Lake Of Fuji San</h3>
                            <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                            <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                            <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                            <StarIcon className={clsx(stylesBestTrip.starIcon)}/>
                            <StarBorderIcon/>
                        </div>
                    </Grid>
                </Grid>
                <div className={clsx(styles.iconSocialmedia)}>
                    <FacebookOutlinedIcon className={clsx(styles.facebookIcon)}/>
                    <TwitterIcon className={clsx(styles.twitterIcon)}/>
                    <YouTubeIcon className={clsx(styles.youtubeIcon)}/>
                    <PinterestIcon className={clsx(styles.pinterestIcon)}/>
                    <InstagramIcon className={clsx(styles.instagramIcon)}/>
                </div>
            </Box>
    );
    return (
        <>
            <div className={clsx(styles.header)}>
                <div>
                    <img className={clsx(styles.imageHeader)}
                         src="https://themes-themegoods.b-cdn.net/grandtour/demo/wp-content/themes/grandtour/images/logo@2x_white.png"
                         alt=""/>
                </div>
                <div>
                    <ul className={clsx(styles.navigateHeader)}>
                        <li>
                            <p className={clsx(styles.navigateTitle)}>
                                Home
                                <KeyboardArrowDownRoundedIcon/>
                            </p>
                            <ul className={clsx(styles.navigateOption)}>
                                <li>Home 1 – Background Image</li>
                                <li>Home 2 – Youtube Video</li>
                                <li>Home 3 – Google Inspired</li>
                                <li>Home 4 – Travel Site</li>
                            </ul>

                        </li>
                        <li>
                            <p className={clsx(styles.navigateTitle)}>Tours
                                <KeyboardArrowDownRoundedIcon/></p>
                            <ul className={clsx(styles.navigateOption)}>
                                <li>Tour Classic Fullwidth</li>
                                <li>Tour Classic Sidebar</li>
                                <li>Tour Grid Fullwidth</li>
                                <li>Tour Grid Sidebar</li>
                                <li>Tour List Sidebar</li>
                                <li>Tour Header Type</li>
                                <li>Tour Categories</li>
                            </ul>
                        </li>
                        <li>
                            <p className={clsx(styles.navigateTitle)}>Booking
                                <KeyboardArrowDownRoundedIcon/></p>
                            <ul className={clsx(styles.navigateOption)}>
                                <li>Online Payment for Booking</li>
                                <li>Custom Booking Form</li>
                                <li>Tour Durations</li>
                                <li>Custom Booking URL for Affiliate Tour</li>
                                <li>Custom Booking using custom HTML & Shortcode</li>
                                <li>Header Options</li>
                                <li>Layout Options</li>
                            </ul>
                        </li>
                        <li>
                            <p className={clsx(styles.navigateTitle)}>
                                Destinations
                                <KeyboardArrowDownRoundedIcon/>
                            </p>
                            <ul className={clsx(styles.navigateOption)}>
                                <li>Destination Fullwidth</li>
                                <li>Destination + Video Header</li>
                                <li>Destination Right Sidebar</li>
                                <li>Destination Left Sidebar</li>
                                <li>Single Destination</li>
                                <li>Single Destination + Video</li>
                            </ul>
                        </li>
                        <li>
                            <p className={clsx(styles.navigateTitle)}>
                                Pages
                                <KeyboardArrowDownRoundedIcon/>
                            </p>
                            <ul className={clsx(styles.navigateOption)}>
                                <li>About Us</li>
                                <li>Contact Us</li>
                                <li>FAQs</li>
                                <li>Gallery</li>
                                <li>Page Fullwidth</li>
                                <li>Page + Video Background Header</li>
                                <li>Page Right Sidebar</li>
                                <li>Page Left Sidebar</li>
                            </ul>
                        </li>
                        <li>
                            <p className={clsx(styles.navigateTitle)}>
                                Blog
                                <KeyboardArrowDownRoundedIcon/>
                            </p>
                            <ul className={clsx(styles.navigateOption)}>
                                <li>Blog Right Sidebar</li>
                                <li>Blog Left Sidebar</li>
                                <li>Blog Fullwidth</li>
                                <li>Blog Grid Right Sidebar</li>
                                <li>Blog Grid Left Sidebar</li>
                                <li>Blog Grid Fullwidth</li>
                                <li>Blog Full + Grid Right Sidebar</li>
                                <li>Blog Full + Grid Left Sidebar</li>
                                <li>Blog Full + Grid Fullwidth</li>
                            </ul>
                        </li>
                        <li>
                            <p className={clsx(styles.navigateTitle)}>
                                Shortcodes
                                <KeyboardArrowDownRoundedIcon/>
                            </p>
                            <ul className={clsx(styles.navigateOption)}>
                                <li>Accordion & Toggles</li>
                                <li>Alert Boxes</li>
                                <li>Animated Content</li>
                                <li>Buttons & Social Icons</li>
                                <li>Columns</li>
                                <li>Google Maps</li>
                                <li>Image Frame & Animation</li>
                                <li>Image Teasers</li>
                                <li>Pricing Tables</li>
                                <li>Tabs</li>
                            </ul>
                        </li>
                        <li>
                            <p className={clsx(styles.navigateTitle)}>
                                Shop
                                <KeyboardArrowDownRoundedIcon/>
                            </p>
                            <ul className={clsx(styles.navigateOption)}>
                                <li>Shop Fullwidth</li>
                                <li>Shop Sidebar</li>
                                <li>Single Product Fullwidth</li>
                                <li>Single Product With Sidebar</li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div className={clsx(styles.optionsHeader)}>
                    <div>
                        {['right'].map((anchor) => (
                            <React.Fragment key={anchor}>
                                <i className="bi bi-list" onClick={toggleDrawer(anchor, true)}></i>
                                <Drawer
                                    anchor={anchor}
                                    open={state[anchor]}
                                    onClose={toggleDrawer(anchor, false)}
                                >
                                    {list(anchor)}
                                </Drawer>
                            </React.Fragment>
                        ))}
                    </div>

                    <div className={clsx(styles.cartIconHeader)}>
                        <i className="bi bi-minecart"></i>
                        <p>0</p>
                    </div>
                </div>
            </div>
        </>
    )
}