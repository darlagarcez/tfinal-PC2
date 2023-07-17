package br.com.prog2.tfinal.persistencia;

import java.util.List;
import br.com.prog2.tfinal.model.Hospedagem;

public interface HospedagemDAO {
	public String inserir(Hospedagem hospedagem);
	public String alterar(Hospedagem hospedagem);
	public String excluir(Hospedagem hospedagem);
	public List<Hospedagem> listarTodos();
	public Hospedagem pesquisarPorCodigo(String codigoHospedagem);
}
