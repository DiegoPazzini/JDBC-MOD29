// Define o pacote onde a classe de domínio Produto está localizada
package domain;

// Declaração da classe Produto, que representa um objeto no domínio do sistema
public class Produto {
	
    // Atributo que armazena o identificador único do produto
	private Long id;

    // Atributo que armazena a descrição do produto
	private String descricao;

    // Atributo que armazena o código do produto
	private String codigo;

    // Método getter para obter o identificador do produto
	public Long getId() {
		return id;
	}

    // Método setter para definir o identificador do produto
	public void setId(Long id) {
		this.id = id;
	}

    // Método getter para obter a descrição do produto
	public String getDescricao() {
		return descricao;
	}

    // Método setter para definir a descrição do produto
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    // Método getter para obter o código do produto
	public String getCodigo() {
		return codigo;
	}

    // Método setter para definir o código do produto
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
