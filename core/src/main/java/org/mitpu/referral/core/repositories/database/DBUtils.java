package org.mitpu.referral.core.repositories.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.services.exception.ApplicationException;
import org.mitpu.referral.core.services.exception.ConflictException;
import org.mitpu.referral.core.services.exception.ParentNotFoundException;
import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBUtils {

    private static final Logger LOGGER = LogManager.getLogger(DBUtils.class);

    public static PreparedStatement createPsWithKey(Connection conn, String query, Object[] parameters)
            throws SQLException {
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        setParameters(ps, parameters, query);
        return ps;
    }

    public static PreparedStatement createPs(Connection conn, String query, Object[] parameters) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(query);
        setParameters(ps, parameters, query);
        return ps;
    }

    private static void setParameters(PreparedStatement ps, Object[] parameters, String query) throws SQLException {
        int parameterIndex = 1;
        String formattedQuery = query;
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
                formattedQuery.replaceFirst("\\?", o.toString());
                parameterIndex++;
            }
        }
        LOGGER.debug("SQL: {}", formattedQuery);
    }

    public static void catchException(DataAccessException dae) {
        LOGGER.debug("Database exceptions is occurred.", dae);
        for (DBConstraint dbConstraint : DBConstants.CONSTANTS_LIST) {
            Matcher matcher = Pattern.compile(dbConstraint.getRegexPattern()).matcher(dae.getMessage());
            if (matcher.matches()) {
                Class exceptionClass = dbConstraint.getExceptionClass();
                String model = dbConstraint.getConstraintModelMap().get(matcher.group(dbConstraint.getRegexGroup()));
                // Avoid using reflect API's new instance
                if (exceptionClass.getName().equals(ParentNotFoundException.class.getName())) {
                    if (model == null) {
                        throw new ParentNotFoundException();
                    } else {
                        throw new ParentNotFoundException(model);
                    }
                } else if (exceptionClass.getName().equals(ConflictException.class.getName())) {
                    if (model == null) {
                        throw new ConflictException();
                    } else {
                        throw new ConflictException(model);
                    }
                } else {
                    throw new ApplicationException();
                }
            }
        }
    }
}
