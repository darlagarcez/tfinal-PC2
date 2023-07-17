package br.com.prog2.tfinal.controller;

import java.time.LocalDate;
import java.util.List;
import br.com.prog2.tfinal.model.HospedagemServico;
import br.com.prog2.tfinal.persistencia.HospedagemServicoDAOImp;

public class HospedagemServicoController {
	public String inserir(HospedagemServico hospedagemServico) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.inserir(hospedagemServico);
	}
	public String alterar(HospedagemServico hospedagemServico) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.alterar(hospedagemServico);
	}
	public String excluir(HospedagemServico hospedagemServico) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.excluir(hospedagemServico);
	}
	public List<HospedagemServico> listarTodos() {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.listarTodos();
	}
	public HospedagemServico pesquisarPorCodigo(String codServico, LocalDate data, String codHospedagem) {
		HospedagemServicoDAOImp dao = new HospedagemServicoDAOImp();
		return dao.pesquisarPorCodigo(codServico, data, codHospedagem);
	}
}
