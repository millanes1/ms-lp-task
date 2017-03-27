package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Part;
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
public class PartDAOImpl implements PartDAO {

    private static final String SQL = "SELECT LPPT_CODE, LPTK_CODE, LPPT_CODE_MXI, LPPT_CODE_MXI_GROUP, LPPT_STATUS, LPPT_QUANTITY,LPPT_DATE_ETA, LPPT_NAME FROM LP_PART ";


    @Override
    public Part get(final Long id) {
        final String query = SQL + "WHERE LPPT_CODE = '" + id + "'";
        final List<Part> parts = this.execute(query);
        return parts != null && !parts.isEmpty() ? parts.get(0) : new Part();

    }

    @Override
    public List<Part> findAll() {
        return this.execute(SQL);
    }

    @Override
    public List<Part> findByTask(final Long taskId) {
        final String query = SQL + "WHERE LPTK_CODE = '" + taskId + "'";
        return this.execute(query);

    }

    private List<Part> execute(String query) {

        Connection connection = DatabaseUtil.getConnection();
        List<Part> parts = new ArrayList<Part>();
        try {


            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Part part = new Part();
                part.setId(rs.getLong(1));
                part.setTaskId(rs.getLong(2));
                part.setCodeMxi(rs.getInt(3));
                part.setCodeGroupMxi(rs.getInt(4));
                part.setStatus(rs.getString(5));
                part.setQuantity(rs.getDouble(6));
                part.setEstimatedArrival(rs.getTimestamp(7));
                part.setName(rs.getString(8));

                parts.add(part);
            }

        } catch (SQLException e) {
            log.error(e.getMessage(), e);

        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        return parts;
    }


}