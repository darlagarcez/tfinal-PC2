package br.com.prog2.tfinal.controller;

import java.util.List;
import br.com.prog2.tfinal.model.Hospedagem;
import br.com.prog2.tfinal.persistencia.HospedagemDAOImp;

public class HospedagemController {
	public String inserir(Hospedagem hospedagem) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.inserir(hospedagem);
	}
	
	public String alterar(Hospedagem hospedagem) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.alterar(hospedagem);
	}
	
	public String excluir(Hospedagem hospedagem) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.excluir(hospedagem);
	}
	
	public List<Hospedagem> listarTodos() {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.listarTodos();
	}
	
	public Hospedagem pesquisarPorCodigo(String codigoHospedagem) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodigo(codigoHospedagem);
	}
}
