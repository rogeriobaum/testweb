package testweb.entidades;

public class Senha {
	
	private Integer id;	
	private Integer numero_senha;
	private String  letra_prioridade;
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public Integer getNumero_senha() {
		return numero_senha;
	}
	public void setNumero_senha(Integer numero_senha) {
		this.numero_senha = numero_senha;
	}
	public String getLetra_prioridade() {
		return letra_prioridade;
	}
	public void setLetra_prioridade(String letra_prioridade) {
		this.letra_prioridade = letra_prioridade;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	

}
