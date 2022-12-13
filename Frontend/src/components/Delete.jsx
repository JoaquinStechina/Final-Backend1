import React from "react";

export default function Delete(){
    function hacerFetch(url,aux){
        fetch(url,aux).catch(err=>console.log(err))
    }

    const handleClick=()=>{
        const aux = {
            method:'DELETE'
        };
    }

    return(
        <div>
            <h2>DANGER DANGER DANGER</h2>
            <button onClick={handleClick}>ELIMINAR TODO</button>
        </div>
    )
}