package core;

import java.sql.ResultSet;

/**
 * Created by dez on 15.09.15.
 */
public interface IDB {
    public ResultSet query(String query);
    public boolean execute(String query);
    public int executeInsert(String query);

}
