package br.com.prog2.tfinal.persistencia;

import java.util.List;
import br.com.prog2.tfinal.model.Servico;

public interface ServicoDAO {
	public String inserir(Servico servico);
	public String alterar(Servico servico);
	public String excluir(Servico servico);
	public List<Servico> listarTodos();
	public Servico pesquisarPorCodigo(String codServico);
}
