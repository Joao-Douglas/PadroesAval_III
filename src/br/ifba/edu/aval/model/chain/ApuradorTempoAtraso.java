package br.ifba.edu.aval.model.chain;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

// concrete handler em um chain of responsibility
// concrete class em um Template Method
public class ApuradorTempoAtraso extends ApuradorHandler {

    @Override
    protected RequisicaoApuracao apurarRegra(RequisicaoApuracao requisicao) throws AtividadeNaoPermitidaException {
        Duration tempoProva = requisicao.getTempoProva();
        BoletimProva boletimProva = requisicao.getBoletimProva();
        tempoProva = tempoProva.plus(Duration.ofMinutes(boletimProva.getMinutosAtraso()));
        requisicao.setTempoProva(tempoProva);
        return requisicao;
    }
}
