import List from "../components/List";
import React, { useEffect } from "react";
import { useGlobalContext } from "../context";
import Form from "../components/Form";

export default function Turnos(){

    const {dispatch} = useGlobalContext();

    useEffect(()=>{
        dispatch({type:"set-turno-as-controller-and-url"});
    },[]);

    return(
        <div className="main">
            <List/>
            <Form/>
        </div>
    )
}