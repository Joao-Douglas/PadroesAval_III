package br.ifba.edu.aval.model.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

import java.time.Duration;

public interface EstadoProva {
    void registrarLargada(BoletimProva bp) throws AtividadeNaoPermitidaException;
    void registrarChegada(BoletimProva bp, Duration tempo) throws AtividadeNaoPermitidaException;
    void registrarPassagem(BoletimProva bp, Integer prisma, Duration tempo) throws AtividadeNaoPermitidaException;
    void registrarAtraso(BoletimProva bp, Long minutoEfetivo) throws AtividadeNaoPermitidaException;
}

