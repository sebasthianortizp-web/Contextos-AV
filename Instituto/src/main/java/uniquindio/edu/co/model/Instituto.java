package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Instituto {
    //Atributos de la clase Instituto
    private String nombre;
    private int nit;
    //Relaciones de la clase Instituto
    private List<Persona> listIntitutoPersonas;
    private List<Asignatura> listInstitutoAsignaturas;
    private List<DepartamentoAcademico> listIntitutoDepartamentosAcademicos;
    private List<Curso> listIntitutoCursos;

    /**
     * Metodo constructor de Instituto
     * @param nombre del instituto
     * @param nit del instituto
     */
    public Instituto(String nombre, int nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listIntitutoPersonas = new ArrayList<>();
        this.listInstitutoAsignaturas = new ArrayList<>();
        this.listIntitutoDepartamentosAcademicos = new ArrayList<>();
        this.listIntitutoCursos = new ArrayList<>();
    }

    /**
     * Metodo que permite busacr una persona
     * @param id de la persona
     * @return persona
     */
    public Persona buscarPersona(int id){
        for(Persona p: listIntitutoPersonas){
            if(p.getIdentificacion() == id){
                return p;
            }
        }
        return null;
    }

    /**
     * Metodo que permite registrar un estudiante
     * @param id del estudiante
     * @param nombre del estudiante
     * @param correo del estudiante
     * @param telefono del estudiante
     * @param codigoInstitucional del estudiante
     * @param programaAcademico del estudiante
     * @return estudiante
     */
    public boolean registrarEstudiante(int id, String nombre, String correo, int telefono, String codigoInstitucional, String programaAcademico){
        if(buscarPersona(id) != null){
            Estudiante estudiante = new Estudiante(id, nombre, correo, telefono, codigoInstitucional, programaAcademico);
            listIntitutoPersonas.add(estudiante);
            return true;
        }
        return false;
    }

    /**
     * Metodo para registrar un profesor
     * @param id del profesor
     * @param nombre del profesor
     * @param correoIntitucional del profesor
     * @param telefono del profesor
     * @param categoria del profesor
     * @param areaFormacional del profesor
     * @return profesor
     */
    public boolean registrarProfesor(int id, String nombre, String correoIntitucional, int telefono, String categoria, String areaFormacional){
        if(buscarPersona(id) == null){
            Profesor profesor = new Profesor(id, nombre, correoIntitucional, telefono, categoria, areaFormacional);
            listIntitutoPersonas.add(profesor);
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite buscar una asignatura
     * @param codigo de la asignatura
     * @return asignatura
     */
    public Asignatura buscarAsignatura(int codigo){
        for(Asignatura a : listInstitutoAsignaturas){
            if(a.getCodigo() == codigo){
                return a;
            }
        }
        return null;
    }

    /**
     * Metodo que permite registrar una asignatura
     * @param codigo de la asignatura
     * @param nombre de la asignatura
     * @param creditos de la asignatura
     * @return asignatura
     */
    public boolean registrarAsignatura(int codigo, String nombre, int creditos){
        if(buscarAsignatura(codigo) == null){
            listInstitutoAsignaturas.add(new Asignatura(codigo, nombre, creditos));
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite buscar un curso
     * @param codigo
     * @return
     */
    public Curso buscarCurso(int codigo){
        for(Curso c : listIntitutoCursos){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo que permite registrar un curso
     * @param codigo del curso
     * @param grupo del curso
     * @param horario del curso
     * @param codigoAsignatura del curso
     * @param identificaionProfesor del curso
     * @return curso
     */
    public boolean registrarCurso(int codigo, String grupo, String horario, int codigoAsignatura, int identificaionProfesor){
        Asignatura asignatura = buscarAsignatura(codigoAsignatura);
        Persona profesor = buscarPersona(identificaionProfesor);
        if(asignatura != null && profesor instanceof Profesor && buscarCurso(codigo) == null){
            Curso curso = new Curso(codigo, grupo, horario, asignatura, (Profesor) profesor);
            listIntitutoCursos.add(curso);
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite registrar un estudiante a un curso
     * @param idEstudiante del estudiante
     * @param codigoCurso del curso
     * @return
     */
    public boolean matricularEstudiantesCurso(int idEstudiante, int codigoCurso){
        Persona p = buscarPersona(idEstudiante);
        Curso c = buscarCurso(codigoCurso);
        if(p instanceof Estudiante && c != null){
            c.getListCursoEstudiantes().add((Estudiante) p);
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public List<Persona> getListIntitutoPersonas() {
        return listIntitutoPersonas;
    }

    public void setListIntitutoPersonas(List<Persona> listIntitutoPersonas) {
        this.listIntitutoPersonas = listIntitutoPersonas;
    }

    public List<Asignatura> getListInstitutoAsignaturas() {
        return listInstitutoAsignaturas;
    }

    public void setListInstitutoAsignaturas(List<Asignatura> listInstitutoAsignaturas) {
        this.listInstitutoAsignaturas = listInstitutoAsignaturas;
    }

    public List<DepartamentoAcademico> getListIntitutoDepartamentosAcademicos() {
        return listIntitutoDepartamentosAcademicos;
    }

    public void setListIntitutoDepartamentosAcademicos(List<DepartamentoAcademico> listIntitutoDepartamentosAcademicos) {
        this.listIntitutoDepartamentosAcademicos = listIntitutoDepartamentosAcademicos;
    }

    public List<Curso> getListIntitutoCursos() {
        return listIntitutoCursos;
    }

    public void setListIntitutoCursos(List<Curso> listIntitutoCursos) {
        this.listIntitutoCursos = listIntitutoCursos;
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", listIntitutoPersonas=" + listIntitutoPersonas +
                ", listInstitutoAsignaturas=" + listInstitutoAsignaturas +
                ", listIntitutoDepartamentosAcademicos=" + listIntitutoDepartamentosAcademicos +
                ", listIntitutoCursos=" + listIntitutoCursos +
                '}';
    }
}
