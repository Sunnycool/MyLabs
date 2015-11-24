package core;

import java.sql.ResultSet;


public interface IDB {
    public ResultSet query(String query);
    public boolean execute(String query);
    public int executeInsert(String query);

}
