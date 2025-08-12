
package estoque;


public class Fornecedor {
    int id;
    String razaosocial;
    String cnpj;
    String endereco;

    public Fornecedor() {
         
    }
   
    public String getRazaoSocial() {
        return razaosocial;
    }

    public void setRazaoSocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String CNPJ) {
        this.cnpj = CNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String Endereco) {
        this.endereco = Endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
 public String toString()
 {
 return this.razaosocial;
 }
    @Override
 public boolean equals (Object objeto)
 {
 Fornecedor f = (Fornecedor) objeto;
 if (this.id == f.getId()){
 return true;
 }
 else {
 return false;
}
 }
}