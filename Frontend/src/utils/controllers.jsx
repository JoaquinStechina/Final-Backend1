export const controllers = {
    odontologo :{
        "id":0,
        "matricula":"",
        "nombre":"",
        "apellido":""
    },
    paciente :{
        "id":0,
        "nombre":"",
        "apellido":"",
        "dni":"",
        "fecha_alta":"",
        "domicilio":null
    },
    turno :{
        "id":0,
        "fecha_alta":"",
        "paciente":{
            "id":0,
            "nombre":"",
            "apellido":"",
            "dni":"",
            "fecha_alta":"",
            "domicilio":null
        },
        "odontologo":{
            "id":0,
            "matricula":"",
            "nombre":"",
            "apellido":""
        }
    }
}