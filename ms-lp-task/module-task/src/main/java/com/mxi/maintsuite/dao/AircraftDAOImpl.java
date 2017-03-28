package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Aircraft;
import com.mxi.maintsuite.util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

@Slf4j
public class AircraftDAOImpl implements AircraftDAO {

    private static final String SQL = "SELECT LPAC_AC_REG_CD, LPAC_ASSMBL_CD, LPAC_AUTHORITY_CD FROM LP_AIRCRAFT ";

    @Override
    public Aircraft get(final String tail) {
        final String query = SQL + "WHERE upper(LPAC_AC_REG_CD) = upper(trim('" + tail + "'))";
        final List<Aircraft> aircrafts = this.execute(query);
        return aircrafts != null && !aircrafts.isEmpty() ? aircrafts.get(0) : new Aircraft();
    }

    @Override
    public List<Aircraft> findAll() {
        return this.execute(SQL);
    }

    @Override
    public List<Aircraft> filter(Aircraft filter) {
        final StringBuffer query = new StringBuffer();
        query.append(SQL);
        query.append(" WHERE 1= 1");
        query.append(StringUtils.isNotEmpty(filter.getTail()) ? " AND upper(trim(LPAC_AC_REG_CD))='" + filter.getTail().toUpperCase().trim() + "'" : "");
        query.append(StringUtils.isNotEmpty(filter.getFleet()) ? " AND upper(trim(LPAC_ASSMBL_CD))='" + filter.getFleet().toUpperCase().trim() + "'" : "");
        query.append(StringUtils.isNotEmpty(filter.getAuthority()) ? " AND upper(trim(LPAC_AUTHORITY_CD))='" + filter.getAuthority().toUpperCase().trim() + "'" : "");
        return this.execute(query.toString());

    }


    private List<Aircraft> execute(String query) {

        Connection connection = DatabaseUtil.getConnection();
        List<Aircraft> aircrafts = new ArrayList<Aircraft>();
        try {


            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Aircraft aircraft = new Aircraft();
                aircraft.setTail(rs.getString(1));
                aircraft.setFleet(rs.getString(2));
                aircraft.setAuthority(rs.getString(3));
                //  aircraft.setOperator(rs.getString(4));

                aircrafts.add(aircraft);
            }

        } catch (SQLException e) {
            log.error(e.getMessage(), e);

        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        return aircrafts;
    }
}