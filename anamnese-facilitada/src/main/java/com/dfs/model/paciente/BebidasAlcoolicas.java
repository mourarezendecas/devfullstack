package com.dfs.model.paciente;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Bebidas-alcoolicas")
@Table(name="Bebidas-alcoolicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class BebidasAlcoolicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String tipo;
    String frequencia;
}
