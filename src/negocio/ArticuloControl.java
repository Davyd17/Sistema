package negocio;

import datos.ArticuloDAO;
import datos.CategoriaDAO;
import entidades.Articulo;
import entidades.Categoria;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class ArticuloControl {

    private final ArticuloDAO DATOS;
    private final CategoriaDAO DATOSCAT;
    private final Articulo obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;

    public ArticuloControl() {
        this.DATOS = new ArticuloDAO();
        this.DATOSCAT = new CategoriaDAO();
        this.obj = new Articulo();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Articulo> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));

        String[] titulos = {"ID", "Categoria ID", "Categoria", "Codigo", "Nombre", "Precio de venta", "Stock", "Descripcion", "Imagen", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[10];
        this.registrosMostrados = 0;

        for (Articulo item : lista) {
            if (item.isActivo()) {
                estado = "activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getCategoriaId());
            registro[2] = item.getCategoriaNombre();
            registro[3] = item.getCodigo();
            registro[4] = item.getNombre();
            registro[5] = Double.toString(item.getPrecioVenta());
            registro[6] = Integer.toString(item.getStock());
            registro[7] = item.getDescripcion();
            registro[8] = item.getImagen();
            registro[9] = estado;

            this.modeloTabla.addRow(registro);
            registrosMostrados = registrosMostrados + 1;
        }

        return this.modeloTabla;

    }
    
    public DefaultComboBoxModel seleccionar(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Categoria> lista = new ArrayList();
        lista = DATOSCAT.seleccionar();
        
        for(Categoria item:lista){
            items.addElement(new Categoria(item.getId(), item.getNombre()));
        }
        
        return items;
    }

    public String insertar(int categoriaId, String codigo, String nombre, double precioVenta, int stock, String descripcion, String imagen) {

        if (DATOS.existe(nombre)) {
            return "El registro ya existe";
        } else {

            obj.setCategoriaId(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecioVenta(precioVenta);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "El registro no se pudo insertar";
            }

        }

    }

    public String actualizar(int id, int categoriaId, String codigo, String nombre, String nombreAnt, double precioVenta, int Stock, String descripcion, String imagen) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setCategoriaId(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecioVenta(precioVenta);
            obj.setStock(Stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);

            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualizacion";
            }
        } else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe";
            } else {
                obj.setId(id);
                obj.setCategoriaId(categoriaId);
                obj.setCodigo(codigo);
                obj.setNombre(nombre);
                obj.setPrecioVenta(precioVenta);
                obj.setStock(Stock);
                obj.setDescripcion(descripcion);
                obj.setImagen(imagen);

                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualizacion";
                }
            }
        }
    }
    
    public String desactivar(int id){
        if(DATOS.desactivar(id)){
            return "OK";
        } else {
            return "Error al desactivar el registro";
        }
    }
    
    public String activar(int id){
        if(DATOS.activar(id)){
            return "OK";
        } else {
            return "Error al activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }

}
