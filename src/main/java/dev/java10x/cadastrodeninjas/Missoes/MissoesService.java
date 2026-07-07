package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    MissoesRepository missoesRepository;
    MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissaoId(Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO) {
        MissoesModel missaoCriada = missoesMapper.map(missoesDTO);
        missaoCriada = missoesRepository.save(missaoCriada);
        return missoesMapper.map(missaoCriada);
    }

    public MissoesDTO alterarMissao(Long id, MissoesDTO missao) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missao);
            missaoAtualizada.setId(id);
            missaoAtualizada = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoAtualizada);
        }
        return null;
    }

    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

}
