package Dao;

import conexao.Conexao;
import java.sql.Date;
import estoque.Entradas;
import estoque.Equipamento;
import estoque.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import estoque.Categoria;

public class EntradasDao {

    private Conexao conexao;
    private Connection Conn;

    public EntradasDao() {
        this.conexao = new Conexao();
        this.Conn = this.conexao.getConexao();

    }

    public void Cadastrar(Entradas entrada) {
        String sql = "INSERT INTO entrada (fornecedorid, equipamentoid, categoriaid, data, quantidade )VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setInt(1, entrada.getFornecedorid().getId());
            stmt.setInt(2, entrada.getEquipamentoid().getId());
            stmt.setInt(3, entrada.getCategoriaid().getId());
            stmt.setDate(4, (Date) entrada.getData());
            //stmt.setString(5, (String.valueOf(entrada.getQuantidade())));
            stmt.setInt(5, entrada.getQuantidade());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        }
    }

    public Entradas consulta(int id) {
        String sql = "SELECT fornecedorid,equipamentoid,categoriaid,E.data,E.quantidade FROM fornecedor as F INNER JOIN entrada as E ON F.id = fornecedorid INNER JOIN equipamento as q ON q.id = equipamentoid"
                + "INNER JOIN categoria as C ON E.categoriaid = C.id";

        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Entradas entrada = new Entradas();

            Fornecedor forne = new Fornecedor();
            Equipamento equip = new Equipamento();
            Categoria cat = new Categoria();
            entrada.setId(id);
            forne.setRazaoSocial(rs.getString("razaosocial"));
            equip.setNome(rs.getString("nome"));
            cat.setNomeCategoria(rs.getString("nomecategoria"));
            entrada.setCategoriaid(cat);
            entrada.setQuantidade(rs.getInt("quantidade"));
            entrada.setData(rs.getDate("data"));
            entrada.setEquipamentoid(equip);

            return entrada;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Entradas> getEntradas() {

        String sql = "SELECT E.id ,E.fornecedorid, F.razaosocial, E.equipamentoid,q.nome,E.categoriaid, C.nomecategoria, E.data, E.quantidade FROM entrada as E INNER JOIN fornecedor as F ON fornecedorid = F.id INNER JOIN equipamento as q ON E.equipamentoid = q.id INNER JOIN categoria as C ON E.categoriaid = C.id";//,INNER JOIN categoria as C ON q.categoriaid = C.id ";

        try {

            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            // stmt.setString(1, "%" + entrada + "%");
            ResultSet rs = stmt.executeQuery();
            List<Entradas> listaEntrada = new ArrayList<>();

            while (rs.next()) {
                Entradas entradas = new Entradas();
                Fornecedor fornecedores = new Fornecedor();
                Equipamento equip = new Equipamento();
                Categoria cat = new Categoria();

                entradas.setId(rs.getInt("id"));
                entradas.setFornecedorid(fornecedores);
                entradas.setCategoriaid(cat);
                entradas.setEquipamentoid(equip);
                entradas.setData(rs.getDate("data"));
                entradas.setQuantidade(rs.getInt("quantidade"));

                fornecedores.setId(rs.getInt("fornecedorid"));
                fornecedores.setRazaoSocial(rs.getString("razaosocial"));

                equip.setId(rs.getInt("equipamentoid"));
                equip.setNome(rs.getString("nome"));

                cat.setNomeCategoria(rs.getString("nomecategoria"));

                listaEntrada.add(entradas);
            }
            return listaEntrada;

        } catch (Exception e) {
            System.out.println("Erro ao buscar entradas: " + e.getMessage());

            return null;
        }
    }
}
