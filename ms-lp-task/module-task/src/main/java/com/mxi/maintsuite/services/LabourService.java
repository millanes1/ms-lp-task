package com.mxi.maintsuite.services;

import com.mxi.maintsuite.errorhandling.AppException;
import com.mxi.maintsuite.to.Labour;
import com.mxi.maintsuite.persistence.LabourDAO;
import lombok.extern.slf4j.Slf4j;

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


    public List<Labour> findAll() throws AppException {
        return labourDAO.findAll();
    }


    public Labour get(Long id) throws AppException {
        return labourDAO.get(id);
    }


    public List<Labour> findByTask(Long taskId) throws AppException {
        return labourDAO.findByTask(taskId);
    }

}
