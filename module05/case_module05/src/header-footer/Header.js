import React, {useState, useEffect} from 'react'
import "bootstrap/dist/css/bootstrap-grid.css"
import "./HeaderAndFooter.css"
import {Link, Route, Routes} from "react-router-dom";
import Villa from "../service/Villa";

function Header() {
    return (
        <>
            <div className="header-mobile-info">
                <div className="header-mobile-slide info1">
                    <div className="inside">
                        <div className="row">
                            <div className="col-sm">
                                <p>
                                    <i className="icon-viber"></i
                                    ><a href="#">+842363847333</a>
                                </p>
                            </div>
                            <div className="col-sm mt-15 mt-sm-0">
                                <p>
                                    <i className="icon-closed-envelope"></i
                                    ><a href="#"
                                >reservation@furamavietnam.com</a
                                >
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="header-mobile-slide info2">
                    <div id="googleMapHeader" className="google-map">
                        <div style={{height: '100%', width: '100%'}}>v</div>
                        <div
                            style={{
                                backgroundColor: 'white',
                                fontWeight: '500',
                                fontFamily: 'Roboto, sans-serif',
                                padding: '15px 25px',
                                boxSizing: 'border-box',
                                top: '5px',
                                border: '1px solid rgba(0, 0, 0, 0.12)',
                                borderRadius: '5px',
                                left: '50%',
                                maxWidth: '375px',
                                position: 'absolute',
                                transform: 'translateX(-50%)',
                                width: ' calc(100% - 10px)',
                                zIndex: '1'
                            }}
                        >
                            <div>
                                <img
                                    alt=""
                                    src="https://maps.gstatic.com/mapfiles/api-3/images/google_gray.svg"
                                    draggable="false"
                                    style={{
                                        padding: '0px',
                                        margin: '0px',
                                        border: '0px',
                                        height: '17px',
                                        verticalAlign: 'middle',
                                        width: '52px',
                                        userSelect: 'none'
                                    }}
                                />
                            </div>
                            <div style={{lineHeight: '20px', margin: '15px 0px'}}>
                <span style={{color: 'rgba(0, 0, 0, 0.87)', fontSize: '14px'}}
                >Trang này không thể tải Google Maps đúng cách.</span
                >
                            </div>
                            <table style={{width: '100%'}}>
                                <tr>
                                    <td style={{lineHeight: '16px', verticalAlign: 'middle'}}>
                                        <a
                                            href="https://developers.google.com/maps/documentation/javascript/error-messages?utm_source=maps_js&amp;utm_medium=degraded&amp;utm_campaign=keyless#api-key-and-billing-errors"
                                            target="_blank"
                                            rel="noopener"
                                            style={{color: 'rgba(0, 0, 0, 0.54)', fontSize: '12px'}}
                                        >Bạn có sở hữu trang web này không?</a
                                        >
                                    </td>
                                    <td style={{textAlign: 'right'}}>
                                        <button className="dismissButton">OK</button>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div className="header-mobile-slide info3">
                    <div className="inside">
                        <div className="visible-xs visible-sm hidden-lg hidden-md">
                            <form
                                action=""
                                className="form-inline row"
                                role="search"
                                method="get"
                            >
                                <div className="col pr-0">
                                    <input
                                        type="text"
                                        name="s"
                                        value=""
                                        placeholder="Search"
                                        className="form-control w-100"
                                    />
                                </div>
                                <div className="col-auto pl-0">
                                    <button className="btn btn-primary" type="submit">Search</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div className="header-mobile-slide info4">
                    <div className="inside">
                        <div className="row">
                            <div className="col-sm">
                                <p><a href="#">English</a></p>
                                <p><a href="#">German</a></p>
                            </div>
                            <div className="col-sm">
                                <p><a href="#">France</a></p>
                                <p><a href="#">Italian</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div className="header-content">
                <div className="container">
                    <div className="row">
                        <div
                            className="col-auto col-sm-5 col-lg-3 d-flex align-items-center bestel-logo"
                        >
                            <a href="" className="header-logo"
                            ><img
                                src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png"
                                alt="logo "
                                className="img-fluid"
                                width="63"
                                height="100"
                            /></a>
                        </div>
                        <div className="col col-md-auto col-lg-3 d-flex">
                            <div className="catalog-widget d-none d-sm-block">
                                <div className="catalog-widget-inside" style={{visibility: 'visible'}}>
                                    <a
                                        href="https://www.tripadvisor.com/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang_Quang_Nam_Province.html"
                                        target="_blank"
                                    >
                                        <div className="widget-tripadvisor">
                                            <div className="inside">
                                                <div className="widget-tripadvisor-logo">
                                                    <img
                                                        src="https://smartdata.tonytemplates.com/bestel/wp-content/uploads/2018/05/widget-tripadvisor-logo.png"
                                                        alt=""
                                                    />
                                                </div>
                                                <div className="widget-tripadvisor-rating">
                                                    <img
                                                        src="https://furamavietnam.com/wp-content/uploads/2018/08/widget-tripadvisor-rating.png"
                                                        alt=""
                                                    />
                                                </div>
                                                <div className="widget-tripadvisor-text">2,746 Reviews</div>
                                            </div>
                                        </div>
                                    </a>
                                    <span
                                        className="catalog-widget-toggle js-catalog-widget-toggle"
                                    ></span>
                                </div>
                            </div>
                            <div
                                className="catalog-widget-mobile d-flex d-sm-none align-items-center mx-auto"
                            ></div>
                        </div>

                        <div className="col-sm-3 d-none d-lg-block">
                            <div className="header-contact d-flex">
                                <div className="header-contact-icon">
                                    <i className="icon-placeholder"></i>
                                </div>
                                <div className="header-contact-txt">
                                    <p>
                                        103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ
                                        hành Sơn, Tp. Đà Nẵng, Việt Nam
                                    </p>
                                    <p className="txt-sm">
                                        <span>7.0 km</span> từ Sân bay Quốc tế Đà Nẵng
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div className="col-sm-3 d-none d-lg-block">
                            <div className="header-contact d-flex">
                                <div className="header-contact-icon">
                                    <i className="icon-telephone"></i>
                                </div>
                                <div className="header-contact-txt">
                                    <p className="txt-lg">84-236-3847 333/888</p>
                                </div>
                            </div>
                            <div className="header-contact d-flex">
                                <div className="header-contact-icon">
                                    <i className="icon-closed-envelope"></i>
                                </div>
                                <div className="header-contact-txt">
                                    <a href="#">
                                        reservation@furamavietnam.com
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div className="col-auto ml-auto d-flex d-lg-none">
                            <button
                                className="navbar-btn"
                                data-target="#modalNavigation"
                                data-toggle="modal"
                            >
                                <i className="icon-menu"></i>
                            </button>
                            <div
                                className="modal fade modal-fullscreen-menu"
                                id="modalNavigation"
                            >
                                <button aria-label="Close" className="close" data-dismiss="modal">
                                    <i className="icon-close"></i>CLOSE
                                </button>
                                {/*<div className="modal-dialog">*/}
                                {/*    <ul*/}
                                {/*        id="menu-furama-vi"*/}
                                {/*        className="menu navbar-nav w-100 js-main-menu"*/}
                                {/*    >*/}
                                {/*        <li*/}
                                {/*            id="nav-menu-item-5006"*/}
                                {/*            className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"*/}
                                {/*        >*/}
                                {/*            <a*/}
                                {/*                href="#"*/}
                                {/*                className="nav-link main-menu-link"*/}
                                {/*            >GIỚI THIỆU</a*/}
                                {/*            >*/}
                                {/*        </li>*/}
                                {/*        <li*/}
                                {/*            id="nav-menu-item-5007"*/}
                                {/*            className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"*/}
                                {/*        >*/}
                                {/*            <a*/}
                                {/*                href="#"*/}
                                {/*                className="nav-link main-menu-link"*/}
                                {/*            >LOẠI PHÒNG</a*/}
                                {/*            >*/}
                                {/*        </li>*/}
                                {/*        <li*/}
                                {/*            id="nav-menu-item-5008"*/}
                                {/*            className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"*/}
                                {/*        >*/}
                                {/*            <a*/}
                                {/*                href="#"*/}
                                {/*                className="nav-link main-menu-link"*/}
                                {/*            >ẨM THỰC</a*/}
                                {/*            >*/}
                                {/*        </li>*/}
                                {/*        <li*/}
                                {/*            id="nav-menu-item-5009"*/}
                                {/*            className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"*/}
                                {/*        >*/}
                                {/*            <a*/}
                                {/*                href="#"*/}
                                {/*                className="nav-link main-menu-link"*/}
                                {/*            >HỘI NGHỊ VÀ SỰ KIỆN</a*/}
                                {/*            >*/}
                                {/*        </li>*/}
                                {/*        <li*/}
                                {/*            id="nav-menu-item-5010"*/}
                                {/*            className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"*/}
                                {/*        >*/}
                                {/*            <a*/}
                                {/*                href="#"*/}
                                {/*                className="nav-link main-menu-link"*/}
                                {/*            >SPA</a*/}
                                {/*            >*/}
                                {/*        </li>*/}
                                {/*        <li*/}
                                {/*            id="nav-menu-item-5011"*/}
                                {/*            className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"*/}
                                {/*        >*/}
                                {/*            <a*/}
                                {/*                href="#"*/}
                                {/*                className="nav-link main-menu-link"*/}
                                {/*            >GIẢI TRÍ</a*/}
                                {/*            >*/}
                                {/*        </li>*/}
                                {/*        <li*/}
                                {/*            id="nav-menu-item-5012"*/}
                                {/*            className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"*/}
                                {/*        >*/}
                                {/*            <a*/}
                                {/*                href="#"*/}
                                {/*                className="nav-link main-menu-link"*/}
                                {/*            >ĐIỂM ĐẾN</a*/}
                                {/*            >*/}
                                {/*        </li>*/}
                                {/*        <li*/}
                                {/*            id="nav-menu-item-5013"*/}
                                {/*            className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"*/}
                                {/*        >*/}
                                {/*            <a*/}
                                {/*                href="#"*/}
                                {/*                className="nav-link main-menu-link"*/}
                                {/*            >ƯU ĐÃI</a*/}
                                {/*            >*/}
                                {/*        </li>*/}
                                {/*    </ul>*/}
                                {/*</div>*/}
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div className="header-nav js-header-nav" style={{position: "sticky", top: "0", zIndex: "100"}}>
                <div className="container">
                    <nav className="navbar navbar-expand-lg">
                        <div className="navbar-collapse">
                            <ul
                                id="menu-furama-vi"
                                className="menu navbar-nav w-100 js-main-menu"
                                style={{justifyContent: "center"}}>
                                <li
                                    id="nav-menu-item-5006"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"
                                >
                                    <a
                                        href="#"
                                        className="nav-link main-menu-link"
                                    >THE RESORT</a
                                    >
                                </li>
                                <li id="nav-menu-item-5007 villa"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page">
                                    <Link to="/villa"
                                          className="nav-link main-menu-link"
                                    >VILLA</Link>
                                </li>
                                <li
                                    id="nav-menu-item-5010"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"
                                >
                                    <Link to="/house"
                                          className="nav-link main-menu-link"
                                    >HOUSE</Link>
                                </li>
                                <li
                                    id="nav-menu-item-5011"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"
                                >
                                    <Link to="/room"
                                          className="nav-link main-menu-link"
                                    >ROOMS</Link>
                                </li>
                                <li
                                    id="nav-menu-item-5008"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"
                                >
                                    <Link to="/customer"
                                          className="nav-link main-menu-link"
                                    >CUSTOMER</Link>
                                </li>
                                <li
                                    id="nav-menu-item-5009"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"
                                >
                                    <Link to="/contract"
                                          className="nav-link main-menu-link"
                                    >CONTRACT</Link>
                                </li>

                                <li
                                    id="nav-menu-item-5012"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"
                                >
                                    <a
                                        href="#"
                                        className="nav-link main-menu-link"
                                    >DESTINATIONS</a
                                    >
                                </li>
                                <li
                                    id="nav-menu-item-5013"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"
                                >
                                    <a href="#"
                                       className="nav-link main-menu-link"
                                    >SPECIAL OFFERS</a
                                    >
                                </li>
                                <li
                                    id="nav-menu-item-5013"
                                    className="nav-item menu-item-even menu-item-depth-0 menu-item menu-item-type-post_type menu-item-object-page"
                                >
                                    <Link to="create-service"
                                       id="nav-create"
                                       className="nav-link main-menu-link"
                                    >CREATE
                                    </Link>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <Routes>
                <Route path="/list" element={<Villa/>}/>
            </Routes>
        </>
    )
}

export default Header;
