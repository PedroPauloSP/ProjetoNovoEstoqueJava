
package estoque;


public class Equipamento {
   int id;
   String nome;
   Categoria categoriaid;

    public Equipamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categoria categoriaid) {
        this.categoriaid = categoriaid;
    }
  
  
   @Override
 public String toString()
 {
 return this.nome;
 }
    @Override
 public boolean equals (Object objeto)
 {
 Equipamento e = (Equipamento) objeto;
 if (this.id == e.getId()){
 return true;
 }
 else {
 return false;
}
 }
}


