package br.com.prog2.tfinal.model;

import java.io.Serializable;

public class Chale implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String localizacao;
    private Integer capacidade;
    private Double valorAltaEstacao;
    private Double valorBaixaEstacao;

    public Chale () {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Double getValorAltaEstacao() {
		return valorAltaEstacao;
	}

	public void setValorAltaEstacao(Double valorAltaEstacao) {
		this.valorAltaEstacao = valorAltaEstacao;
	}

	public Double getValorBaixaEstacao() {
		return valorBaixaEstacao;
	}

	public void setValorBaixaEstacao(Double valorBaixaEstacao) {
		this.valorBaixaEstacao = valorBaixaEstacao;
	}
}