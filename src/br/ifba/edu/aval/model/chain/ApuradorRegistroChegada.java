package br.ifba.edu.aval.model.chain;

import java.time.Duration;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

// concrete handler em um chain of responsibility
// concrete class em um Template Method
public class ApuradorRegistroChegada extends ApuradorHandler {

    @Override
    protected RequisicaoApuracao apurarRegra(RequisicaoApuracao requisicao) throws DNFException {
        BoletimProva boletim = requisicao.getBoletimProva();
        Duration tempoProva = boletim.getTempo(Prisma.CHEGADA);
        requisicao.setTempoProva(tempoProva);
        
    	if(tempoProva == null)
    		throw new DNFException("Atleta não registrou chegada");
        return requisicao;
    }

}
