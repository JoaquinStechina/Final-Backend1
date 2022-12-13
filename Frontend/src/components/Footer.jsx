import React from "react";
import DH from "../assets/DH.svg";

export default function Footer(){
    return(
        <footer>
            <p>Powered by</p>
            <img src={DH} alt="imagen de digital house" />
        </footer>
    )
}