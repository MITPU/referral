package org.mitpu.referral.core.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    public static PreparedStatement createPsWithKey(Connection conn, String query, Object[] parameters)
            throws SQLException {
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        setParameters(ps, parameters);
        return ps;
    }

    public static PreparedStatement createPs(Connection conn, String query, Object[] parameters) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(query);
        setParameters(ps, parameters);
        return ps;
    }

    private static void setParameters(PreparedStatement ps, Object[] parameters) throws SQLException {
        int parameterIndex = 1;
        if (parameters != null) {
            for (Object o : parameters) {
                if (o instanceof String) {
                    ps.setString(parameterIndex, (String) o);
                } else if (o instanceof Integer) {
                    ps.setInt(parameterIndex, (Integer) o);
                } else if (o instanceof Byte) {
                    ps.setByte(parameterIndex, (Byte) o);
                } else {
                    ps.setObject(parameterIndex, o);
                }
                parameterIndex++;
            }
        }
    }
}
