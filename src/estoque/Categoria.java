
package estoque;


public class Categoria {
    int id;
    String NomeCategoria;

    public Categoria() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return NomeCategoria;
    }

    public void setNomeCategoria(String NomeCategoria) {
        this.NomeCategoria = NomeCategoria;
    }
    @Override
 public String toString()
 {
 return this.NomeCategoria;
 }
     @Override
 public boolean equals (Object objeto)
 {
 Categoria c = (Categoria) objeto;
 if (this.id == c.getId()){
 return true;
 }
 else {
 return false;
}
 }
 
}
