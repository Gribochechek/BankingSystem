package model.dao.extracter.getters;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StringGetter implements Getter<String> {

    @Override
    public String getValueFrom(ResultSet resultSet, String columnName, Field field) throws SQLException {
        return resultSet.getString(columnName);
    }
}
