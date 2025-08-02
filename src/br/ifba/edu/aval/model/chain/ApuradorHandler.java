package br.ifba.edu.aval.model.chain;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;


// Handler em um chain of responsibility
// abstract class em um template method
public abstract class ApuradorHandler {

    protected ApuradorHandler nextHandler;
    protected RequisicaoApuracao requisicao;

    public ApuradorHandler() {
        this.nextHandler = null;
    }

    public void setNextHandler(ApuradorHandler nextHandler) {
        if (this.nextHandler == null) {
            this.nextHandler = nextHandler;
        }
        else {
            this.nextHandler.setNextHandler(nextHandler);
        }
    }

    public final RequisicaoApuracao apurar(RequisicaoApuracao requisicao) throws DNFException , AtividadeNaoPermitidaException {
        this.requisicao = requisicao;
		requisicao = apurarRegra(requisicao);
		if (nextHandler != null) {
			requisicao = nextHandler.apurar(requisicao);
		}
		return requisicao;
	}

    protected abstract RequisicaoApuracao apurarRegra(RequisicaoApuracao requisicao) throws DNFException, AtividadeNaoPermitidaException;

}
