
package entidades;

import java.sql.Date;
import java.util.List;

public class Ingreso {
    
    private int id;
    private int personaId;
    private String personaNombre;
    private int usuarioId;
    private String usuarioNombre;
    private String tipoComprobante;
    private String serieComprobante;
    private String numComprobante;
    private Date fecha;
    private double impuesto;
    private double total;
    private String estado;
    private List<DetalleIngreso> detalles;

    public Ingreso(int id, int personaId, String personaNombre, int usuarioId, String usuarioNombre, String tipoComprobante, String serieComprobante, String numComprobante, Date fecha, double impuesto, double total, String estado, List<DetalleIngreso> detalles) {
        this.id = id;
        this.personaId = personaId;
        this.personaNombre = personaNombre;
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.tipoComprobante = tipoComprobante;
        this.serieComprobante = serieComprobante;
        this.numComprobante = numComprobante;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.total = total;
        this.estado = estado;
        this.detalles = detalles;
    }

    public Ingreso(int id, int personaId, String personaNombre, int usuarioId, String usuarioNombre, String tipoComprobante, String serieComprobante, String numComprobante, Date fecha, double impuesto, double total, String estado) {
        this.id = id;
        this.personaId = personaId;
        this.personaNombre = personaNombre;
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.tipoComprobante = tipoComprobante;
        this.serieComprobante = serieComprobante;
        this.numComprobante = numComprobante;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.total = total;
        this.estado = estado;
    }
    
    
     
    public Ingreso(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getSerieComprobante() {
        return serieComprobante;
    }

    public void setSerieComprobante(String serieComprobante) {
        this.serieComprobante = serieComprobante;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetalleIngreso> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleIngreso> detalles) {
        this.detalles = detalles;
    }
    
    
}
