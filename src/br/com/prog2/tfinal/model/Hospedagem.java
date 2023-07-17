package br.com.prog2.tfinal.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Hospedagem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String codCliente;
    private String codChale;
    private String estado;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer qtdPessoas;
    private Double desconto;
    private Double valorFinal;

    public Hospedagem () {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodChale() {
		return codChale;
	}

	public void setCodChale(String codChale) {
		this.codChale = codChale;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
}