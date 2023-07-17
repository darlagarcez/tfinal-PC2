package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import br.com.prog2.tfinal.model.Hospedagem;

public class HospedagemDAOImp implements HospedagemDAO {

	@Override
	public String inserir(Hospedagem hospedagem) {
		String sql ="insert into hospedagem(codhospedagem,codchale,codcliente,estado,datainicio,datafim,qtdpessoas,desconto,valorfinal) values (?,?,?,?,?,?,?,?,?)";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, hospedagem.getCodigo());
			pst.setString(2, hospedagem.getCodChale());
			pst.setString(3, hospedagem.getCodCliente());
			pst.setString(4, hospedagem.getEstado());
			pst.setObject(5, hospedagem.getDataInicio());
			pst.setObject(6, hospedagem.getDataFim());
			pst.setInt(5, hospedagem.getQtdPessoas());
			pst.setDouble(7, hospedagem.getDesconto());
			pst.setDouble(7, hospedagem.getValorFinal());
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
	public String alterar(Hospedagem hospedagem) {
		String sql = "update hospedagem set estado=?,datainicio=?,datafim=?,qtdpessoas=?,desconto=?,valorfinal=? where codhospedagem=? and codchale=? and codcliente=?";
		Connection conexao = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, hospedagem.getEstado());
			pst.setObject(2, hospedagem.getDataInicio());
			pst.setObject(3, hospedagem.getDataFim());
			pst.setInt(4, hospedagem.getQtdPessoas());
			pst.setDouble(5, hospedagem.getDesconto());
			pst.setDouble(6, hospedagem.getValorFinal());
			pst.setString(7, hospedagem.getCodigo());
			pst.setString(8, hospedagem.getCodChale());
			pst.setString(9, hospedagem.getCodCliente());
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
	public String excluir(Hospedagem hospedagem) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "delete from hospedagem where codhospedagem=? and codchale=? and codcliente=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, hospedagem.getCodigo());
			pst.setString(2, hospedagem.getCodChale());
			pst.setString(3, hospedagem.getCodCliente());
			
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
	public List<Hospedagem> listarTodos() {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from hospedagem";
		
		List<Hospedagem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Hospedagem hospedagem = new Hospedagem();
					hospedagem.setCodigo(rs.getString(1));
					hospedagem.setCodCliente(rs.getString(2));
					hospedagem.setCodChale(rs.getString(3));
					hospedagem.setEstado(rs.getString(4));
					hospedagem.setDataInicio(rs.getObject(5, LocalDate.class));
					hospedagem.setDataFim(rs.getObject(6, LocalDate.class));
					hospedagem.setQtdPessoas(rs.getInt(7));
					hospedagem.setDesconto(rs.getDouble(8));
					hospedagem.setValorFinal(rs.getDouble(9));
					lista.add(hospedagem);
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
	public Hospedagem pesquisarPorCodigo(String codigoHospedagem) {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "select * from hospedagem where codhospedagem=?";
		
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, codigoHospedagem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Hospedagem hospedagem = new Hospedagem();
				hospedagem.setCodigo(rs.getString(1));
				hospedagem.setCodCliente(rs.getString(2));
				hospedagem.setCodChale(rs.getString(3));
				hospedagem.setEstado(rs.getString(4));
				hospedagem.setDataInicio(rs.getObject(5, LocalDate.class));
				hospedagem.setDataFim(rs.getObject(6, LocalDate.class));
				hospedagem.setQtdPessoas(rs.getInt(7));
				hospedagem.setDesconto(rs.getDouble(8));
				hospedagem.setValorFinal(rs.getDouble(9));
				return hospedagem;
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
