
package tarea05;

import utilidades.Entrada;

/**
 *
 * @author malon
 */

public class Principal {
    public static void main(String[] args) {
        int num = 1;
        AlquilerVehiculos alquilerVehiculos = new AlquilerVehiculos();

        final String MENU = "\n________________________________________________\n"
                + "\n___________MENÚ ALQUILER DE VEHICULOS___________\n\nSeleccione una accion\n"
                + "1. Añadir cliente\n"
                + "2. Borrar cliente\n"
                + "3. Listar clientes\n"
                + "4. Añadir turismo\n"
                + "5. Borrar turismo\n"
                + "6. Listar turismos\n"
                + "7. Abrir un alquiler\n"
                + "8. Cerrar un alquiler\n"
                + "9. Listar alquileres\n"
                + "0. Salir\n_______________________________\n\n";

        Cliente cliente1 = new Cliente("Pepe", "12345678A", "alvarez de castro", "Almería", "04001");
        Cliente cliente2 = new Cliente("Paco", "987654321B", "rafel alberti", "Almería", "04002");
        alquilerVehiculos.addCliente(cliente1);
        alquilerVehiculos.addCliente(cliente2);
        Turismo turismo1 = new Turismo("1234BBB", "Mercedes", "CLS", 2500);
        Turismo turismo2 = new Turismo("4321BBB", "Audi", "A·", 1800);
        alquilerVehiculos.addTurismo(turismo1);
        alquilerVehiculos.addTurismo(turismo2);
        alquilerVehiculos.openAlquiler(cliente1, turismo1);
        alquilerVehiculos.openAlquiler(cliente2, turismo2);

        while (num != 0) {
            System.out.printf(MENU);
            num = Entrada.entero();
            switch (num) {
                case 1:     // Añadir cliente
                    Cliente nuevoCliente;
                    System.out.println("\n___________Nuevo Cliente___________\n");
                    System.out.printf("Introduzca el nombre del nuevo cliente");
                    String nombre = Entrada.cadena();
                    System.out.printf("Introduzca el DNI del nuevo cliente");
                    String dni = Entrada.cadena();
                    System.out.printf("Introduzca la direccion del nuevo cliente");
                    String direccion = Entrada.cadena();
                    System.out.printf("Introduzca la localidad del nuevo cliente");
                    String localidad = Entrada.cadena();
                    System.out.printf("Introduzca el codigoPostal del nuevo cliente");
                    String codigoPostal = Entrada.cadena();
                    try {
                        nuevoCliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);
                        alquilerVehiculos.addCliente(nuevoCliente);
                        System.out.println("Cliente añadido satisfactoriamente\n");
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                        System.out.println("Vuelve a introducir los datos de forma correcta");
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;

                case 2:     // Borrar cliente
                    System.out.println("\n___________Borrar Cliente___________\n");
                    System.out.printf("Introduzca el DNI del cliente que desea borrar");
                    String buscaDni = Entrada.cadena();
                    try {
                        alquilerVehiculos.delCliente(buscaDni);
                        System.out.println("\nCliente borrado satisfactoriamente");
                    } catch (Exception e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;

                case 3:     //Listar clientes
                    int i = 0;
                    System.out.println("\n___________Clientes___________\n");
                    while (i < alquilerVehiculos.clientes.length && alquilerVehiculos.clientes[i] != null) {
                        System.out.println(alquilerVehiculos.clientes[i]);
                        i++;
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;

                case 4:     //Añadir turismo
                    System.out.println("\n___________ Nuevo Turismo___________\n");
                    System.out.printf("Introduzca la matricula del nuevo turismo");
                    String matricula = Entrada.cadena();
                    System.out.printf("Introduzca la marca del nuevo turismo");
                    String marca = Entrada.cadena();
                    System.out.printf("Introduzca el modelo del nuevo turismo");
                    String modelo = Entrada.cadena();
                    System.out.printf("Introduzca la cilindrada del nuevo turismo");
                    int cilindrada = Entrada.entero();

                    try {
                        Turismo turismo = new Turismo(matricula, marca, modelo, cilindrada);
                        alquilerVehiculos.addTurismo(turismo);
                        System.out.println("Cliente añadido satisfactoriamente\n");
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;

                case 5:     //Borrar turismo
                    System.out.println("\n___________Borrar Turismo___________\n");
                    System.out.printf("Introduzca la matricula del turismo que desea borrar");
                    String buscaMatricula = Entrada.cadena();
                    try {
                        alquilerVehiculos.delTurismo(buscaMatricula);
                        System.out.println("Turismo borrado satisfactoriamente\n");
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;

                case 6:     //Listar turismos
                    i = 0;
                    System.out.println("\n___________Turismos___________\n");
                    while (i < alquilerVehiculos.turismos.length && alquilerVehiculos.turismos[i] != null) {
                        System.out.println(alquilerVehiculos.turismos[i]);
                        i++;
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;

                case 7:   // Abrir un alquiler
                    System.out.println("\n___________Nuevo Alquiler___________\n");
                    System.out.printf("Introduzca el DNI del cliente");
                    String clienteDni = Entrada.cadena();
                    Cliente cliente = alquilerVehiculos.getCliente(clienteDni);
                    System.out.printf("Introduzca la matricula del turismo.");
                    String matriculaTurismo = Entrada.cadena();
                    Turismo turismo = alquilerVehiculos.getTurismo(matriculaTurismo);
                    if (cliente == null) {
                        System.out.println("El cliente no existe\n");
                    } else {
                        if (turismo == null) {
                            System.out.println("El turismo no existe\n");
                        } else {
                            try {
                                alquilerVehiculos.openAlquiler(cliente, turismo);
                                System.out.println("Alquiler abierto satisfactoriamente\n");
                            } catch (ExcepcionAlquilerVehiculos e) {
                                System.out.printf("ERROR: %s%n%n", e.getMessage());
                            }
                        }
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;

                case 8:   //Cerrar un alquiler
                    System.out.println("\n___________Cerrar Alquiler___________\n");
                    System.out.printf("Introduzca el DNI del cliente");
                    String cierraDni = Entrada.cadena();
                    cliente = alquilerVehiculos.getCliente(cierraDni);
                    System.out.printf("Introduzca la matricula del turismo.");
                    String cierraMatricula = Entrada.cadena();
                    turismo = alquilerVehiculos.getTurismo(cierraMatricula);
                    if (cliente == null) {
                        System.out.println("El DNI introducido no corresponde a ningún cliente\n");
                    } else {
                        if (turismo == null) {
                            System.out.println("La matrícula introducida no corresponde a ningún turismo\n");
                        } else {

                            try {

                                alquilerVehiculos.closeAlquiler(cliente, turismo);
                                System.out.println("Alquiler cerrado satisfactoriamente\n");

                            } catch (ExcepcionAlquilerVehiculos e) {
                                System.out.printf("ERROR: %s%n%n", e.getMessage());
                            }
                        }
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;

                case 9:     //Listar alquileres
                    i = 0;
                    System.out.println("\n___________Alquileres___________\n");
                    while (i < alquilerVehiculos.alquileres.length && alquilerVehiculos.alquileres[i] != null) {
                        System.out.println(alquilerVehiculos.alquileres[i]);
                        i++;
                    }
                    System.out.println("\n_______________________________\n\n");
                    break;
            }
        }
    }    
}
