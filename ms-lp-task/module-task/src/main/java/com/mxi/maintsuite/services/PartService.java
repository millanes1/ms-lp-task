package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.PartDAO;
import com.mxi.maintsuite.dao.PartDAOImpl;
import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Part;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class PartService {

    private static PartDAO partDAO = new PartDAOImpl();


    public List<Part> findAll() throws AppException {
        return partDAO.findAll();
    }


    public Part get(final Long id) throws AppException {
        return partDAO.get(id);
    }

    public List<Part> findByTask(final Long taskId) throws AppException {
        return partDAO.findByTask(taskId);
    }

}
