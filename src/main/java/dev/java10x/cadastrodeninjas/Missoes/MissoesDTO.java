package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;

}
