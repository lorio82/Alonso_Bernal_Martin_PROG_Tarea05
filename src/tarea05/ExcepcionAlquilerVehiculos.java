
package tarea05;

/**
 *
 * @author malon
 */

public class ExcepcionAlquilerVehiculos extends RuntimeException {
    private static final double serialVersionUID = 1L;

    public ExcepcionAlquilerVehiculos(String mensajeError) { 
        super(mensajeError);
    }
}
