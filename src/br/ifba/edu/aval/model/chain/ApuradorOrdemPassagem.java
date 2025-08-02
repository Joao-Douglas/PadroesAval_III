package br.ifba.edu.aval.model.chain;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

// concrete handler em um chain of responsibility
// concrete class em um Template Method
public class ApuradorOrdemPassagem extends ApuradorHandler {

    @Override
    protected RequisicaoApuracao apurarRegra(RequisicaoApuracao requisicao) throws DNFException {
        BoletimProva boletim = requisicao.getBoletimProva();
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();

        for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
    		Duration anterior = boletim.getTempo(ordemPrismas.get(iCont));
    		Duration atual = boletim.getTempo(ordemPrismas.get(iCont+1));
    		if(anterior != null && atual != null)
    			if(anterior.compareTo(atual) > 0)
    				throw new DNFException("Atleta registrou prisma fora da ordem");
    	}
        return requisicao;
    }
}
