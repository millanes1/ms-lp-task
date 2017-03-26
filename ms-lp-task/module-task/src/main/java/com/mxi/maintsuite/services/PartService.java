package com.mxi.maintsuite.services;

import com.mxi.maintsuite.errorhandling.AppException;
import com.mxi.maintsuite.model.Part;
import com.mxi.maintsuite.persistence.PartDAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class PartService {

    @Inject
    private PartDAO partDAO;


    public List<Part> findAll() throws AppException {
        return partDAO.findAll();
    }


    public Part get(Long id) throws AppException {
        return partDAO.get(id);
    }

    public List<Part> findByTask(Long taskId) throws AppException {
        return partDAO.findByTask(taskId);
    }

}
