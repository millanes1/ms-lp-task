package com.mxi.maintsuite.services;

import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Tool;
import com.mxi.maintsuite.dao.ToolDAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class ToolService {

    @Inject
    private ToolDAO toolDAO;


    public List<Tool> findAll() throws AppException {
        return toolDAO.findAll();
    }


    public Tool get(Long id) throws AppException {
        return toolDAO.get(id);
    }


    public List<Tool> findByTask(Long taskId) throws AppException {
        return toolDAO.findByTask(taskId);
    }

}
