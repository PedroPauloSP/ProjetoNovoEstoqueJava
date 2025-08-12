
package conexao;

 import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;

public class Conexao {
    
    public Connection getConexao() {
 
 try {
 Connection conn = DriverManager.getConnection(
 "jdbc:mysql://localhost/estoque ", // linha de conexao
"root", // usuario do mysql
"29Pla#174"// senha do mysql
 );
 return conn;
 
 } catch (Exception e) {
 System.out.println("Erro ao conectar: " + e.getMessage());
 return null;
 }
 
 }
    
      
}
    
    
    
    
    
    
  
    

