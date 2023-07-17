package br.com.prog2.tfinal.controller;

import java.util.List;
import br.com.prog2.tfinal.model.Servico;
import br.com.prog2.tfinal.persistencia.ServicoDAOImp;

public class ServicoController {
	public String inserir(Servico servico) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.inserir(servico);
	}
	public String alterar(Servico servico) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.alterar(servico);
	}
	public String excluir(Servico servico) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.excluir(servico);
	}
	public List<Servico> listarTodos() {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.listarTodos();
	}
	public Servico pesquisarPorCodigo(String codServico) {
		ServicoDAOImp dao = new ServicoDAOImp();
		return dao.pesquisarPorCodigo(codServico);
	}
}
