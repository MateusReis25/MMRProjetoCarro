package model;

public class IPVA {

	private Integer cod_ipva;
	private Integer anoIpva;
	
	public IPVA(Integer anoIpva) {
		super();
		this.anoIpva = anoIpva;
	}

	public Integer getCod_ipva() {
		return cod_ipva;
	}

	public void setCod_ipva(Integer cod_ipva) {
		this.cod_ipva = cod_ipva;
	}

	public Integer getAnoIpva() {
		return anoIpva;
	}

	public void setAnoIpva(Integer anoIpva) {
		this.anoIpva = anoIpva;
	}
	
	
	public String toString() {
		return this.cod_ipva + " - " + this.anoIpva;
	}
	
	
}
