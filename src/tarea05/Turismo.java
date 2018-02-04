
package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author malon
 */

public class Turismo {
    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private boolean disponible;
    
    public Turismo(Turismo turismo) {
        matricula = turismo.getMarca();
        marca = turismo.getMarca();
        modelo = turismo.getModelo();
        cilindrada = turismo.getCilindrada();
        disponible = true;
    }

    public Turismo(String matricula, String marca, String modelo, int cilindrada) {

        if (compruebaMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new ExcepcionAlquilerVehiculos("La matrícula introducida no es válida");
        }

        this.marca = marca;
        this.modelo = modelo;

        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        } else {
            throw new ExcepcionAlquilerVehiculos("La cilindrada introducida no es válida");
        }

        disponible = true;
    }
    
    private boolean compruebaMatricula(String matricula) {
        Pattern pat = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
        Matcher mat = pat.matcher(matricula);
        return mat.find();
    }
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
