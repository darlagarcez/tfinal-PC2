package br.com.prog2.tfinal.persistencia;

import java.time.LocalDate;
import java.util.List;
import br.com.prog2.tfinal.model.HospedagemServico;

public interface HospedagemServicoDAO {
	public String inserir(HospedagemServico hospedagemServico);
	public String alterar(HospedagemServico hospedagemServico);
	public String excluir(HospedagemServico hospedagemServico);
	public List<HospedagemServico> listarTodos();
	public HospedagemServico pesquisarPorCodigo(String codServico, LocalDate data, String codHospedagem);
	}
