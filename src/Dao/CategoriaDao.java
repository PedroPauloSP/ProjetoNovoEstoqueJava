package Dao;

import conexao.Conexao;
import estoque.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    private Conexao conexao;
    private Connection Conn;

    public CategoriaDao() {
        this.conexao = new Conexao();
        this.Conn = Conn = this.conexao.getConexao();
    }

    public void cadastrar(Categoria categoria) {

        String sql = "INSERT INTO categoria (nomecategoria)VALUES(?)";
        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir categoria: " + e.getMessage());
        }
    }

    public Categoria getnome(String nome) {
        String sql = "SELECT * FROM categoria WHERE nomecategoria LIKE ?";

        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            Categoria categoriaEncontrado = new Categoria();

            if (rs.next()) {
                categoriaEncontrado.setId(rs.getInt("id"));
                categoriaEncontrado.setNomeCategoria(rs.getString("nomecategoria"));

                return categoriaEncontrado;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar " + e.getMessage());
            return null;
        }

    }

    public List<Categoria> getCategoria(String categoria) {
        String sql = "SELECT * FROM categoria WHERE nomecategoria LIKE ?";

        try {
            PreparedStatement stmt = this.Conn.prepareStatement(sql);
            stmt.setString(1, "%" + categoria + "%");
            ResultSet rs = stmt.executeQuery();

            List<Categoria> listaCategoria = new ArrayList<>();

            while (rs.next()) {
                Categoria categorias = new Categoria();
                categorias.setId(rs.getInt("id"));
                categorias.setNomeCategoria(rs.getString("nomecategoria"));

                listaCategoria.add(categorias);
            }
            return listaCategoria;

        } catch (Exception e) {
            return null;

        }
    }

}
