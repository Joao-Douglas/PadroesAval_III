package br.ifba.edu.aval.model.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

import java.time.Duration;

// concrete state em um state
public class MomentoLargada implements EstadoProva {
    @Override
    public void registrarLargada(BoletimProva bp) throws AtividadeNaoPermitidaException {
        bp.setEstado(new Pista());
    }

    @Override
    public void registrarChegada(BoletimProva bp, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar chegada antes da largada");
    }

    @Override
    public void registrarPassagem(BoletimProva bp, Integer prisma, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar passagem antes da largada");
    }

    @Override
    public void registrarAtraso(BoletimProva bp, Long minutoEfetivo) {
        bp.minutoPartidaEfetivo = minutoEfetivo;
    }
}
