package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.state.EstadoProva;
import br.ifba.edu.aval.model.state.MomentoLargada;
import br.ifba.edu.aval.model.state.PreProva;
import br.ifba.edu.aval1.prototype.ListaPassagens;

public class BoletimProva {

	public static final Integer PRE_PROVA = 0;
	public static final Integer MOMENTO_LARGADA = 1;
	public static final Integer PISTA = 2;
	public static final Integer POS_PROVA = 3;

	public String cboNumero;
	public ListaPassagens passagens;
	public Long minutoPartidaPrevisto;
	public Long minutoPartidaEfetivo;

	private EstadoProva estado;

	public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
		this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
		this.estado = new PreProva(); // Estado inicial
	}

	// Getters
	public List<Integer> getOrdemPrismas() {
		return this.passagens.getOrdemPassagem();
	}

	public String cboNumero() {
		return this.cboNumero;
	}

	public Duration getTempo(Integer prismaID) {
		return this.passagens.getTempo(prismaID);
	}

	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		if (minutoPartidaEfetivo == null || minutoPartidaPrevisto == null) {
			throw new AtividadeNaoPermitidaException("Minutos de atraso não disponíveis.");
		}
		return minutoPartidaEfetivo - minutoPartidaPrevisto;
	}

	// Métodos de transição de fase
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		if (estado instanceof PreProva) {
			this.estado = new MomentoLargada();
		} else {
			throw new AtividadeNaoPermitidaException("Fase não permite se apresentar pra largada.");
		}
	}

	public void setEstado(EstadoProva novoEstado) {
		this.estado = novoEstado;
	}

	public EstadoProva getEstado() {
		return this.estado;
	}

	// Métodos delegando pro estado atual
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		estado.registrarLargada(this);
	}

	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		estado.registrarChegada(this, tempo);
	}

	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		estado.registrarPassagem(this, prismaID, tempo);
	}

	public void registrarAtrasoPartida(Long minutoEfetivo) throws AtividadeNaoPermitidaException {
		estado.registrarAtraso(this, minutoEfetivo);
	}

	@Override
	public String toString() {
		return "BoletimProva [cboNumero=" + cboNumero + ", passagens=" + passagens + "]";
	}
}
