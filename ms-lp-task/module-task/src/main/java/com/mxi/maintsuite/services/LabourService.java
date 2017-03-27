package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.LabourDAO;
import com.mxi.maintsuite.dao.LabourDAOImpl;
import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Labour;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class LabourService {


    private static LabourDAO labourDAO = new LabourDAOImpl();

    public List<Labour> findAll() throws AppException {
        return labourDAO.findAll();
    }


    public Labour get(final Long id) throws AppException {
        return labourDAO.get(id);
    }


    public List<Labour> findByTask(final Long taskId) throws AppException {
        return labourDAO.findByTask(taskId);
    }

}
