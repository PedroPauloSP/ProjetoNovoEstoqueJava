package Dao;

import conexao.Conexao;
import estoque.Equipamento;
import estoque.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao {

    private Conexao conexao;
    private Connection Conn;

    public FornecedorDao() {
        this.conexao = new Conexao();
        this.Conn = this.conexao.getConexao();
    }

    public void cadastrar(Fornecedor fornecedor) {

        String sql = "INSERT INTO Fornecedor (razaoSocial,cnpj,endereco)VALUES(?,?,?)";
        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getRazaoSocial());
            stmt.setString(2, fornecedor.getCNPJ());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir fornecedor: " + e.getMessage());
        }
    }

    public Fornecedor getnome(String nome) {
        String sql = "SELECT * FROM fornecedor WHERE razaosocial LIKE ?";

        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            Fornecedor fornecedorEncontrado = new Fornecedor();

            if (rs.next()) {
                fornecedorEncontrado.setRazaoSocial(rs.getString("razaosocial"));

                return fornecedorEncontrado;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar " + e.getMessage());
            return null;
        }
    }

    public List<Fornecedor> getFornecedor(String fornecedor) {
        String sql = "SELECT * FROM fornecedor WHERE razaosocial LIKE ?";

        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, "%" + fornecedor + "%");
            ResultSet rs = stmt.executeQuery();

            List<Fornecedor> listaFornecedor = new ArrayList<>();

            while (rs.next()) {
                Fornecedor fornecedores = new Fornecedor();
                fornecedores.setId(rs.getInt("id"));
                fornecedores.setRazaoSocial(rs.getString("razaosocial"));
                fornecedores.setCNPJ(rs.getString("cnpj"));
                fornecedores.setEndereco(rs.getString("endereco"));

                listaFornecedor.add(fornecedores);
            }
            return listaFornecedor;

        } catch (Exception e) {
            return null;
        }
    }
}
