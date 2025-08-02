package br.ifba.edu.aval.model.chain;

import java.time.Duration;

import br.ifba.edu.aval.exception.DNFException;

// concrete handler em um chain of responsibility
// concrete class em um Template Method
public class ApuradorTempoMaximo extends ApuradorHandler {

    @Override
    protected RequisicaoApuracao apurarRegra(RequisicaoApuracao requisicao) throws DNFException {
        Duration tempoMaximo = requisicao.getTempoMaximo();
        Duration tempoProva = requisicao.getTempoProva();

        if(tempoProva.compareTo(tempoMaximo) > 0)
   			throw new DNFException("O atleta finalizou a prova, após o tempo limite");
        return requisicao;
    }

}
