package model.dao.extracter.getters;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface Getter<V> {
    public V getValueFrom(ResultSet resultSet, String columnName, Field field) throws SQLException;
}
