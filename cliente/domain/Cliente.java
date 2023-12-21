// Define o pacote em que a classe está localizada
package domain;

// Declaração da classe Cliente
public class Cliente {
    
    // Atributo que armazena o identificador do cliente
    private Long id;

    // Atributo que armazena o nome do cliente
    private String nome;

    // Atributo que armazena o código do cliente
    private String codigo;

    // Método getter para obter o identificador do cliente
    public Long getId() {
        return id;
    }

    // Método setter para definir o identificador do cliente
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método setter para definir o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter o código do cliente
    public String getCodigo() {
        return codigo;
    }

    // Método setter para definir o código do cliente
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}