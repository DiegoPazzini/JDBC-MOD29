// Define o pacote onde a interface está localizada
package dao;

// Importa a classe List do pacote java.util e a classe Produto do pacote domain
import java.util.List;
import domain.Produto;

// Declara uma interface chamada IProdutoDAO
public interface IProdutoDAO {

    // Método para cadastrar um produto; lança uma exceção em caso de erro
    public Integer cadastrar(Produto produto) throws Exception;

    // Método para atualizar um produto; lança uma exceção em caso de erro
    public Integer atualizar(Produto produto) throws Exception;

    // Método para buscar um produto com base no código; lança uma exceção em caso de erro
    public Produto buscar(String codigo) throws Exception;

    // Método para buscar todos os produtos; lança uma exceção em caso de erro
    public List<Produto> buscarTodos() throws Exception;

    // Método para excluir um produto; lança uma exceção em caso de erro
    public Integer excluir(Produto produto) throws Exception;
}