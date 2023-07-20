package com.dfs.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Apartamentos")
@Table(name="Apartamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NutricionistaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String CRN;
    private String senha;
}
