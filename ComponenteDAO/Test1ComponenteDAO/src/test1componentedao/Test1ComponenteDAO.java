/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1componentedao;

import dao.DAOFactory;
import dao.design.IAlumnoDAO;
import dao.to.AlumnoTO;
import java.util.ArrayList;

/**
 *
 * @author BRANDON
 */
public class Test1ComponenteDAO {
    public static void main(String[] args) {
        IAlumnoDAO alumnoDAO = DAOFactory.getInstance().getAlumnoDAO();
        ArrayList<AlumnoTO> listaalumnos=alumnoDAO.listaalumno();
        
        System.out.println("-" +
                                "-Codigo-"+
                                "-Nombre-"+
                                "-Apellido-"+
                                "-Edad-"+
                                "-Dni-----");
        for (AlumnoTO alumnoTO : listaalumnos){
            System.out.println("-" +
                                "-" + alumnoTO.getIdalumno() + "-" +
                                "-" + alumnoTO.getNombre() + "-" +
                                "-" + alumnoTO.getApellido() + "-" +
                                "-" + alumnoTO.getEdad() + "-" +
                                "-" + alumnoTO.getDni() + "-----" );
        }
    }
    
}
