package it.unisannio.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.unisannio.prova.ServizioDiProva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerDiProva {
    @Autowired
    private ServizioDiProva servizioDiProva;


    @Operation(description = "una operazione")
    @GetMapping("/ciao")
    public void get(){

    }
}
