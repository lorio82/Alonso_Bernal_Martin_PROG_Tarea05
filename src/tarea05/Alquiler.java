
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
}
