package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

//localhost:8080 - dominio principal
//localhost:8080/rota

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    //GET -- Mmandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public String ListarMissoes() {
        return "Missoes";
    }

    //POST -- Mmandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public String CriarMissao() {
        return "Missao Criada";
    }

    //PUT -- Mmandar uma requisicao para alterar missoes
    @PutMapping("/alterar")
    public String AlterarMissao() {
        return "Missao Atualizada";
    }

    //DELETE -- Mmandar uma requisicao para deletar missoes
    @DeleteMapping("/deletar")
    public String DeletarMissao() {
        return "Missao Deletada";
    }

}
