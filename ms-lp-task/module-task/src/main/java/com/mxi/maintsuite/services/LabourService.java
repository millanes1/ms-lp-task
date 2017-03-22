package com.mxi.maintsuite.services;

import com.mxi.maintsuite.model.Labour;
import com.mxi.maintsuite.model.Tool;
import com.mxi.maintsuite.persistence.LabourDAO;
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
public class LabourService {

    @Inject
    private LabourDAO labourDAO;


    public List<Labour> findAll() {
        return labourDAO.findAll();
    }


    public Labour get(Long id) {
        return labourDAO.get(id);
    }


    public List<Labour> findByTask(Long taskId) {
        return labourDAO.findByTask(taskId);
    }

}
