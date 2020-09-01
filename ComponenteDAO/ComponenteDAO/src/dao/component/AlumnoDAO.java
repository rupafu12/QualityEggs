/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.design.IAlumnoDAO;
import dao.ds.AccesoDB;
import dao.to.AlumnoTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BRANDON
 */
public class AlumnoDAO implements IAlumnoDAO{
    
    private AccesoDB db;
    
    public AlumnoDAO() {
        db = new AccesoDB();
    }
    
    @Override
    public ArrayList<AlumnoTO> listaalumno() {
        ArrayList<AlumnoTO> lista=new ArrayList<AlumnoTO>();
        String procedimientoalmacenado="{CALL sp_listaralumnos()}";
        Connection cn= db.getConnection();
        if(cn!=null){
            try{
                CallableStatement cs=cn.prepareCall(procedimientoalmacenado);
                ResultSet rs=cs.executeQuery();
                while(rs.next()){
                    AlumnoTO alu=new AlumnoTO();
                    alu.setIdalumno(rs.getInt("idalumno"));
                    alu.setNombre(rs.getString("nombre"));
                    alu.setApellido(rs.getString("apellido"));
                    alu.setEdad(rs.getInt("edad"));
                    alu.setDni(rs.getString("dni"));
                    lista.add(alu);
                }
            }catch(SQLException ex){}
            finally{
                try{
                    cn.close();
                }catch (SQLException e){
                }
            }
        }
        return lista;
    }
    
    @Override
    public String insertaralumno(AlumnoTO alumno){
        String rpta=null;
        Connection cn=db.getConnection();
        String procedimientoalmacenado="{CALL sp_omsertaralumno(?,?,?,?)}";
        if(cn!=null){
            try{
                CallableStatement cs=cn.prepareCall(procedimientoalmacenado);
                cs.setString(1,alumno.getNombre());
                cs.setString(2,alumno.getApellido());
                cs.setInt(3,alumno.getEdad());
                cs.setString(4,alumno.getDni());
                int insert=cs.executeUpdate();
                
                if(insert==0){
                    rpta="Error";
                }
            }catch(SQLException ex){rpta=ex.getMessage();}
            finally{
                try{
                    cn.close();
                }catch(SQLException e){
                    rpta = e.getMessage();
                }
            }
        }
        return rpta;
    }
    
    public String actualizaralumni(AlumnoTO alumno){
        String rpta=null;
        Connection cn=db.getConnection();
        String procedimientoalmacenado="{CALL sp_omsertaralumno(?,?,?,?,?)}";
        if(cn!=null){
            try{
                CallableStatement cs=cn.prepareCall(procedimientoalmacenado);
                cs.setInt(1,alumno.getIdalumno());
                cs.setString(2,alumno.getNombre());
                cs.setString(3,alumno.getApellido());
                cs.setInt(4,alumno.getEdad());
                cs.setString(5,alumno.getDni());
                int actualizo=cs.executeUpdate();
                if(actualizo==0){
                    rpta="Error";
                }    
            }catch(SQLException ex){rpta=ex.getMessage();}
            finally{
                try{
                    cn.close();
                }catch(SQLException e){
                    rpta= e.getMessage();
                }
            }
        }
    return rpta;                           
    }
    
    @Override
    public String eliminaralumno(List<Integer> idalumno){
        String rpta=null;
        Connection cn=db.getConnection();
        String procedimientoalmacenado="{CALL sp_eliminaalumno(?)}";
        if(cn!=null){
            try{
                CallableStatement cs=cn.prepareCall(procedimientoalmacenado);
                for(Integer ix : idalumno){
                    cs.setInt(1, ix);
                    cs.executeUpdate();
                }
            }catch(SQLException ex){rpta=ex.getMessage();}
            finally{
                try{
                    cn.close();
                }catch(SQLException e){
                    rpta=e.getMessage();
                }
            }
        }
        return rpta;
    }
    
    @Override
    public AlumnoTO datoalumnoporid(Integer id){
        AlumnoTO alu=new AlumnoTO();
        Connection cn=db.getConnection();
        String procedimientoalmacenado="{CALL sp_datosalumnoporid(?)}";
        if(cn!=null){
            try{
                CallableStatement cs=cn.prepareCall(procedimientoalmacenado);
                cs.setInt(1, id);
                ResultSet rs=cs.executeQuery();
                if(rs.next()){
                    alu.setIdalumno(rs.getInt("idalumno"));
                    alu.setNombre(rs.getString("nombre"));
                    alu.setApellido(rs.getString("apellido"));
                    alu.setEdad(rs.getInt("edad"));
                    alu.setDni(rs.getString("dni"));
                }
            }catch(SQLException ex){}
            finally{
                try{
                    cn.close();
                }catch (SQLException e){ 
                }
            }
        }
        return alu;
    }

    @Override
    public String actualizaralumno(AlumnoTO alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
