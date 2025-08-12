package Dao;

import conexao.Conexao;
import estoque.Categoria;
import java.sql.Date;
import estoque.Cliente;
import estoque.Equipamento;
import estoque.Saidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SaidasDao {

    private Conexao conexao;
    private Connection Conn;

    public SaidasDao() {
        this.conexao = new Conexao();
        this.Conn = Conn = this.conexao.getConexao();

    }

    public void Cadastrar(Saidas saida) {

     
        String sql = "INSERT INTO saidas(clienteid,equipamentoid,categoriaid,quantidade,data)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);

            stmt.setInt(1, saida.getClienteid().getId());
            stmt.setInt(2, saida.getEquipamentoid().getId());
            stmt.setInt(3, saida.getCategoriaid().getId());
            stmt.setInt(4, saida.getQuantidade());
            stmt.setDate(5, (Date) saida.getData());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }

    }

    public Saidas consulta(int id) {
        String sql = "SELECT S.id,C.razaosocial,Q.nome,T.nomecategoria,S.data,S.quantidade FROM saidas as INNER JOIN cliente as C ON S.clienteid = C.id INNER JOIN categoria as T ON S.categoriaid = T.id INNER JOIN equipamento as Q ON S.equipamentoid = Q.id";
        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Saidas saida = new Saidas();
            rs.next();
            Cliente cliente = new Cliente();
            Equipamento equip = new Equipamento();
            Categoria cat = new Categoria();
            saida.setId(id);
            cliente.setRazaoSocial(rs.getString("razaosocial"));
            equip.setNome(rs.getString("nome"));

            cat.setNomeCategoria(rs.getString("nomecategoria"));
            saida.setClienteid(cliente);
            saida.setCategoriaid(cat);
            saida.setQuantidade(rs.getInt("qunatidade"));
            saida.setData(rs.getDate("data"));
            saida.setEquipamentoid(equip);

            return saida;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;

        }
    }

    public List<Saidas> getSaidas() {

        String sql = "SELECT S.id,C.razaosocial,Q.nome,T.nomecategoria, S.data,S.quantidade FROM saidas as S INNER JOIN cliente as C ON S.clienteid = C.id INNER JOIN equipamento as Q ON S.equipamentoid = Q.id INNER JOIN categoria as T ON S.categoriaid = T.id";

        try {

            PreparedStatement stmt = this.Conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            List<Saidas> ListaSaidas = new ArrayList<>();

            while (rs.next()) {
                Saidas saida = new Saidas();
                Cliente cliente = new Cliente();
                Equipamento equip = new Equipamento();
                Categoria cat = new Categoria();

                saida.setId(rs.getInt("id"));
                saida.setClienteid(cliente);
                saida.setEquipamentoid(equip);
                saida.setCategoriaid(cat);
                saida.setData(rs.getDate("data"));
                saida.setQuantidade(rs.getInt("quantidade"));

                cliente.setRazaoSocial(rs.getString("razaosocial"));

                equip.setNome(rs.getString("nome"));
                cat.setNomeCategoria(rs.getString("nomecategoria"));

                ListaSaidas.add(saida);
            }
            return ListaSaidas;

        } catch (Exception e) {
            System.out.println("Erro ao buscar saídas: " + e.getMessage());
            return null;
        }
    }
}
