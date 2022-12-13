import React,{useEffect} from "react";
import { useGlobalContext } from "../context";

export default function List(){
    const {state,dispatch} = useGlobalContext();

    useEffect(()=>{
        function fetchData(){
            fetch(state.url)
            .then(response=>response.json())
            .then(data=>data.length != 0 ? dispatch({type:"set-data",payload:data}) : null)
            .catch(err=>console.log(err))
        }
        fetchData();
    },[state.controller]); 

    return(
        <>
        <table className="list">
            {console.log(state.data)}
            <thead>
                <tr>
                    {Object.keys(state.controller).map(f=>f != 'turnos' ? <th>{f.toUpperCase()}</th> : null)}
                </tr>
            </thead>
            <tbody>
                {state.data.map(e=><tr>{Object.values(e).map(f=>typeof f != 'object' ? <td>{f}</td> : f != null ? <td>{f.id}</td> : <td>No tiene</td>)}</tr>)}
            </tbody>
        </table>
        </>
    )
}