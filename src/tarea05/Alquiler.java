
package tarea05;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author malon
 */

public class Alquiler {
    private Date fecha;
    private int dias;
    private Cliente cliente;
    private Turismo turismo;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    
    public Alquiler(Cliente cliente, Turismo turismo) {
        this.cliente = cliente;
        this.turismo = turismo;

        turismo.setDisponible(false);

        fecha = new Date();
        dias = 0;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public Turismo getTurismo() {
        return turismo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getDias() {
        return dias;
    }
    
    public void close() {
        Date fechaFin = new Date();
        dias = difDias(fecha, fechaFin);
        turismo.setDisponible(true);
    }

    private int difDias(Date fecha, Date fechaFin) {
        dias = (int) ((fechaFin.getTime() - fecha.getTime()) / MS_DIA);
        return dias;
    }
    
    public double getPrecio() {
        double precio;

        if (dias <= 1) {
            precio = 30 + turismo.getCilindrada() / 100.0;
        } else {
            precio = (30 + turismo.getCilindrada() / 100.0) * dias;
        }

        return precio;
    }
}
