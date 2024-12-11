package jsl.com.farming.controllers;

import jsl.com.farming.entities.Agricultor;
import jsl.com.farming.service.GranjaServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class GranjaController {
    //objeto de GranjaServices
    private final GranjaServices granjaServices;

    //Constructor creado --> daba error si no
    public GranjaController(GranjaServices granjaServices) {
        this.granjaServices = granjaServices;
    }


    @GetMapping("/")
    public List<Agricultor> getAllGranjas() {

        try {
            return granjaServices.findGranjaById();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los agricultores", e);
        }

    }
}//class
