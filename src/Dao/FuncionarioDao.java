package Dao;

import conexao.Conexao;
import estoque.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuncionarioDao {

    private Conexao conexao;
    private Connection Conn;

    public FuncionarioDao() {
        this.conexao = new Conexao();
        this.Conn = this.conexao.getConexao();
    }

    public void cadastrar(Funcionario funcionario) {

        String sql = "INSERT INTO Funcionario (nome,funcao)VALUES(?,?)";
        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getFuncao());

            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir funcionario: " + e.getMessage());
        }
    }
}
