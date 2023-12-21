package conexaoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Instância única da conexão para garantir que apenas uma conexão seja aberta durante a execução do programa
    private static Connection connection;

    // Construtor privado para evitar instâncias desnecessárias da ConnectionFactory
    private ConnectionFactory(Connection connection) {
    }

    /**
     * Obtém a conexão com o banco de dados.
     *
     * @return Objeto Connection representando a conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro ao estabelecer a conexão.
     */
    public static Connection getConnection() throws SQLException {
        // Verifica se a conexão ainda não foi inicializada ou está fechada
        if (connection == null || connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    /**
     * Inicializa a conexão com o banco de dados.
     *
     * @return Objeto Connection representando a nova conexão com o banco de dados.
     */
    private static Connection initConnection() {
        try {
            // Estabelece a conexão com o banco de dados PostgreSQL
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/vendas_online_2", "postgres", "Pira2021");
        } catch (SQLException e) {
            // Lança uma exceção RuntimeException se ocorrer um erro ao estabelecer a conexão
            throw new RuntimeException(e);
        }
    }
}
