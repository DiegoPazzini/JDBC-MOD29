// Define o pacote onde a classe de implementação está localizada
package dao;

// Importa classes necessárias do JDBC, SQL e coleções
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Importa a classe ConnectionFactory para obter conexões com o banco de dados
import conexao.ConnectionFactory;

// Importa a classe de domínio Produto
import domain.Produto;

// Declara a classe ProdutoDAO que implementa a interface IProdutoDAO
public class ProdutoDAO implements IProdutoDAO {

    // Método para cadastrar um produto no banco de dados; lança exceção em caso de erro
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            // Obtém uma conexão usando a ConnectionFactory
            connection = ConnectionFactory.getConnection();
            // Obtém a instrução SQL para inserção
            String sql = getSqlInsert();
            // Prepara a instrução com os parâmetros necessários
            stm = connection.prepareStatement(sql);
            // Adiciona os parâmetros à instrução
            adicionarParametrosInsert(stm, produto);
            // Executa a instrução e retorna o número de linhas afetadas no banco de dados
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            // Fecha a conexão, a instrução e o resultado
            closeConnection(connection, stm, null);
        }
    }

    // Método para atualizar um produto no banco de dados; lança exceção em caso de erro
    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, produto);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    // Método para buscar um produto no banco de dados com base no código; lança exceção em caso de erro
    @Override
    public Produto buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm, codigo);
            rs = stm.executeQuery();

            // Se encontrar um resultado no conjunto de resultados
            if (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("ID");
                String descricao = rs.getString("DESCRICAO");
                String cd = rs.getString("CODIGO");
                produto.setId(id);
                produto.setDescricao(descricao);
                produto.setCodigo(cd);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        // Retorna o produto encontrado ou null se não encontrado
        return produto;
    }

    // Método para excluir um produto do banco de dados; lança exceção em caso de erro
    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, produto);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    // Método para buscar todos os produtos no banco de dados; lança exceção em caso de erro
    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> list = new ArrayList<>();
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            // Para cada resultado no conjunto de resultados
            while (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("ID");
                String descricao = rs.getString("DESCRICAO");
                String cd = rs.getString("CODIGO");
                produto.setId(id);
                produto.setDescricao(descricao);
                produto.setCodigo(cd);
                // Adiciona o produto à lista
                list.add(produto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        // Retorna a lista de produtos encontrados
        return list;
    }

    // Método privado para obter a instrução SQL de inserção
    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_PRODUTO_2 (ID, CODIGO, DESCRICAO) ");
        sb.append("VALUES (nextval('SQ_PRODUTO_2'),?,?)");
        return sb.toString();
    }

    // Método privado para adicionar parâmetros à instrução SQL de inserção
    private void adicionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
        stm.setString(2, produto.getDescricao());
    }

    // Método privado para obter a instrução SQL de atualização
    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_PRODUTO_2 ");
        sb.append("SET DESCRICAO = ?, CODIGO = ? ");
        sb.append("WHERE ID = ?");
        return sb.toString();
    }

    // Método privado para adicionar parâmetros à instrução SQL de atualização
    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getDescricao());
        stm.setString(2, produto.getCodigo());
        stm.setLong(3, produto.getId());
    }

    // Método privado para obter a instrução SQL de exclusão
    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM TB_PRODUTO_2 ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }

    // Método privado para adicionar parâmetros à instrução SQL de exclusão
    private void adicionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
    }

    // Método privado para obter a instrução SQL de seleção por código
    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_PRODUTO_2 ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }

    // Método privado para adicionar parâmetros à instrução SQL de seleção por código
    private void adicionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1, codigo);
    }

    // Método privado para obter a instrução SQL de seleção de todos os produtos
    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_PRODUTO_2");
        return sb.toString();
    }

    // Método privado para fechar a conexão, a instrução e o resultado
    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
