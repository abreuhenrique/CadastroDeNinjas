package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMissao;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //1 Missao Para Muitos Ninjas
    private List<NinjaModel> ninja;

    public MissoesModel() {
    }

}
