import List from "../components/List";
import Form from "../components/Form";
import React, { useEffect } from "react";
import { useGlobalContext } from "../context";

export default function Odontologos(){

    const {dispatch} = useGlobalContext();

    useEffect(()=>{
        dispatch({type:"set-odontologo-as-controller-and-url"});
    },[]);

    return(
        <div className="main">
            <List />
            <Form/>
        </div>
    )
}