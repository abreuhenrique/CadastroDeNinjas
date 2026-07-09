package dev.java10x.cadastrodeninjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "ninjas")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeMissao")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;
}
