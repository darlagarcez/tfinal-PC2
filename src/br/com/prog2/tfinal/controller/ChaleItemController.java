package br.com.prog2.tfinal.controller;

import java.util.List;
import br.com.prog2.tfinal.model.ChaleItem;
import br.com.prog2.tfinal.persistencia.ChaleItemDAOImp;

public class ChaleItemController {
	public String inserir(ChaleItem item) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.inserir(item);
	}
	public String excluir(ChaleItem item) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.excluir(item);
	}
	public List<ChaleItem> listarTodos() {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.listarTodos();
	}
	public ChaleItem pesquisarPorChaleENome(String codChale, String nomeItem) {
		ChaleItemDAOImp dao = new ChaleItemDAOImp();
		return dao.pesquisarPorChaleENome(codChale,nomeItem);
	}
}
