package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author malon
 */

public class Cliente {
    
    private String nombre;
    private String dni;
    private String direccion;
    private String localidad;
    private String codigoPostal;
    private int identificador;
    private static int numClientes = 0;  
    
    public Cliente(Cliente cliente) {
        nombre = cliente.getNombre();
        dni = cliente.getDni();
        direccion = cliente.getDireccion();
        localidad = cliente.getLocalidad();
        codigoPostal = cliente.getCodigoPostal();
        identificador = cliente.getIdentificador();
    }

    public Cliente(String nombre, String dni, String direccion, String localidad, String codigoPostal) {
        this.nombre = nombre;
        
        if (compruebaDni(dni)) {
            this.dni = dni;
        } else {
            throw new ExcepcionAlquilerVehiculos("El DNI introducido introducido no es válido");
        }
        
        this.direccion = direccion;
        this.localidad = localidad;
        
        if (compruebaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        } else {
            throw new ExcepcionAlquilerVehiculos("El Código Postal introducido no válido");
        }
        
        numClientes++;
        identificador = numClientes;
    }
    private boolean compruebaCodigoPostal(String getCodigoPostal) {
        Pattern pat = Pattern.compile("[0-9]{5}");
        Matcher mat = pat.matcher(getCodigoPostal);
        return mat.find();
    }

    private boolean compruebaDni(String getDni) {
        Pattern pat = Pattern.compile("[0-9]{8}[A-Z]");
        Matcher mat = pat.matcher(getDni);
        boolean compruebaDni = mat.find();
        return compruebaDni;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public int getIdentificador() {
        return identificador;
    }
}
