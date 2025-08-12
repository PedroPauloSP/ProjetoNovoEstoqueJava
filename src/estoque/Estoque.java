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



        
        
     /*   
     try {
 
 Class.forName( "com.mysql.cj.jdbc.Driver" );
 System.out.println( "Driver JDBC carregado" );
 } catch ( ClassNotFoundException cnfe ) {
 System.out.println( "Driver JDBC nao encontrado : " +
 cnfe.getMessage() );
 }
 Connection con = null;

 try {
 
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque","root","29Pla#174");

 System.out.println( "Conexao com o banco de dados estabelecida." );
 } catch ( SQLException sqle ) {
 System.out.println( "Erro na conexao ao Bando de Dados : " +sqle.getMessage() );  
 }
    
 Statement stmt = null;
 
 try {
 stmt = con.createStatement();
 System.out.println( "Pronto para execucao de comandos sql." );
 } catch ( SQLException sqle ) {
 System.out.println( "Erro no acesso ao Bando de Dados : " +
 sqle.getMessage() );
 }
 
 

}catch (SQLException sqle ){

}
    }
}       
        */
        
         
   
