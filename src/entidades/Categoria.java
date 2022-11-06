package entidades;

import java.util.Objects;


// Clase que representa la tabla categoria en la base de datos
public class Categoria {
    
    // Variables que representan las columnas de la tabla categoria
    
    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;
    
    // Constructores
    
    public Categoria(){
        
    }
    
    public Categoria(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public Categoria(int id, String nombre, String descripcion, boolean activo){
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.activo = activo;
}
    
    // Setter y Getter
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public boolean isActivo(){
        return activo;
    }
    
    public void setActivo(boolean activo){
        this.activo = activo;
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + (this.activo ? 1 : 0);
    return hash;
}

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }

    
    // Metodo toString
    @Override
    public String toString() {
        return nombre;
    }
}
