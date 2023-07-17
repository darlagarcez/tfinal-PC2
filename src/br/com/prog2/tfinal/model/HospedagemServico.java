package br.com.prog2.tfinal.model;

import java.io.Serializable;
import java.time.LocalDate;

public class HospedagemServico implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codServico;
    private LocalDate data;
    private String codHospedagem;
    private Double valor;
    
	public String getCodServico() {
		return codServico;
	}
	public void setCodServico(String codServico) {
		this.codServico = codServico;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getCodHospedagem() {
		return codHospedagem;
	}
	public void setCodHospedagem(String codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
