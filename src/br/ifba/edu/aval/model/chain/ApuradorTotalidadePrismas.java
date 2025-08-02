package br.ifba.edu.aval.model.chain;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

// concrete handler em um chain of responsibility
// concrete class em um Template Method
public class ApuradorTotalidadePrismas extends ApuradorHandler {
    
    @Override
    protected RequisicaoApuracao apurarRegra(RequisicaoApuracao requisicao) throws DNFException {
        BoletimProva boletim = requisicao.getBoletimProva();
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();

        for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
       		Duration tempo = boletim.getTempo(ordemPrismas.get(iCont));
       		if(ordemPrismas.get(iCont) != Prisma.CHEGADA && tempo == null)
       			throw new DNFException("Atleta não registrou um dos prismas.");
       	}
       	return requisicao;
    }

}
