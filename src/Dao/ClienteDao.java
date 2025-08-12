package Dao;

import conexao.Conexao;
import estoque.Cliente;
import estoque.Entradas;
import estoque.Equipamento;
import estoque.Fornecedor;
import estoque.Saidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private Conexao conexao;
    private Connection Conn;

    public ClienteDao() {
        this.conexao = new Conexao();
        this.Conn = this.conexao.getConexao();
    }

    public void cadastrar(Cliente cliente) {

        String sql = "INSERT INTO cliente (razaosocial,cnpj,endereco)VALUES(?,?,?)";
        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, cliente.getRazaoSocial());
            stmt.setString(2, cliente.getCNPJ());
            stmt.setString(3, cliente.getEndereco());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public Cliente getnome(String nome) {
        String sql = "SELECT * FROM cliente WHERE razaosocial LIKE ?";

        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            Cliente clienteEncontrado = new Cliente();

            if (rs.next()) {
                clienteEncontrado.setRazaoSocial(rs.getString("razaosocial"));

                return clienteEncontrado;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar " + e.getMessage());
            return null;
        }
    }

    public List<Cliente> getCliente(String cliente) {

        String sql = "SELECT * FROM cliente WHERE razaosocial LIKE ?";

        try {

            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, "%" + cliente + "%");
            ResultSet rs = stmt.executeQuery();

            List<Cliente> ListaCliente = new ArrayList<>();
            while (rs.next()) {
                Cliente clientes = new Cliente();

                clientes.setId(rs.getInt("id"));
                clientes.setRazaoSocial(rs.getString("razaosocial"));
                clientes.setCNPJ(rs.getString("cnpj"));
                clientes.setEndereco(rs.getString("endereco"));

                ListaCliente.add(clientes);
            }
            return ListaCliente;

        } catch (Exception e) {
            return null;

        }

    }
}
