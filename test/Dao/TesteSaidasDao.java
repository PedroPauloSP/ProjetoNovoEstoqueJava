/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Dao;

import estoque.Saidas;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class TesteSaidasDao {
    private SaidasDao SaidasDao; 
    
    public TesteSaidasDao() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SaidasDao = new SaidasDao(); 
    Saidas saida = new Saidas ();
    SaidasDao.Cadastrar(saida);
    Saidas saida1 = new Saidas();
    SaidasDao.consulta(0);
    Saidas saida2 = new Saidas();
    SaidasDao.getSaidas();
        
        
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCadastrar() {
       
        Saidas saida = null;
        SaidasDao instance = new SaidasDao();
        instance.Cadastrar(saida);
       
        
    }

    
   @Test
    public void testConsulta() {
       
        int id = 0;
        SaidasDao instance = new SaidasDao();
        Saidas expResult = null;
        Saidas resultado = instance.consulta(id);
        assertEquals(expResult, resultado);
        
       
    }

 

}
