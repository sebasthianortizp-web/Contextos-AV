package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoAcademico {
    //Atributos de la clase DepartamentoAcademico
    private String nombre;
    //Relaciones de la classe DepartamentoAcademico
    private List<Asignatura> listDepartamentoAsignaturas;

    /**
     * Metodo Constructor de la clase DepartamentoAcademico
     * @param nombre del Departamento Academico
     */
    public DepartamentoAcademico(String nombre) {
        this.nombre = nombre;
        this.listDepartamentoAsignaturas = new ArrayList<Asignatura>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Asignatura> getListDepartamentoAsignaturas() {
        return listDepartamentoAsignaturas;
    }

    public void setListDepartamentoAsignaturas(List<Asignatura> listDepartamentoAsignaturas) {
        this.listDepartamentoAsignaturas = listDepartamentoAsignaturas;
    }

    @Override
    public String toString() {
        return "DepartamentoAcademico{" +
                "nombre='" + nombre + '\'' +
                ", listDepartamentoAsignaturas=" + listDepartamentoAsignaturas +
                '}';
    }
}
