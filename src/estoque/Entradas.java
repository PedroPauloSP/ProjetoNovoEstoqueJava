
package estoque;

import java.util.Date;


public class Entradas {
    int id;
    Fornecedor fornecedorid;
    Equipamento equipamentoid;
    Categoria categoriaid;
    Date data;
    int quantidade;

    public Entradas() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fornecedor getFornecedorid() {
        return fornecedorid;
    }

    public void setFornecedorid(Fornecedor fornecedorid) {
        this.fornecedorid = fornecedorid;
    }

    public Equipamento getEquipamentoid() {
        return equipamentoid;
    }

    public void setEquipamentoid(Equipamento equipamentoid) {
        this.equipamentoid = equipamentoid;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.quantidade = Quantidade;
    }

    public Categoria getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categoria categoriaid) {
        this.categoriaid = categoriaid;
    }

  

  

}
