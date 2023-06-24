package com.dfs.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="nutricionista")
@Table(name="nutricionista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Nutricionista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String CRN;
    private String email;
    private String senha;
}
