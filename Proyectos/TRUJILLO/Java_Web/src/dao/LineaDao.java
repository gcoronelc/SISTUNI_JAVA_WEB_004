package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Database.AccesoDB;
import entity.Linea;
import service.IcrudDao;

public class LineaDao implements IcrudDao<Linea> {

    //variables
    Connection cn = null;
    Statement stm = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    //------------------
    @Override
    public void create(Linea t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Linea t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Linea t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Linea find(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Linea> readAll() throws Exception {
        List<Linea> lista = new ArrayList<Linea>();
        try {
            cn = AccesoDB.getConnection();
            sql = "select * from lineas";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            //cargar las lineas de rs a la coleccion lista
            while (rs.next()) {
                Linea li = new Linea();
                //asignar valores al objeto li               
                li.setIdlinea(rs.getInt(1));
                li.setNombre(rs.getString(2));
                lista.add(li);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }

}
