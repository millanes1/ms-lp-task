package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Labour;
import com.mxi.maintsuite.util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LabourDAOImpl implements LabourDAO {

    private static final String SQL = "SELECT LPLB_CODE, LPTK_CODE, LPLB_SKILL, LPLB_MAN_REQUIRED, LPLB_MAN_HR  FROM LP_LABOUR ";

    @Override
    public Labour get(final Long id) {
        final String query = SQL + "WHERE LPLB_CODE = '" + id + "'";
        final List<Labour> labours = this.execute(query);
        return labours != null && !labours.isEmpty() ? labours.get(0) : new Labour();

    }

    @Override
    public List<Labour> findAll() {
        return this.execute(SQL);
    }

    @Override
    public List<Labour> findByTask(final Long taskId) {
        final String query = SQL + "WHERE LPTK_CODE = '" + taskId + "'";
        return this.execute(query);

    }

    private List<Labour> execute(String query) {

        Connection connection = DatabaseUtil.getConnection();
        List<Labour> labours = new ArrayList<Labour>();
        try {


            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Labour labour = new Labour();
                labour.setId(rs.getLong(1));
                labour.setTaskId(rs.getLong(2));

                labour.setSkill(rs.getString(3));
                labour.setManRequired(rs.getInt(4));
                labour.setManHrs(rs.getDouble(5));
                labours.add(labour);
            }

        } catch (SQLException e) {
            log.error(e.getMessage(), e);

        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        return labours;
    }

}
