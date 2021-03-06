
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
    
    public Cliente getCliente(String dni) {
        int i = 0;
        int posicion = 0;
        boolean encontrado = false;

        while (i < clientes.length && !encontrado) {

            if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                encontrado = true;
                posicion = i;
            } else {
                i++;
            }
        }

        if (encontrado) {
            return clientes[posicion];
        } else {
            return null;
        }
    }
    public void addCliente(Cliente cliente) {
        int i = 0;
        boolean vacio = false;

        while (i < clientes.length && !vacio) {
            if (clientes[i] == null) {
                vacio = true;
            } else {
                if (clientes[i].getDni().equals(cliente.getDni())) {
                    throw new ExcepcionAlquilerVehiculos("El cliente introducido ya existe");
                } else {
                    i++;
                }
            }
        }

        if (vacio) {
            clientes[i] = cliente;
        } else {
            throw new ExcepcionAlquilerVehiculos("No se puede añadir el nuevo cliente. Límite de clientes alcanzado");
        }
    }
    
    public void delCliente(String dni) {
        int i = 0;
        int posicion = 0;
        boolean encontrado = false;

        while (i < clientes.length && !encontrado) {

            if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
                encontrado = true;
                posicion = i;
            } else {
                i++;
            }
        }

        if (encontrado) {

            for (i = posicion; i < clientes.length - 1; i++) {
                clientes[i] = clientes[i + 1];
            }

            clientes[clientes.length - 1] = null;

        } else {
            throw new ExcepcionAlquilerVehiculos("El cliente a boorar no existe");
        }
    }
    
    public Turismo getTurismo(String matricula) {
        int i = 0;
        int posicion = 0;
        boolean encontrado = false;

        while (i < turismos.length && !encontrado) {

            if (turismos[i] != null && turismos[i].getMatricula().equals(matricula)) {
                encontrado = true;
                posicion = i;
            } else {
                i++;
            }

        }

        if (encontrado) {
            return turismos[posicion];
        } else {
            return null;
        }
    }
    
    public void addTurismo(Turismo turismo) {
        int i = 0;
        boolean vacio = false;

        while (i < turismos.length && !vacio) {

            if (turismos[i] == null) {
                vacio = true;
            } else {
                if (turismos[i].getMatricula().equals(turismo.getMatricula())) {
                    throw new ExcepcionAlquilerVehiculos("El turismo introducido ya existe");
                } else {
                    i++;
                }
            }
        }

        if (vacio) {
            turismos[i] = turismo;
        } else {
            throw new ExcepcionAlquilerVehiculos("No se puede añadir el nuevo turismo. Límite de clientes alcanzado");
        }

    }
    
    public void delTurismo(String matricula) {
        int i = 0;
        int posicion = 0;
        boolean encontrado = false;

        while (i < turismos.length && !encontrado) {
            if (turismos[i] != null && turismos[i].getMatricula().equals(matricula)) {
                encontrado = true;
                posicion = i;
            } else {
                i++;
            }
        }

        if (encontrado && turismos[i].getDisponible()) {

            for (i = posicion; i < turismos.length - 1; i++) {
                turismos[i] = turismos[i + 1];
            }

            turismos[turismos.length - 1] = null;

        } else {

            throw new ExcepcionAlquilerVehiculos("El turismo que desea eliminar no existe o está ocupado");
        }

    }
    
    public void openAlquiler(Cliente cliente, Turismo turismo) {
        int i = 0;
        boolean vacio = false;

        if (turismo.getDisponible()) {

            while (i < alquileres.length && vacio == false) {
                if (alquileres[i] == null) {
                    alquileres[i] = new Alquiler(cliente, turismo);
                    vacio = true;
                } else {
                    i++;
                }
            }
        } else {
            throw new ExcepcionAlquilerVehiculos("El turismo está ocupado.");
        }
    }
    
    public void closeAlquiler(Cliente cliente, Turismo turismo) {
        int i = 0;
        boolean existe = false;

        while (i < alquileres.length && existe == false) {

            if (alquileres[i].getCliente().getDni().equals(cliente.getDni())
                    && alquileres[i].getTurismo().getMatricula().equals(turismo.getMatricula())) {

                existe = true;
            } else {
                i++;
            }

            if (existe == true) {
                alquileres[i].close();
            } else {
                throw new ExcepcionAlquilerVehiculos("No se dispone de ningun alquiler abierto para los datos introducidos.");
            }

        }
    }
}
