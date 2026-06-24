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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por Id (UPDATE)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasId(@PathVariable Long id) {
        return ninjaService.listarNinjasId(id);
    }

    //Alterar dados do Ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinja() {
        return "Alterar um Ninja por Id";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaId(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
    }

}
