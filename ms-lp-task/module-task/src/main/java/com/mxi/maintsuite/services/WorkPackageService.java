package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.WorkPackageDAO;
import com.mxi.maintsuite.dao.WorkPackageDAOImpl;
import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.WorkPackage;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class WorkPackageService {


    private WorkPackageDAO workPackageDAO = new WorkPackageDAOImpl();


    public List<WorkPackage> findAll() throws AppException {
        return workPackageDAO.findAll();
    }


    public WorkPackage get(final String barcode) throws AppException {

        return workPackageDAO.get(barcode);
    }


}
