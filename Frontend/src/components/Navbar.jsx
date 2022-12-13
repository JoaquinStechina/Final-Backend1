import {Link} from "react-router-dom"
import { useGlobalContext } from "../context"
import { routes } from "../routes"

export default function Navbar(){
    const {dispatch} = useGlobalContext();

    return(
        <nav className="navbar">
            <Link to={routes.home}><h2>Home</h2></Link>
            <Link to={routes.odontologos} onClick={()=>dispatch({type:"set-odontologo-as-controller-and-url"})}><h2>Odontologos</h2></Link>
            <Link to={routes.pacientes} onClick={()=>dispatch({type:"set-paciente-as-controller-and-url"})}><h2>Pacientes</h2></Link>
            <Link to={routes.turnos} onClick={()=>dispatch({type:"set-turno-as-controller-and-url"})}><h2>Turnos</h2></Link>
        </nav>
    )
}