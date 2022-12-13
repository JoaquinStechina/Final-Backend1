import React,{createContext, useContext, useMemo, useReducer} from "react";
import {reducer} from "./utils/reducer";

export const controllers = {
    odontologos :{
        "id":0,
        "matricula":"",
        "nombre":"",
        "apellido":"",
        "turnos":null
    },
    pacientes :{
        "id":0,
        "nombre":"",
        "apellido":"",
        "dni":"",
        "fecha_alta":"",
        "domicilio":{
            "id":0,
            "calle":"",
            "localidad":"",
            "provincia":""
        },
        "turnos":null
    },
    turnos :{
        "id":0,
        "fecha_alta":"",
        "paciente":{
            "id":0,
            "nombre":"",
            "apellido":"",
            "dni":"",
            "fecha_alta":"",
            "domicilio":{
                "id":"",
                "calle":"",
                "localidad":"",
                "provincia":""
            },
            "turnos":null
        },
        "odontologo":{
            "id":0,
            "matricula":"",
            "nombre":"",
            "apellido":"",
            "turnos":null
        }
    },
}
export const urls = {
    urlOdon : "http://localhost:8080/odontologos",
    urlPaci : "http://localhost:8080/pacientes",
    urlTurn : "http://localhost:8080/turnos"
}

export const InitialState = {url:"", data:[], controller:{}}

export const GlobalStates = createContext();

export default function ContextProvider({children}){
    const [state,dispatch] = useReducer(reducer,InitialState);

    const providerValue = useMemo(()=>({state,dispatch}),[state,dispatch]);

    return(
        <GlobalStates.Provider value={providerValue}>
            {children}
        </GlobalStates.Provider>
    )
};

export const useGlobalContext = () =>{
    return useContext(GlobalStates);
}