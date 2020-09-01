/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.component.AlumnoDAO;
import dao.design.IAlumnoDAO;

/**
 *
 * @author BRANDON
 */
public class DAOFactory {
    private static DAOFactory daoFao;
    
    static{
        daoFao = new DAOFactory();
    }
    
    public static DAOFactory getInstance(){
        return daoFao;
    }
    
    public IAlumnoDAO getAlumnoDAO(){
        return new AlumnoDAO();
    }

}
