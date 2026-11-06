package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    //Atributo de la clase Curso
    private int codigo;
    private String grupo;
    private String horario;
    private Asignatura asignatura;
    private Profesor profesorResponsable;
    //Relaciones de la clase Curso
    private List<Estudiante> listCursoEstudiantes;
    private List<EvaluacionAcademica> listCursoEvaluacionAcademicas;

    /**
     * Metodo constructor de la clase Curso
     * @param codigo del curso
     * @param grupo del curso
     * @param horario del curso
     * @param asignatura del curso
     * @param profesorResponsable del curso
     */
    public Curso(int codigo, String grupo, String horario, Asignatura asignatura, Profesor profesorResponsable) {
        this.codigo = codigo;
        this.grupo = grupo;
        this.horario = horario;
        this.asignatura = asignatura;
        this.profesorResponsable = profesorResponsable;
        this.listCursoEstudiantes = new ArrayList<>();
        this.listCursoEvaluacionAcademicas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Profesor getProfesorResponsable() {
        return profesorResponsable;
    }

    public void setProfesorResponsable(Profesor profesorResponsable) {
        this.profesorResponsable = profesorResponsable;
    }

    public List<Estudiante> getListCursoEstudiantes() {
        return listCursoEstudiantes;
    }

    public void setListCursoEstudiantes(List<Estudiante> listCursoEstudiantes) {
        this.listCursoEstudiantes = listCursoEstudiantes;
    }

    public List<EvaluacionAcademica> getListCursoEvaluacionAcademicas() {
        return listCursoEvaluacionAcademicas;
    }

    public void setListCursoEvaluacionAcademicas(List<EvaluacionAcademica> listCursoEvaluacionAcademicas) {
        this.listCursoEvaluacionAcademicas = listCursoEvaluacionAcademicas;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo=" + codigo +
                ", grupo='" + grupo + '\'' +
                ", horario='" + horario + '\'' +
                ", asignatura=" + (asignatura != null ? asignatura.getNombre() : "N/A") +
                ", profesorResponsable=" + (profesorResponsable != null ? profesorResponsable.getNombre() : "N/A") +
                '}';
    }
}
