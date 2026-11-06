package uniquindio.edu.co;

import uniquindio.edu.co.model.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Instituto institucion = new Instituto("Universidad del Quindío", 890000123);
        int opcion = 0;

        while (opcion != 9) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Menu - Sistema de Gestión de Institución Educativa
                    1. Registrar Estudiante.
                    2. Registrar Profesor.
                    3. Registrar Asignatura.
                    4. Crear Curso.
                    5. Matricular Estudiante en Curso.
                    6. Agregar Evaluación a un Curso.
                    7. Calificar Evaluación y Generar Retroalimentación.
                    8. Buscar Curso y Consultar Evaluaciones.
                    9. Salir del programa.
                    """));

            if (opcion == 1) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante:"));
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo:");
                String correo = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico:");
                int tel = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el teléfono:"));
                String codInst = JOptionPane.showInputDialog(null, "Ingrese el código institucional:");
                String programa = JOptionPane.showInputDialog(null, "Ingrese el programa académico:");

                if (institucion.registrarEstudiante(id, nombre, correo, tel, codInst, programa)) {
                    JOptionPane.showMessageDialog(null, "Estudiante registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "La persona ya se encuentra registrada.");
                }

            } else if (opcion == 2) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la identificación del profesor:"));
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo:");
                String correo = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico:");
                int tel = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el teléfono:"));
                String categoria = JOptionPane.showInputDialog(null, "Ingrese la categoría del profesor:");
                String area = JOptionPane.showInputDialog(null, "Ingrese el área de formación:");

                if (institucion.registrarProfesor(id, nombre, correo, tel, categoria, area)) {
                    JOptionPane.showMessageDialog(null, "Profesor registrado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "La persona ya se encuentra registrada.");
                }

            } else if (opcion == 3) {
                int cod = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la asignatura:"));
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la asignatura:");
                int creditos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de créditos:"));

                if (institucion.registrarAsignatura(cod, nombre, creditos)) {
                    JOptionPane.showMessageDialog(null, "Asignatura registrada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "La asignatura ya existe.");
                }

            } else if (opcion == 4) {
                int codCurso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del curso:"));
                String grupo = JOptionPane.showInputDialog(null, "Ingrese el grupo:");
                String horario = JOptionPane.showInputDialog(null, "Ingrese el horario:");
                int codAsig = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la asignatura:"));
                int idProf = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la identificación del profesor encargado:"));

                if (institucion.registrarCurso(codCurso, grupo, horario, codAsig, idProf)) {
                    JOptionPane.showMessageDialog(null, "Curso creado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo crear el curso (Verifique la asignatura, el profesor o el código).");
                }

            } else if (opcion == 5) {
                int idEst = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante:"));
                int codCurso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del curso:"));

                if (institucion.matricularEstudiantesCurso(idEst, codCurso)) {
                    JOptionPane.showMessageDialog(null, "Estudiante matriculado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al matricular (Estudiante o curso no encontrado).");
                }

            } else if (opcion == 6) {
                int codCurso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del curso al que agregará la evaluación:"));
                Curso curso = institucion.buscarCurso(codCurso);

                if (curso != null) {
                    int codEval = Integer.parseInt(JOptionPane.showInputDialog(null, "Código de la evaluación:"));
                    String nombreEval = JOptionPane.showInputDialog(null, "Nombre de la evaluación:");
                    double porcentaje = Double.parseDouble(JOptionPane.showInputDialog(null, "Porcentaje (%):"));
                    String fecha = JOptionPane.showInputDialog(null, "Fecha de realización (YYYY-MM-DD):");

                    int opTipo = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            Tipo de Evaluación:
                            1. Examen Escrito
                            2. Proyecto Práctico
                            3. Exposición Oral
                            """));

                    Evaluacion mecanismo = null;
                    if (opTipo == 1) {
                        int numPreg = Integer.parseInt(JOptionPane.showInputDialog(null, "Número de preguntas:"));
                        mecanismo = new ExamenEscrito(numPreg);
                    } else if (opTipo == 2) {
                        String repo = JOptionPane.showInputDialog(null, "URL del repositorio:");
                        mecanismo = new ProyectoPractico(repo);
                    } else if (opTipo == 3) {
                        int duracion = Integer.parseInt(JOptionPane.showInputDialog(null, "Duración en minutos:"));
                        mecanismo = new ExposicionOral(duracion);
                    }

                    if (mecanismo != null) {
                        EvaluacionAcademica eval = new EvaluacionAcademica(codEval, nombreEval, porcentaje, fecha, mecanismo);
                        curso.getListCursoEvaluacionAcademicas().add(eval);
                        JOptionPane.showMessageDialog(null, "Evaluación registrada en el curso.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Curso no encontrado.");
                }

            } else if (opcion == 7) {
                int codCurso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del curso:"));
                Curso curso = institucion.buscarCurso(codCurso);

                if (curso != null) {
                    int codEval = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la evaluación a calificar:"));
                    EvaluacionAcademica evalEncontrada = null;
                    for (EvaluacionAcademica ev : curso.getListCursoEvaluacionAcademicas()) {
                        if (ev.getCodigo() == codEval) {
                            evalEncontrada = ev;
                            break;
                        }
                    }

                    if (evalEncontrada != null) {
                        double nota = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la nota (0.0 a 5.0):"));
                        String obs = JOptionPane.showInputDialog(null, "Ingrese la observación académica:");
                        evalEncontrada.claificar(nota, obs);

                        String retro = evalEncontrada.getMecanismoEvaluacion().generarRetroalimentacion(evalEncontrada.getCalificacion());
                        JOptionPane.showMessageDialog(null, "¡Evaluación calificada con éxito!\n" + retro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Evaluación no encontrada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Curso no encontrado.");
                }

            } else if (opcion == 8) {
                int codCurso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del curso a consultar:"));
                Curso curso = institucion.buscarCurso(codCurso);
                if (curso != null) {
                    JOptionPane.showMessageDialog(null, "Información del Curso:\n" + curso.toString()
                            + "\nEstudiantes: " + curso.getListCursoEstudiantes().size()
                            + "\nEvaluaciones: " + curso.getListCursoEvaluacionAcademicas());
                } else {
                    JOptionPane.showMessageDialog(null, "Curso no encontrado.");
                }

            } else if (opcion == 9) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa de Gestión Educativa.");
            }
        }
    }
}
