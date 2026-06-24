package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080 - dominio principal
//localhost:8080/rota

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> ListarMissoes() {
        return missoesService.listarMissoes();
    }

    //POST -- Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public MissoesModel CriarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }

    //PUT -- Mandar uma requisicao para alterar missoes
    @PutMapping("/alterar/{id}")
    public MissoesModel AlterarMissao(@PathVariable Long id, @RequestBody MissoesModel missao) {
        return missoesService.alterarMissao(id, missao);
    }

    //DELETE -- Mandar uma requisicao para deletar missoes
    @DeleteMapping("/deletar/{id}")
    public void DeletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
    }

}
