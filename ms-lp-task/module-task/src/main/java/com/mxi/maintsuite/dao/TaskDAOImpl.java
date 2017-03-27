package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Task;
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
public class TaskDAOImpl implements TaskDAO {
    private static final String SQL = "SELECT LPTK_CODE, LPTK_BARCODE, LPTK_CODE_MXI, LPAC_AC_REG_CD, LPWP_BARCODE, LPTK_NAME,LPTK_STATUS, LPTK_TASK_TYPE, LPTK_DUE_DATE, LPTK_DUE_DATE_EXT, LPTK_DUE_DATE_FNL, LPTK_YIELD, LPTK_DURATION, LPTK_PRIORITY, LPTK_SCHED_STATUS  FROM LP_TASK  ";


    @Override
    public Task get(final Long id) {

        final String query = SQL + "WHERE LPTK_CODE = '" + id + "'";
        final List<Task> tasks = this.execute(query);
        return tasks != null && !tasks.isEmpty() ? tasks.get(0) : new Task();
    }

    @Override
    public Task get(final String barcode) {

        final String query = SQL + "WHERE upper(LPTK_BARCODE) = upper(trim('" + barcode + "'))";
        final List<Task> tasks = this.execute(query);
        return tasks != null && !tasks.isEmpty() ? tasks.get(0) : new Task();
    }

    @Override
    public List<Task> findAll() {

        return this.execute(SQL);
    }

    @Override
    public List<Task> findByPagination(Integer offset, Integer limit) {

        offset = (offset != null && offset > 0) ? offset - 1 : offset;


        final String query = SQL + "ORDER BY LPTK_CODE ASC  LIMIT '" + limit + "' OFFSET '" + offset + "'";
        return this.execute(query);
    }

    @Override
    public List<Task> findByWorkPackage(final String barcode) {

        final String query = SQL + "WHERE upper(LPWP_BARCODE) = upper(trim('" + barcode + "'))";
        return this.execute(query);
    }

    @Override
    public List<Task> findByAircraft(final String tail) {
        final String query = SQL + "WHERE upper(LPAC_AC_REG_CD) = upper(trim('" + tail + "'))";
        return this.execute(query);
    }


    private List<Task> execute(String query) {

        Connection connection = DatabaseUtil.getConnection();
        List<Task> tasks = new ArrayList<Task>();
        try {


            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getLong(1));
                task.setBarcode(rs.getString(2));
                task.setCodeMxi(rs.getInt(3));
                task.setTail(rs.getString(4));
                task.setBarcodeWP(rs.getString(5));
                task.setName(rs.getString(6));
                task.setStatus(rs.getString(7));
                task.setType(rs.getString(8));

                task.setDueDate(rs.getTimestamp(9));
                task.setDueDateExtended(rs.getTimestamp(10));
                task.setDueDateLimit(rs.getTimestamp(11));
                task.setYield(rs.getDouble(12));
                task.setDuration(rs.getDouble(13));
                task.setPriority(rs.getInt(14));
                task.setScheduleStatus(rs.getString(15));


                tasks.add(task);
            }

        } catch (SQLException e) {
            log.error(e.getMessage(), e);

        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        return tasks;
    }

}
