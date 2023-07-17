package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import br.com.prog2.tfinal.model.HospedagemServico;

public class HospedagemServicoDAOImp implements HospedagemServicoDAO {

	@Override
	public String inserir(HospedagemServico hospedagemServico) {
		String sql ="insert into hospedagem_servico(cod_servico,data_servico,codhospedagem,valor) values (?,?,?,?)";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, hospedagemServico.getCodServico());
			pst.setObject(2, hospedagemServico.getData());
			pst.setString(3, hospedagemServico.getCodHospedagem());
			pst.setDouble(4, hospedagemServico.getValor());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao inserir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public String alterar(HospedagemServico hospedagemServico) {
		String sql = "update hospedagem_servico set valor=? where cod_servico=? and data_servico=? and codhospedagem=?";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setDouble(1, hospedagemServico.getValor());
			pst.setString(2, hospedagemServico.getCodServico());
			pst.setObject(3, hospedagemServico.getData());
			pst.setString(4, hospedagemServico.getCodHospedagem());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public String excluir(HospedagemServico hospedagemServico) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "delete from hospedagem_servico where cod_servico=? and data_servico=? and codhospedagem=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, hospedagemServico.getCodServico());
			pst.setObject(2, hospedagemServico.getData());
			pst.setString(3, hospedagemServico.getCodHospedagem());
			int retorno = pst.executeUpdate();
			
			if (retorno > 0) {
				return "Excluído com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch(SQLException e) {
			return "[SQL Exception] " + e.getMessage();
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public List<HospedagemServico> listarTodos() {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from hospedagem_servico";
		
		List<HospedagemServico> lista = new ArrayList<>();
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					HospedagemServico hospedagemServico = new HospedagemServico();
					hospedagemServico.setCodServico(rs.getString(1));
					hospedagemServico.setData(rs.getObject(2, LocalDate.class));
					hospedagemServico.setCodHospedagem(rs.getString(3));
					hospedagemServico.setValor(rs.getDouble(4));
					lista.add(hospedagemServico);
				}
				return lista;
			} else {
			return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(conexao);
		}
	}

	@Override
	public HospedagemServico pesquisarPorCodigo(String codServico, LocalDate data, String codHospedagem) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from hospedagem_servico where cod_servico=? and data_servico=? and codhospedagem=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, codServico);
			pst.setObject(2, data);
			pst.setString(3, codHospedagem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				HospedagemServico hospedagemServico = new HospedagemServico();
				hospedagemServico.setCodServico(rs.getString(1));
				hospedagemServico.setData(rs.getObject(2, LocalDate.class));
				hospedagemServico.setCodHospedagem(rs.getString(3));
				hospedagemServico.setValor(rs.getDouble(4));
				return hospedagemServico;
			} else {
			return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(conexao);
		}
	}
}
