/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.AlumnoTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BRANDON
 */
public interface IAlumnoDAO {
    public abstract ArrayList<AlumnoTO> listaalumno();
    public abstract String insertaralumno(AlumnoTO alumno);
    public abstract String actualizaralumno(AlumnoTO alumno);
    public abstract String eliminaralumno(List<Integer> idalumno);
    public abstract AlumnoTO datoalumnoporid(Integer id);
}
