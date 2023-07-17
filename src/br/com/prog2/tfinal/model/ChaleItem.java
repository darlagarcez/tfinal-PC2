package br.com.prog2.tfinal.model;

import java.io.Serializable;

public class ChaleItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codChale;
    private String nomeItem;
    
	public String getCodChale() {
		return codChale;
	}
	public void setCodChale(String codChale) {
		this.codChale = codChale;
	}
	public String getNomeItem() {
		return nomeItem;
	}
	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
}
