package uniquindio.edu.co;

import uniquindio.edu.co.model.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma("TecnoShop S.A.S.", "900123456");
        int opcion = 0;

        while (opcion != 9) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Menu - Plataforma de Comercio Electrónico
                    1. Registrar Cliente.
                    2. Buscar Cliente.
                    3. Registrar Producto (Computador, Teléfono o Accesorio).
                    4. Buscar Producto.
                    5. Registrar Pedido con Detalles.
                    6. Buscar Pedido.
                    7. Pagar Pedido (Tarjeta, Transferencia o Billetera).
                    8. Consultar Listado de Productos.
                    9. Salir del programa.
                    """));

            if (opcion == 1) {
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del Cliente: "));
                String nombreCompleto = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del Cliente: ");
                String correo = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico: ");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el teléfono: "));

                boolean registrado = plataforma.registrarCliente(documento, nombreCompleto, correo, telefono);
                if (registrado) {
                    JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un cliente registrado con ese documento.");
                }

            } else if (opcion == 2) {
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del Cliente a buscar: "));
                Cliente cliente = plataforma.buscarCliente(documento);
                if (cliente != null) {
                    JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" + cliente.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                }

            } else if (opcion == 3) {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del producto: "));
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto: ");
                double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio unitario: "));
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad disponible: "));

                int opcionCat = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Seleccione la Categoría:
                        1. COMPUTADORES
                        2. TELEFONOS
                        3. ACCESORIOS
                        """));
                Categoria categoria = switch (opcionCat) {
                    case 1 -> Categoria.COMPUTADORES;
                    case 2 -> Categoria.TELEFONOS;
                    default -> Categoria.ACCESORIOS;
                };

                int opcionTipo = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Seleccione el tipo de Producto:
                        1. Computador
                        2. Teléfono
                        3. Accesorio
                        """));

                Producto producto = null;
                if (opcionTipo == 1) {
                    String procesador = JOptionPane.showInputDialog(null, "Ingrese el procesador: ");
                    int ram = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la memoria RAM en GB: "));
                    producto = new Computador(codigo, nombre, precio, cantidad, categoria, procesador, ram);
                } else if (opcionTipo == 2) {
                    int almacenamiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el almacenamiento en GB: "));
                    int camara = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los megapíxeles de la cámara: "));
                    producto = new Telefono(codigo, nombre, precio, cantidad, categoria, almacenamiento, camara);
                } else if (opcionTipo == 3) {
                    String conexion = JOptionPane.showInputDialog(null, "Ingrese el tipo de conexión (Ej: Bluetooth, USB): ");
                    producto = new Accesorios(codigo, nombre, precio, cantidad, categoria, conexion);
                }

                if (producto != null && plataforma.registrarProducto(producto)) {
                    JOptionPane.showMessageDialog(null, "Producto registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el producto (código existente o datos inválidos).");
                }

            } else if (opcion == 4) {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del producto a buscar: "));
                Producto producto = plataforma.buscarProducto(codigo);
                if (producto != null) {
                    JOptionPane.showMessageDialog(null, "Producto encontrado:\n" + producto.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                }

            } else if (opcion == 5) {
                int codigoPedido = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del pedido: "));
                String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha del pedido (YYYY-MM-DD): ");
                int documentoCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del cliente que realiza el pedido: "));

                List<DetallePedido> detalles = new ArrayList<>();
                String agregarMas = "SI";
                while (agregarMas.equalsIgnoreCase("SI")) {
                    int codigoProducto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del producto que desea agregar: "));
                    Producto producto = plataforma.buscarProducto(codigoProducto);
                    if (producto != null) {
                        int cantidadComprada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad a comprar: "));
                        DetallePedido detalle = new DetallePedido(producto, cantidadComprada, producto.getPrecio());
                        detalles.add(detalle);
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado en el catálogo.");
                    }
                    agregarMas = JOptionPane.showInputDialog(null, "¿Desea agregar otro producto al pedido? (SI/NO)");
                }

                boolean registrado = plataforma.registrarPedido(codigoPedido, fecha, documentoCliente, detalles);
                if (registrado) {
                    JOptionPane.showMessageDialog(null, "Pedido registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el pedido (Cliente no existe o código duplicado).");
                }

            } else if (opcion == 6) {
                int codigoPedido = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del pedido a buscar: "));
                Pedido pedido = plataforma.buscarPedido(codigoPedido);
                if (pedido != null) {
                    JOptionPane.showMessageDialog(null, "Pedido encontrado:\n" + pedido.toString() + "\nDetalles: " + pedido.getListDetallesPedido());
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
                }

            } else if (opcion == 7) {
                int codigoPedido = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del pedido a pagar: "));
                Pedido pedido = plataforma.buscarPedido(codigoPedido);

                if (pedido != null && pedido.getEstado() == EstadoPedido.PENDIENTE) {
                    int opcionPago = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            Seleccione el Medio de Pago:
                            1. Tarjeta de Crédito
                            2. Transferencia Bancaria
                            3. Billetera Digital
                            """));

                    MedioPago medioPago = null;
                    if (opcionPago == 1) {
                        String numTarjeta = JOptionPane.showInputDialog(null, "Ingrese el número de tarjeta: ");
                        String titular = JOptionPane.showInputDialog(null, "Ingrese el titular: ");
                        String cvv = JOptionPane.showInputDialog(null, "Ingrese el CVV: ");
                        medioPago = new TarjetaCredito(numTarjeta, titular, cvv);
                    } else if (opcionPago == 2) {
                        String banco = JOptionPane.showInputDialog(null, "Ingrese el nombre del banco: ");
                        String cuenta = JOptionPane.showInputDialog(null, "Ingrese el número de cuenta: ");
                        medioPago = new TransferenciaBancaria(banco, cuenta);
                    } else if (opcionPago == 3) {
                        String proveedor = JOptionPane.showInputDialog(null, "Ingrese la billetera (Ej: Nequi, PayPal): ");
                        String celular = JOptionPane.showInputDialog(null, "Ingrese el número de celular asociado: ");
                        medioPago = new BilleteraDigital(proveedor, celular);
                    }

                    if (medioPago != null) {
                        boolean pagado = plataforma.pagarPedido(codigoPedido, medioPago);
                        if (pagado) {
                            JOptionPane.showMessageDialog(null, "¡Pago realizado con éxito! Transacción aprobada.\n" + pedido.getTransaccion().toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo procesar el pago.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El pedido no existe o ya no se encuentra en estado PENDIENTE.");
                }

            } else if (opcion == 8) {
                JOptionPane.showMessageDialog(null, "Catálogo de Productos:\n" + plataforma.getListPlataformaProductos().toString());

            } else if (opcion == 9) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa de Comercio Electrónico.");
            }
        }
    }
}
