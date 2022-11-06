package negocio;

import datos.ArticuloDAO;
import datos.IngresoDAO;
import entidades.Articulo;
import entidades.DetalleIngreso;
import entidades.Ingreso;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;

public class IngresoControl {

    private final IngresoDAO DATOS;
    private final ArticuloDAO DATOSART;
    private final Ingreso obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;

    public IngresoControl() {
        this.DATOS = new IngresoDAO();
        this.DATOSART = new ArticuloDAO();
        this.obj = new Ingreso();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Ingreso> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));

        String[] titulos = {"ID", "Usuario ID", "Usuario", "Proveedor ID", "Proveedor", "Tipo Comprobante", "Serie", "Numero", "Fecha", "Impuesto", "Total", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[12];
        this.registrosMostrados = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        for (Ingreso item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getUsuarioId());
            registro[2] = item.getUsuarioNombre();
            registro[3] = Integer.toString(item.getPersonaId());
            registro[4] = item.getPersonaNombre();
            registro[5] = item.getTipoComprobante();
            registro[6] = item.getSerieComprobante();
            registro[7] = item.getPersonaNombre();
            registro[8] = sdf.format(item.getFecha());
            registro[9] = Double.toString(item.getImpuesto());
            registro[10] = Double.toString(item.getTotal());
            registro[11] = item.getEstado();

            this.modeloTabla.addRow(registro);
            registrosMostrados = registrosMostrados + 1;
        }

        return this.modeloTabla;

    }
    
    public Articulo obtenerArticuloCodigoIngreso(String codigo){
        Articulo art = DATOSART.obtenerArticuloCodigoIngreso(codigo);
        return art;
    }

    public String insertar(int personaID, String tipoComprobante, String serieComprobante, String numComprobante, Double impuesto, Double total, DefaultTableModel modeloDetalles) {

        if (DATOS.existe(serieComprobante, numComprobante)) {
            return "El registro ya existe";
        } else {

            obj.setUsuarioId(Variables.usuarioId);
            obj.setPersonaId(personaID);
            obj.setTipoComprobante(tipoComprobante);
            obj.setSerieComprobante(serieComprobante);
            obj.setNumComprobante(numComprobante);
            obj.setImpuesto(impuesto);
            obj.setTotal(total);

            List<DetalleIngreso> detalles = new ArrayList();

            int articuloId;
            int cantidad;
            double precio;

            for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
                articuloId = Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 0)));
                cantidad = Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 3)));
                precio = Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 4)));
                detalles.add(new DetalleIngreso(articuloId, cantidad, precio));
            }

            obj.setDetalles(detalles);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "El registro no se pudo insertar";
            }

        }

    }

    public String anular(int id) {
        if (DATOS.anular(id)) {
            return "OK";
        } else {
            return "Error al desactivar el registro";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }

}
