package br.com.prog2.tfinal.controller;

import java.util.List;
import br.com.prog2.tfinal.model.Chale;
import br.com.prog2.tfinal.persistencia.ChaleDAOImp;

public class ChaleController {
	public String inserir(Chale chale) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.inserir(chale);
	}
	
	public String alterar(Chale chale) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.alterar(chale);
	}
	
	public String excluir(Chale chale) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.excluir(chale);
	}
	
	public List<Chale> listarTodos() {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.listarTodos();
	}
	
	public Chale pesquisarPorCodigo(String codigoChale) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.pesquisarPorCodigo(codigoChale);
	}
}
