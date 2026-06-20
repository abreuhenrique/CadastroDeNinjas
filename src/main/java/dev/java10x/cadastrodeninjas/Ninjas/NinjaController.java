package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Hello, World!";
    }

    //Criar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public String mostrarNinjas() {
        return "Mostrar Ninjas";
    }

    //Mostrar Ninja por Id (UPDATE)
    @GetMapping("/todosID")
    public String mostrarNinjasId() {
        return "Mostrar Ninja por ID";
    }

    //Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinja() {
        return "Alterar um Ninja por Id";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinjaId() {
        return "Deletar Ninja por ID";
    }

}
