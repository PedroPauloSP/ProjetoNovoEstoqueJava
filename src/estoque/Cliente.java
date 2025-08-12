
package estoque;


public class Cliente {
    int id;
    String RazaoSocial;
    String CNPJ;
    String Endereco;

    public Cliente() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }
    

  @Override
 public String toString()
 {
 return this.RazaoSocial;
 }
    @Override
 public boolean equals (Object objeto)
 {
 Cliente e = (Cliente) objeto;
 if (this.id == e.getId()){
 return true;
 }
 else {
 return false;
}
 }
}