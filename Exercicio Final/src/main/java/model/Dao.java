package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Conexao;

public class Dao {

	public Dao() {
		
	}
	
	public void inserir (Carro carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into carro (modelo, ano) VALUES (?, ?)");
			
			p.setString(1, carro.getModelo());
			p.setInt(2, carro.getAno());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<Carro> exibir(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Carro> lista = new ArrayList<Carro>();
		try {
			PreparedStatement p = con.prepareStatement("select * from carro");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer cod_veiculo = r.getInt("cod_veiculo");
				String modelo = r.getString("modelo");
				Integer ano = r.getInt("ano");
				Carro carro = new Carro(modelo, ano);
				carro.setCod_veiculo(cod_veiculo);
				
				lista.add(carro);
			}
			
			r.close();
			p.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void deletar(Integer cod_veiculo) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from carro where cod_veiculo = ?");
			p.setInt(1, cod_veiculo);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizar(Carro carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update carro set modelo = ?, ano = ?  where cod_veiculo = ? ");
			p.setString(1, carro.getModelo());
			p.setInt(2, carro.getAno());
			p.setInt(3, carro.getCod_veiculo());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Carro recuperarVeiculo (Integer cod_veiculo) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Carro u = null;
		
		try {
			PreparedStatement p = con.prepareStatement("select * from carro where cod_veiculo = ?");
			p.setInt(1, cod_veiculo);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id1 = r.getInt("cod_veiculo");
				String modelo = r.getString("modelo");
				Integer ano = r.getInt("ano");

				u = new Carro(modelo, ano);
				u.setCod_veiculo(id1);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
	