package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.ToolDAO;
import com.mxi.maintsuite.dao.ToolDAOImpl;
import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Tool;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class ToolService {


    private static ToolDAO toolDAO = new ToolDAOImpl();


    public List<Tool> findAll() throws AppException {
        return toolDAO.findAll();
    }


    public Tool get(final Long id) throws AppException {
        return toolDAO.get(id);
    }


    public List<Tool> findByTask(final Long taskId) throws AppException {
        return toolDAO.findByTask(taskId);
    }

}
