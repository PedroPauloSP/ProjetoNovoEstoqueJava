package estoque;
import Telas.Menu;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import conexao.Conexao;

    public class Estoque {
    

    public static void main(String[] args) {
       Conexao c = new Conexao();
       c.getConexao();
     
       Menu tela = new Menu();
       tela.setVisible(true);
       
        
        
     }
    }



        
        
    
        
         
   
