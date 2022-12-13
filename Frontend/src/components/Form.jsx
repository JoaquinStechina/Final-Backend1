import React, { useState } from "react";
import { useGlobalContext } from "../context";

export default function Form(){
    const {state,dispatch} = useGlobalContext();
    const [objeto,setObjeto] = useState(state.controller);

    const handleChange = e => {
        let nombre = e.target.name;
        let value = e.target.value;

        if(nombre == 'domicilio' || nombre == 'odontologo' || nombre == 'paciente'){
            state.data.length != 0 ?  setObjeto({...objeto,[nombre]:{"id":value},["id"]:state.data[state.data.length-1].id+1}) :
            setObjeto({...objeto,[nombre]:{"id":value},["id"]:1})
        }
        else{
            state.data.length != 0 ? setObjeto({...objeto,[nombre]:value,["id"]:state.data[state.data.length-1].id+1}) :
            setObjeto({...objeto,[nombre]:value,["id"]:1});
        }
        console.log(objeto);
    }

    const handleSubmit=e=>{
        e.preventDefault();

        const cuerpo = JSON.stringify(objeto);

        const aux = {
            method:"POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body:cuerpo
        }

        dispatch({type:"set-data",payload:[...state.data,objeto]})
        console.log(state.data)

        fetch(state.url,aux)
        .then(resp=>resp.json())
        .then(data=>console.log(data))
        .catch(error=>console.log(error))
    }

    return(
        <form onSubmit={handleSubmit} className="form">
            {Object.keys(objeto).map(e=>{
                let aux = "";
                let input = null;

                if(e == 'odontologo' || e == 'paciente'){
                    aux = e+" id";
                    input = <input onChange={handleChange} type="number" name={e} id={e}/>
                }
                else if(e == 'fecha_alta'){
                    aux = "Fecha de alta";
                    input = <input onChange={handleChange} type="datetime-local" name={e} id={e}/>
                }
                else if(e == "turnos" || e == 'domicilio'){
                    aux = "";
                    input = null;
                }
                else if(e != "id"){
                    aux = e;
                    input = <input onChange={handleChange} type="text" name={e} id={e}/>
                }

                return (
                    <label htmlFor={aux}>
                        <p>{aux.toUpperCase()}</p>
                        {input}
                    </label>
                )
            })}
            <br></br>
            <button type="submit">Agregar</button>
        </form>
    )
}