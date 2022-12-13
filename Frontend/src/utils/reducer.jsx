import {url} from "./url"
import {controllers} from "./controllers";

export const reducer = (state,action) =>{
    switch(action.type){
        case "set-odontologo-as-controller-and-url":
            return {controller:controllers.odontologo,url:url.odontologo,data:[]}
        case "set-paciente-as-controller-and-url":
            return {controller:controllers.paciente,url:url.paciente,data:[]}
        case "set-turno-as-controller-and-url":
            return {controller:controllers.turno,url:url.turno,data:[]}
        case "set-controller":
            return {...state,controller:action.payload}            
        case "set-data":
            return {...state,data:action.payload}            
        default:
            return state;
    }
}