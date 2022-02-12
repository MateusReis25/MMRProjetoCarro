package model;

public class Carro {
	
	private Integer cod_veiculo;
	private String modelo;
	private Integer ano;
	
	public Carro( String modelo, Integer ano) {
		super();
		this.modelo = modelo;
		this.ano = ano;
	}

	public Integer getCod_veiculo() {
		return cod_veiculo;
	}

	public void setCod_veiculo(Integer cod_veiculo) {
		this.cod_veiculo = cod_veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
	
}
