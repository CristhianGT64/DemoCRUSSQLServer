package prueba.cris.prueba.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import prueba.cris.prueba.demo.Entities.Continentes;
import prueba.cris.prueba.demo.Service.impl.ContinenteImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class continenteController {


    @Autowired
    private ContinenteImpl continenteImpl;

    @PostMapping("/insertarContinete")
    public void getMethodName(@RequestBody Continentes continentes) {
        this.continenteImpl.IngresarContinete(continentes);
    }

    @PostMapping("/Crearnuevi")
    public void crearPrueba(@RequestParam String nombre) {
        this.continenteImpl.create(nombre);
    }

    @GetMapping("/TraerContinentes")
        public List<Continentes> traerContinentes(){
            return this.continenteImpl.TraerContinetes();
    }

    @DeleteMapping("/EliminarContinete")
        public Boolean EliminarContinete(@RequestParam Integer numContinente){
            return this.continenteImpl.EliminarContinete(numContinente);
        }

    @PutMapping("/ActualizarContinente")
        public Boolean ActualizarContinente(@RequestBody Continentes continentes){
            return this.continenteImpl.ActualizarContinente(continentes);
        }
}
