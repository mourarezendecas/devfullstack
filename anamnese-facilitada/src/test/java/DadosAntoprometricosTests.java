import com.dfs.enums.EstadoNutricional;
import com.dfs.model.DadosAntropometricos;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DadosAntoprometricosTests {

    @Test
    void testaCalculoIMC(){
        //given
        double altura = 1.81;
        double massaCorporal = 77.0;
        double resultadoEsperado = massaCorporal/(altura*altura);
        //when
        double resultadoObtido = DadosAntropometricos.calculaIMC(altura, massaCorporal);
        //then
        assertEquals(resultadoEsperado, resultadoObtido, 0.001);
    }

    @Test
    void testeRetornoClassificacao(){
        //given
        double imc = 18.0;
        EstadoNutricional resultadoEsperado = EstadoNutricional.BAIXO_PESO;
        //when
        EstadoNutricional resultadoObtido = DadosAntropometricos.retornaEstadoNutricional(imc);
        //then
        assertEquals(resultadoEsperado,resultadoObtido);
    }
}
