// Define o pacote onde a classe está localizada
package conexao;

// Importa classes Java SQL necessárias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Declara uma classe chamada ConnectionFactory
public class ConnectionFactory {

	// Declara um objeto de Connection estático
	private static Connection connection;

	// Construtor privado para a classe ConnectionFactory (não utilizado no código)
	private ConnectionFactory(Connection connection) {

	}

	// Método público para obter uma conexão; lança SQLException se a conexão não puder ser estabelecida
	public static Connection getConnection() throws SQLException {
		// Verifica se a conexão é nula
		if (connection == null) {
			// Se for nula, inicializa a conexão
			connection = initConnection();
		} else if (connection != null && connection.isClosed()) {
			// Se não for nula, mas estiver fechada, reinicializa a conexão
			connection = initConnection();
		}
		// Retorna a conexão
		return connection;
	}

	// Método privado para inicializar a conexão com o banco de dados
	private static Connection initConnection() {
        try {
        	// Usa o DriverManager para estabelecer uma conexão com o banco de dados PostgreSQL
            return DriverManager.getConnection(
            		"jdbc:postgresql://localhost:5432/vendas_online_2", "postgres", "Pira2021");
        } catch (SQLException e) {
        	// Lança uma RuntimeException se uma exceção SQL ocorrer durante a inicialização da conexão
            throw new RuntimeException(e);
        }
    }
}