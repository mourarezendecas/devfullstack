package com.dfs.model;

import com.dfs.enums.EstadoNutricional;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="Dados-antropometricos")
@Table(name="Dados-antropometricos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DadosAntropometricos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    PacienteModel paciente;

    double altura;
    double massaCorporal;
    double massaCorporalUsual;
    double massaCorporalDesejavel;
    double imc;
    EstadoNutricional estadoNutricional;
    double porcetagemAdequacaoMassa;
    double circunferenciaCintura;
    double circunferenciaBraco;
    double circunferenciaPanturrilha;

    public static double calculaIMC(Double altura, Double massaCorporal){
        return massaCorporal/(altura*altura);
    }

    public static EstadoNutricional retornaEstadoNutricional(double imc){
        if(imc<18.5){
            return EstadoNutricional.BAIXO_PESO;
        }
        else if(imc>=18.5&&imc<24.9){
            return EstadoNutricional.EUTROFIA;
        }
        else if(imc>=24.9&&imc<29.9){
            return EstadoNutricional.SOBREPESO;
        }
        else{
            return EstadoNutricional.OBESIDADE;
        }
    }
}
