package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.WorkPackage;
import com.mxi.maintsuite.util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;

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
public class WorkPackageDAOImpl implements WorkPackageDAO {

    private static final String SQL = "SELECT LPWP_BARCODE, LPWP_NAME, LPWP_STATUS,LPWP_LOCATION, LPWP_DATE_TIME_START, LPWP_DATE_TIME_END FROM LP_WORK_PACKAGE ";

    public WorkPackage get(final String barcode) {
        final String query = SQL + "WHERE upper(LPWP_BARCODE) = upper(trim('" + barcode + "'))";
        final List<WorkPackage> workPackages = this.execute(query);
        return workPackages != null && !workPackages.isEmpty() ? workPackages.get(0) : new WorkPackage();
    }

    public List<WorkPackage> findAll() {
        return this.execute(SQL);
    }

    private List<WorkPackage> execute(String query) {

        Connection connection = DatabaseUtil.getConnection();
        List<WorkPackage> workPackages = new ArrayList<WorkPackage>();
        try {


            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                WorkPackage workPackage = new WorkPackage();
                workPackage.setBarcode(rs.getString(1));
                workPackage.setName(rs.getString(2));
                workPackage.setStatus(rs.getString(3));
                workPackage.setLocation(rs.getString(4));
                workPackage.setBeginDate(rs.getTimestamp(5));
                workPackage.setEndDate(rs.getTimestamp(6));

                workPackages.add(workPackage);
            }

        } catch (SQLException e) {
            log.error(e.getMessage(), e);

        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        return workPackages;
    }
}