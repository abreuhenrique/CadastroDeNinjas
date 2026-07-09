package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissoesDTO> listarMissoesId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissoesId(id);
        return ResponseEntity.ok(missao);
    }

    @PostMapping
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO missaoCriada = missoesService.criarMissao(missoesDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão: " + missaoCriada.getNome() + " - Cadastrada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissoesDTO> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO) {
        MissoesDTO missaoAtualizada = missoesService.atualizarMissao(id, missoesDTO);

        return ResponseEntity.ok(missaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);

        return ResponseEntity.ok()
                .body("Missão: " + id + " Deletada com sucesso!");
    }
}
