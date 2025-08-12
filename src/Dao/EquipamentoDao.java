package Dao;

import java.sql.Connection;
import conexao.Conexao;
import estoque.Categoria;
import estoque.Equipamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDao {

    private Conexao conexao;
    private Connection Conn;

    public EquipamentoDao() {
        this.conexao = new Conexao();
        this.Conn = (Connection) this.conexao.getConexao();
    }

    public void cadastrar(Equipamento equipamento) {

        String sql = "INSERT INTO equipamento (nome) VALUES" + "(?)";
        try {

            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, equipamento.getNome());
// stmt.setInt(2, equipamento.getCategoriaid().getId());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro ao inserir equipamento: " + e.getMessage());

        }
    }

    public Equipamento getnome(String nome) {
        String sql = "SELECT * FROM equipamentos WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            Equipamento equipamentoEncontrado = new Equipamento();

            if (rs.next()) {

                equipamentoEncontrado.setNome(rs.getString("nome"));

                return equipamentoEncontrado;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar " + e.getMessage());
            return null;
        }
    }

    public List<Equipamento> getEquipamento(String equipamento) {
        String sql = "SELECT * FROM equipamento WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, "%" + equipamento + "%");
            ResultSet rs = stmt.executeQuery();

            List<Equipamento> listaEquipamento = new ArrayList<>();

            while (rs.next()) {
                Equipamento equipamentos = new Equipamento();

                equipamentos.setId(rs.getInt("id"));
                equipamentos.setNome(rs.getString("nome"));

                listaEquipamento.add(equipamentos);
            }
            return listaEquipamento;

        } catch (Exception e) {
            return null;

        }

    }
}
