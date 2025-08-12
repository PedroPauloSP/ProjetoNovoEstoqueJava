package estoque;

import java.util.Date;

public class Saidas {

    int id;
    Cliente clienteid;
    Equipamento equipamentoid;
    Categoria categoriaid;
    Date data;
    int Quantidade;

    public Saidas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    public Equipamento getEquipamentoid() {
        return equipamentoid;
    }

    public void setEquipamentoid(Equipamento equipamentoid) {
        this.equipamentoid = equipamentoid;
    }

    public Categoria getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categoria categoriaid) {
        this.categoriaid = categoriaid;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

}
