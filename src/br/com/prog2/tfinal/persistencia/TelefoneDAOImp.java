package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.tfinal.model.Telefone;

public class TelefoneDAOImp implements TelefoneDAO {

	@Override
	public String inserir(Telefone telefone) {
		String sql ="insert into telefone(telefone,codcliente,tipo_telefone) values (?,?,?)";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, telefone.getTelefone());
			pst.setString(2, telefone.getCodCliente());
			pst.setString(3, telefone.getTipo());
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
	public String alterar(Telefone telefone) {
		String sql = "update telefone set tipo_telefone=? where telefone=? and codcliente=?";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, telefone.getTipo());
			pst.setString(2, telefone.getTelefone());
			pst.setString(3, telefone.getCodCliente());
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
	public String excluir(Telefone telefone) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "delete from telefone where telefone=? and codcliente=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, telefone.getTelefone());
			pst.setString(2, telefone.getCodCliente());
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
	public List<Telefone> listarTodos() {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from telefone";
		
		List<Telefone> lista = new ArrayList<>();
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Telefone telefone = new Telefone();
					telefone.setTelefone(rs.getString(1));
					telefone.setCodCliente(rs.getString(2));
					telefone.setTipo(rs.getString(3));
					lista.add(telefone);
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
	public Telefone pesquisarPorCliente(String codCliente) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from telefone where codcliente=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, codCliente);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Telefone telefone = new Telefone();
				telefone.setTelefone(rs.getString(1));
				telefone.setCodCliente(rs.getString(2));
				telefone.setTipo(rs.getString(3));
				return telefone;
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
