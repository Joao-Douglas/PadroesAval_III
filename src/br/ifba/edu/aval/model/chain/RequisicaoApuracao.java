package br.ifba.edu.aval.model.chain;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.model.BoletimProva;

public class RequisicaoApuracao {

    private Duration tempoMaximo;
    private BoletimProva boletimProva;
    private Duration tempoProva;

    public RequisicaoApuracao(Duration tempoMaximo, BoletimProva boletimProva) {
        this.tempoMaximo = tempoMaximo;
        this.boletimProva = boletimProva;
        this.tempoProva = getTempoMaisAlto();
    }

    public Duration getTempoProva() {
        return tempoProva;
    }

    public void setTempoProva(Duration tempoProva) {
        this.tempoProva = tempoProva;
    }

    public Duration getTempoMaximo() {
        return tempoMaximo;
    }

    public BoletimProva getBoletimProva() {
        return boletimProva;
    }

    private Duration getTempoMaisAlto(){
        List<Integer> ordemPrismas = this.getBoletimProva().getOrdemPrismas();

        Duration tempoMaisAlto = Duration.ZERO;
        for(Integer prismaID : ordemPrismas) {
            Duration tempo = this.getBoletimProva().getTempo(prismaID);
            if(tempo != null && tempo.compareTo(tempoMaisAlto) > 0) {
                tempoMaisAlto = tempo;
            }
        }
        return tempoMaisAlto;
    }
    
}
