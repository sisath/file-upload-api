package com.example.fileupload.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/*
* In Java, type handlers are classes/interfaces that define how a particular
* data type should be converted or mapped between different formats or
* representations. They are usually used where data needs to be stored in a
* database.
*
* TypeHandlers typically consist of two main parts, a Java class that
* represents the data type being converted, and a set of methods that
* handle the conversion to and from the target format.
*
* TypeHandlers are often used with object relational mapping (ORM) frameworks
* such as Hibernate or MyBatis, which provide a convenient way to map Java
* objects to database tables. These frameworks use type handlers to handle the
* conversion of Java objects to database types and vice versa.
* */
@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(UUID.class)
public class UUIDTypeHandler extends BaseTypeHandler<UUID> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    UUID parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter, jdbcType.TYPE_CODE);
    }

    @Override
    public UUID getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return (UUID)rs.getObject(columnName);
    }

    @Override
    public UUID getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return (UUID)rs.getObject(columnIndex);
    }

    @Override
    public UUID getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return (UUID)cs.getObject(columnIndex);
    }
}
