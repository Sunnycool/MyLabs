package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{

    public T add (T model) throws SQLException;

    public void delete(int id) throws SQLException;

    public void update(T model, int id);

    public void select(String param,char selection) throws SQLException;
}
