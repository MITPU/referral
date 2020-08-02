package org.mitpu.referral.core.repositories.database;

import org.mitpu.referral.core.services.exception.ConflictException;
import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBUtils {

    private static final String DUPLICATE_KEY_REGEX = "^(.+)Duplicate entry\\s(.+)\\sfor key\\s'(.+)';(.+)$";

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

    public static void throwConflictException(DataAccessException dae) throws ConflictException {
        // TODO fix throwing conflict exception for all DB exceptions.
        Matcher matcher = Pattern.compile(DUPLICATE_KEY_REGEX).matcher(dae.getMessage());
        if (matcher.matches()) {
            String uniqueColumn = DBConstants.UNIQUE_CONSTRAINTS.get(matcher.group(3));
            if (uniqueColumn != null) {
                throw new ConflictException(uniqueColumn);
            } else {
                throw new ConflictException();
            }
        }
    }
}
