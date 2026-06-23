package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por Id (UPDATE)
    @GetMapping("/listarID")
    public String mostrarNinjasId() {
        return "Mostrar Ninja por ID";
    }

    //Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinja() {
        return "Alterar um Ninja por Id";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaId() {
        return "Deletar Ninja por ID";
    }

}
