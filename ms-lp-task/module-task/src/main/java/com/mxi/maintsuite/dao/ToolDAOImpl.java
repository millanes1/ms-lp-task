package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Tool;
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
public class ToolDAOImpl implements ToolDAO {

    private static final String SQL = "SELECT LPTL_CODE, LPTK_CODE, LPTL_CODE_MXI,LPTL_NAME, LPTL_QUANTITY FROM LP_TOOL ";

    @Override
    public Tool get(final Long id) {
        final String query = SQL + "WHERE LPTL_CODE = '" + id + "'";
        final List<Tool> tools = this.execute(query);
        return tools != null && !tools.isEmpty() ? tools.get(0) : new Tool();
    }

    @Override
    public List<Tool> findAll() {
        return this.execute(SQL);

    }

    @Override
    public List<Tool> findByTask(Long taskId) {
        final String query = SQL + "WHERE LPTK_CODE = '" + taskId + "'";
        return this.execute(query);
    }


    private List<Tool> execute(String query) {

        Connection connection = DatabaseUtil.getConnection();
        List<Tool> tools = new ArrayList<Tool>();
        try {


            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Tool tool = new Tool();
                tool.setId(rs.getLong(1));
                tool.setTaskId(rs.getLong(2));
                tool.setCodeMxi(rs.getInt(3));
                tool.setName(rs.getString(4));
                tool.setQuantity(rs.getDouble(5));
                tools.add(tool);
            }

        } catch (SQLException e) {
            log.error(e.getMessage(), e);

        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        return tools;
    }

}