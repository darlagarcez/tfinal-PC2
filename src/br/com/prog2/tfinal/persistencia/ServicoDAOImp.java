package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.tfinal.model.Servico;

public class ServicoDAOImp implements ServicoDAO {

	@Override
	public String inserir(Servico servico) {
		String sql ="insert into servico(cod_servico,nome_servico,valor_servico) values (?,?,?)";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, servico.getCodigo());
			pst.setString(2, servico.getNome());
			pst.setDouble(3, servico.getValor());
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
	public String alterar(Servico servico) {
		String sql = "update servico set nome_servico=? valor_servico=? where cod_servico=?";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, servico.getNome());
			pst.setDouble(2, servico.getValor());
			pst.setString(3, servico.getCodigo());
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
	public String excluir(Servico servico) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "delete from servico where cod_servico=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, servico.getCodigo());
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
	public List<Servico> listarTodos() {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from servico";
		
		List<Servico> lista = new ArrayList<>();
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Servico servico = new Servico();
					servico.setCodigo(rs.getString(1));
					servico.setNome(rs.getString(2));
					servico.setValor(rs.getDouble(3));
					lista.add(servico);
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
	public Servico pesquisarPorCodigo(String codServico) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from servico where cod_servico=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, codServico);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Servico servico = new Servico();
				servico.setCodigo(rs.getString(1));
				servico.setNome(rs.getString(2));
				servico.setValor(rs.getDouble(3));
				return servico;
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
