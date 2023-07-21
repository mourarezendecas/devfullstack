import com.dfs.enums.EstadoNutricional
import com.dfs.model.DadosAntropometricos
import spock.lang.Specification

class DadosAntropometricosSpec extends Specification{
    void 'testa calculo de imc'(){
        when:
        double resultadoObtido = DadosAntropometricos.calculaIMC(altura, massaCorporal)
        then:
        Math.abs(resultadoEsperado - resultadoObtido) < 0.0001
        where:
        altura | massaCorporal | resultadoEsperado
        1.77   | 77            | 77/(1.77*1.77)
    }

    void 'testa retorno da classificacao'(){
        when:
        EstadoNutricional resultadoObtido = DadosAntropometricos.retornaEstadoNutricional(imc)
        then:
        resultadoEsperado == resultadoObtido
        where:
        imc  | resultadoEsperado
        18   | EstadoNutricional.BAIXO_PESO
        18.5 | EstadoNutricional.EUTROFIA
        25   | EstadoNutricional.SOBREPESO
        30   | EstadoNutricional.OBESIDADE
    }
}
