package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    public MissoesModel alterarMissao(Long id, MissoesModel missao) {
        if (missoesRepository.existsById(id)) {
            missao.setId(id);
            missoesRepository.save(missao);
        }
        return null;
    }

    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

}
