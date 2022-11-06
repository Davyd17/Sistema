package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    // Constantes para la conexion
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3307/";
    private final String DB = "dbsistema";
    private final String USER = "root";
    private final String PASSWORD = "";
    
    public Connection cadena; // Variable cadena de tipo Connection que almacenara la conexion a mysql y la tabla de datos.
    
    public static Conexion instancia; // Objeto que nos permite aplicar el Patron singleton y crear una unica instancia

    // Constructor que inicializa la variable cadena
    private Conexion() {
        this.cadena = null;
    }
    
    
    // metodo de tipo Connection que nos permite conectar con la base de datos
    public Connection conectar() {
        try {
            
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL + DB, USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0); // Si hay alguna excepcion con la conexion se cierra el programa
        }
        
        return this.cadena;
    }
    
    
    // Metodo para desconectar a la base de datos
    public void desconectar() {
        
        try {
            
            this.cadena.close();
            
        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // Metodo que nos permite obtener la instancia al objeto Conexion y aplicar asi el patron Singleton
    public synchronized static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        
        return instancia;
    }
    
}
