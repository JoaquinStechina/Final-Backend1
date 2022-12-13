import Odontologos from "./pages/Odontologos";
import Pacientes from "./pages/Pacientes";
import Turnos from "./pages/Turnos";
import { Route, Routes } from 'react-router-dom'
import {routes} from './Routes'
import Home from "./pages/Home"

function App() {

  return (
    <Routes>
      <Route path={routes.home} element={<Home/>} >
          <Route path={routes.odontologos} element={<Odontologos/>}/>
          <Route path={routes.pacientes} element={<Pacientes/>}/>
          <Route path={routes.turnos} element={<Turnos/>}/>
      </Route>
    </Routes>  
  )
}

export default App
