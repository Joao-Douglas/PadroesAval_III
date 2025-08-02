package br.ifba.edu.aval.model.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

import java.time.Duration;

// concrete state em um state
public class PreProva implements EstadoProva {
    @Override
    public void registrarLargada(BoletimProva bp) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode largar na Pré-Prova");
    }

    @Override
    public void registrarChegada(BoletimProva bp, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode chegar na Pré-Prova");
    }

    @Override
    public void registrarPassagem(BoletimProva bp, Integer prisma, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar prisma na Pré-Prova");
    }

    @Override
    public void registrarAtraso(BoletimProva bp, Long minutoEfetivo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar atraso na Pré-Prova");
    }
}