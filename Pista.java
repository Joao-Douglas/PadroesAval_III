package br.ifba.edu.aval.model.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

import java.time.Duration;

public class Pista implements EstadoProva{
    public void registrarLargada(BoletimProva bp) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Largada já foi registrada");
    }

    @Override
    public void registrarChegada(BoletimProva bp, Duration tempo) {
        bp.passagens.registrarPassagem(Prisma.CHEGADA, tempo);
        bp.setEstado(new PosProva());
    }

    @Override
    public void registrarPassagem(BoletimProva bp, Integer prisma, Duration tempo) {
        bp.passagens.registrarPassagem(prisma, tempo);
    }

    @Override
    public void registrarAtraso(BoletimProva bp, Long minutoEfetivo) {
        bp.minutoPartidaEfetivo = minutoEfetivo;
    }
}
