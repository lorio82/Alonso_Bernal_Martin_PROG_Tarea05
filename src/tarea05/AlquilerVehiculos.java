
package tarea05;

/**
 *
 * @author malon
 */

public class AlquilerVehiculos {
    private final int MAX_CLIENTES = 50;
    private final int MAX_TURISMOS = 10;
    private final int MAX_ALQUILERES = 1000;
    Cliente[] clientes;
    Turismo[] turismos;
    Alquiler[] alquileres;
    
    public AlquilerVehiculos() {
        clientes = new Cliente[MAX_CLIENTES];
        turismos = new Turismo[MAX_TURISMOS];
        alquileres = new Alquiler[MAX_ALQUILERES];
    }
    
    public Cliente[] getClientes() {
        return clientes;
    }

    public Turismo[] getTurismos() {
        return turismos;
    }

    public Alquiler[] getAlquileres() {
        return alquileres;
    }
}
