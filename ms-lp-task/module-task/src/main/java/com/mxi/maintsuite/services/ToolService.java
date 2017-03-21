package com.mxi.maintsuite.services;

import com.mxi.maintsuite.model.Tool;
import com.mxi.maintsuite.persistence.ToolDAO;

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


    public List<Tool> findAll() {
        return toolDAO.findAll();
    }


    public Tool get(Integer id) {
        return toolDAO.get(id);
    }


    public List<Tool> findByTask(Integer taskId) {
        return toolDAO.findByTask(taskId);
    }

}
