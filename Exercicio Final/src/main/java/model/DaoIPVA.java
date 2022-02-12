package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Conexao;

public class DaoIPVA {

	public DaoIPVA() {
		
	}
	

	
	public void inserirIpva (IPVA ipva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into ipva (anoIpva) VALUES (?)");
			
			p.setInt(1, ipva.getAnoIpva());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<IPVA> exibirIpva(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<IPVA> lista = new ArrayList<IPVA>();
		try {
			PreparedStatement p = con.prepareStatement("select * from ipva");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer cod_ipva = r.getInt("cod_ipva");
				Integer ano = r.getInt("anoIpva");
				IPVA ipva = new IPVA(ano);
				ipva.setCod_ipva(cod_ipva);
				
				lista.add(ipva);
			}
			
			r.close();
			p.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void deletarIpva(Integer cod_ipva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from ipva where cod_ipva = ?");
			p.setInt(1, cod_ipva);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizarIpva(IPVA ipva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update ipva set anoIpva = ?  where cod_ipva = ? ");
			p.setInt(1, ipva.getAnoIpva());
			p.setInt(2, ipva.getCod_ipva());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			
			p.close();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public IPVA recuperarIpva (Integer cod_ipva) {	
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		IPVA u = null;
		
		try {
			PreparedStatement p = con.prepareStatement("select * from ipva where cod_ipva = ?");
			p.setInt(1, cod_ipva);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer ano = r.getInt("anoIpva");

				u = new IPVA(ano);
				u.setCod_ipva(cod_ipva);
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
