package uniquindio.edu.co;

import uniquindio.edu.co.model.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Logística del Quindío S.A.", 800987654);
        int opcion = 0;

        while (opcion != 8) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Menu - Empresa de Transporte y Logística
                    1. Registrar Vehículo (Camión, Camioneta o Moto).
                    
                    2. Registrar Conductor.
                    3. Registrar Ruta.
                    4. Registrar Envío y Calcular Tarifa.
                    5. Agregar Historial de Seguimiento a un Envío.
                    6. Buscar Envío y Consultar Tarifas/Tiempos.
                    7. Listar Vehículos Registrados.
                    8. Salir del programa.
                    """));

            if (opcion == 1) {
                String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehículo:");
                String marca = JOptionPane.showInputDialog(null, "Ingrese la marca:");
                String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo:");
                double capacidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la capacidad de carga en Kg:"));

                int opEstado = Integer.parseInt(JOptionPane.showInputDialog(null, "Estado:\n1. DISPONIBLE\n2. EN_RUTA\n3. MANTENIMIENTO"));
                EstadoVehiculo estado = switch (opEstado) {
                    case 2 -> EstadoVehiculo.EN_RUTA;
                    case 3 -> EstadoVehiculo.MANTENIMIENTO;
                    default -> EstadoVehiculo.DISPONIBLE;
                };

                int opTipo = Integer.parseInt(JOptionPane.showInputDialog(null, "Tipo de Vehículo:\n1. Camión\n2. Camioneta\n3. Motocicleta"));
                Vehiculo vehiculo = null;

                if (opTipo == 1) {
                    int ejes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de ejes:"));
                    vehiculo = new Camion(placa, marca, modelo, capacidad, estado, ejes);
                } else if (opTipo == 2) {
                    int platcon = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Tiene platón? (1. Sí / 2. No):"));
                    vehiculo = new Camioneta(placa, marca, modelo, capacidad, estado, platcon == 1);
                } else if (opTipo == 3) {
                    int cil = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el cilindindraje:"));
                    vehiculo = new Motocicleta(placa, marca, modelo, capacidad, estado, cil);
                }

                if (vehiculo != null && empresa.registrarVehiculo(vehiculo)) {
                    JOptionPane.showMessageDialog(null, "Vehículo registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar (placa duplicada).");
                }

            } else if (opcion == 2) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la identificación del conductor:"));
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo:");
                String licencia = JOptionPane.showInputDialog(null, "Ingrese el número de licencia:");
                String tel = JOptionPane.showInputDialog(null, "Ingrese el teléfono:");

                if (empresa.registrarConductor(new Conductor(id, nombre, licencia, tel))) {
                    JOptionPane.showMessageDialog(null, "Conductor registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "El conductor ya se encuentra registrado.");
                }

            } else if (opcion == 3) {
                int codRuta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la ruta:"));
                String origenStr = JOptionPane.showInputDialog(null, "Punto de origen:");
                String destinoStr = JOptionPane.showInputDialog(null, "Punto de destino:");
                double distancia = Double.parseDouble(JOptionPane.showInputDialog(null, "Distancia estimada en Km:"));

                if (empresa.registrarRuta(new Ruta(codRuta, origenStr, destinoStr, distancia))) {
                    JOptionPane.showMessageDialog(null, "Ruta registrada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "La ruta ya existe.");
                }

            } else if (opcion == 4) {
                int codEnvio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del envío:"));
                String desc = JOptionPane.showInputDialog(null, "Descripción de la mercancía:");
                double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Peso en Kg:"));

                String cuedadOrg = JOptionPane.showInputDialog(null, "Ciudad de origen:");
                String dirOrg = JOptionPane.showInputDialog(null, "Dirección de origen:");
                Ubicacion org = new Ubicacion(cuedadOrg, dirOrg, "00000");

                String cuedadDest = JOptionPane.showInputDialog(null, "Ciudad de destino:");
                String dirDest = JOptionPane.showInputDialog(null, "Dirección de destino:");
                Ubicacion dest = new Ubicacion(cuedadDest, dirDest, "00000");

                int opModalidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione Modalidad:\n1. Estándar\n2. Exprés\n3. Prioritario"));
                ModalidadEnvio modalidad = switch (opModalidad) {
                    case 2 -> new EnvioExpres();
                    case 3 -> new EnvioPrioritario();
                    default -> new EnvioEstandar();
                };

                double distanciaKm = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la distancia en Km para calcular la tarifa:"));

                if (empresa.registrarEnvio(codEnvio, desc, peso, org, dest, modalidad, distanciaKm)) {
                    Envio e = empresa.buscarEnvio(codEnvio);
                    JOptionPane.showMessageDialog(null, "¡Envío registrado con éxito!\nCosto Calculado: $" + e.getCostoTotal() + "\nTiempo Estimado: " + e.getTiempoEstimado());
                } else {
                    JOptionPane.showMessageDialog(null, "El código de envío ya existe.");
                }

            } else if (opcion == 5) {
                int codEnvio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del envío a actualizar:"));
                String ubicacion = JOptionPane.showInputDialog(null, "Ubicación actual:");
                String fecha = JOptionPane.showInputDialog(null, "Fecha (YYYY-MM-DD):");
                String hora = JOptionPane.showInputDialog(null, "Hora (HH:MM):");
                String obs = JOptionPane.showInputDialog(null, "Observaciones:");

                if (empresa.agregarSeguimientoEnvio(codEnvio, ubicacion, fecha, hora, obs)) {
                    JOptionPane.showMessageDialog(null, "Seguimiento agregado al historial con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Envío no encontrado.");
                }

            } else if (opcion == 6) {
                int codEnvio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del envío a buscar:"));
                Envio envio = empresa.buscarEnvio(codEnvio);
                if (envio != null) {
                    JOptionPane.showMessageDialog(null, "Información del Envío:\n" + envio.toString() + "\nHistorial: " + envio.getListEnvioHistorialSeguimiento());
                } else {
                    JOptionPane.showMessageDialog(null, "Envío no encontrado.");
                }

            } else if (opcion == 7) {
                JOptionPane.showMessageDialog(null, "Flota de Vehículos:\n" + empresa.getListEmpresaVehiculos().toString());

            } else if (opcion == 8) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa de Transporte y Logística.");
            }
        }
    }
}
