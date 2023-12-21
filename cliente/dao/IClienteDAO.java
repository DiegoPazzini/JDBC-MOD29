// Define o pacote em que a interface está localizada
package dao;

// Importa a classe List do pacote java.util
import java.util.List;

// Importa a classe Cliente do pacote domain
import domain.Cliente;

// Declaração da interface IClienteDAO
public interface IClienteDAO {

    // Método para cadastrar um cliente, lançando exceção em caso de erro
    public Integer cadastrar(Cliente cliente) throws Exception;

    // Método para atualizar um cliente, lançando exceção em caso de erro
    public Integer atualizar(Cliente cliente) throws Exception;

    // Método para buscar um cliente pelo código, lançando exceção em caso de erro
    public Cliente buscar(String codigo) throws Exception;

    // Método para buscar todos os clientes, lançando exceção em caso de erro
    public List<Cliente> buscarTodos() throws Exception;

    // Método para excluir um cliente, lançando exceção em caso de erro
    public Integer excluir(Cliente cliente) throws Exception;
}