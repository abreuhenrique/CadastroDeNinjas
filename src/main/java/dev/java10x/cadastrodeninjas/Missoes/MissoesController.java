package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesDTO> ListarMissoes() {
        return missoesService.listarMissoes();
    }

    @PostMapping("/criar")
    public MissoesDTO CriarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.criarMissao(missao);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO AlterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        return missoesService.alterarMissao(id, missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void DeletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
    }
}
