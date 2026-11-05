package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    //Atributos de la clase Empresa
    private String nombreComercial;
    private int nit;
    //Relaciones de la clase Empresa
    private List<Vehiculo> listEmpresaVehiculos;
    private List<Conductor> listEmpresaConductores;
    private List<Ruta> listEmpresaRutas;
    private List<Viaje> listEmpresaViajes;
    private List<Envio> listEmpresaEnvios;

    /**
     * Metodo constructor de la clase Empresa
     * @param nombreComercial de la empresa
     * @param nit de la empresa
     */
    public Empresa(String nombreComercial, int nit) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.listEmpresaVehiculos = new ArrayList<>();
        this.listEmpresaConductores = new ArrayList<>();
        this.listEmpresaRutas = new ArrayList<>();
        this.listEmpresaViajes = new ArrayList<>();
        this.listEmpresaEnvios = new ArrayList<>();
    }

    /**
     * Metodo que permite buscar un vehiculo
     * @param placa del vehiculo
     * @return vehiculo
     */
    public Vehiculo buscarVehiculo(String placa){
        for(Vehiculo v : listEmpresaVehiculos){
            if(v.getPlaca().equalsIgnoreCase(placa)){
                return v;
            }
        }
        return null;
    }

    /**
     * Metodo que permite registrar un vehiculo
     * @param vehiculo
     * @return
     */
    public boolean registrarVehiculo(Vehiculo vehiculo){
        if(buscarVehiculo(vehiculo.getPlaca())==null){
            listEmpresaVehiculos.add(vehiculo);
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite buscar a un conductor
     * @param identificacion del conductor
     * @return
     */
    public Conductor buscarConductor(int identificacion){
        for(Conductor c : listEmpresaConductores){
            if(c.getIdentificacion() == identificacion){
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo que permite registrar a un conductor
     * @param conductor
     * @return
     */
    public boolean registrarConductor(Conductor conductor){
        if(buscarConductor(conductor.getIdentificacion()) == null){
            listEmpresaConductores.add(conductor);
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite buscar una ruta
     * @param codigo de la ruta
     * @return
     */
    public Ruta buscarRuta(int codigo){
        for(Ruta r : listEmpresaRutas){
            if(r.getCodigo() == codigo){
                return r;
            }
        }
        return null;
    }

    /**
     * Metodo que permite registrar una ruta
     * @param ruta
     * @return
     */
    public boolean registrarRuta(Ruta ruta){
        if(buscarRuta(ruta.getCodigo()) == null){
            listEmpresaRutas.add(ruta);
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite buscar un envio
     * @param codigo del envio
     * @return
     */
    public Envio buscarEnvio(int codigo){
        for(Envio e : listEmpresaEnvios){
            if(e.getCodigo() == codigo){
                return e;
            }
        }
        return null;
    }

    /**
     * Metodo que me permite registrar un envio
     * @param codigo del envio
     * @param descripcion del envio
     * @param peso del envio
     * @param origen del envio
     * @param destino del envio
     * @param modalidadEnvio del envio
     * @param distanciaKm del envio
     * @return envio
     */
    public boolean registrarEnvio(int codigo, String descripcion, double peso, Ubicacion origen, Ubicacion destino, ModalidadEnvio modalidadEnvio, double distanciaKm){
        if(buscarEnvio(codigo) == null){
            Envio envio = new Envio(codigo,descripcion,peso,origen,destino,modalidadEnvio);
            envio.calcularTarifaTiempo(distanciaKm);
            listEmpresaEnvios.add(envio);
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite agregar el seguimiento del envio
     * @param codigoEnvio del envio
     * @param ubicacion del envio
     * @param fecha del envio
     * @param hora del envio
     * @param observaciones del envio
     * @return el envio
     */
    public boolean agregarSeguimientoEnvio(int codigoEnvio, String ubicacion, String fecha, String hora, String observaciones){
        Envio envio = buscarEnvio(codigoEnvio);
        if(envio != null){
            envio.getListEnvioHistorialSeguimiento().add(new HistorialSeguimiento(ubicacion,fecha,hora,observaciones));
            return true;
        }
        return false;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public List<Vehiculo> getListEmpresaVehiculos() {
        return listEmpresaVehiculos;
    }

    public void setListEmpresaVehiculos(List<Vehiculo> listEmpresaVehiculos) {
        this.listEmpresaVehiculos = listEmpresaVehiculos;
    }

    public List<Conductor> getListEmpresaConductores() {
        return listEmpresaConductores;
    }

    public void setListEmpresaConductores(List<Conductor> listEmpresaConductores) {
        this.listEmpresaConductores = listEmpresaConductores;
    }

    public List<Ruta> getListEmpresaRutas() {
        return listEmpresaRutas;
    }

    public void setListEmpresaRutas(List<Ruta> listEmpresaRutas) {
        this.listEmpresaRutas = listEmpresaRutas;
    }

    public List<Viaje> getListEmpresaViajes() {
        return listEmpresaViajes;
    }

    public void setListEmpresaViajes(List<Viaje> listEmpresaViajes) {
        this.listEmpresaViajes = listEmpresaViajes;
    }

    public List<Envio> getListEmpresaEnvios() {
        return listEmpresaEnvios;
    }

    public void setListEmpresaEnvios(List<Envio> listEmpresaEnvios) {
        this.listEmpresaEnvios = listEmpresaEnvios;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit=" + nit +
                ", listEmpresaVehiculos=" + listEmpresaVehiculos +
                ", listEmpresaConductores=" + listEmpresaConductores +
                ", listEmpresaRutas=" + listEmpresaRutas +
                ", listEmpresaViajes=" + listEmpresaViajes +
                ", listEmpresaEnvios=" + listEmpresaEnvios +
                '}';
    }
}
