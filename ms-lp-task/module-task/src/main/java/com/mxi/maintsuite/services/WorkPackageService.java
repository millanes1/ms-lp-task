package com.mxi.maintsuite.services;

import com.mxi.maintsuite.errorhandling.AppException;
import com.mxi.maintsuite.model.WorkPackage;
import com.mxi.maintsuite.persistence.WorkPackageDAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class WorkPackageService {

    @Inject
    private WorkPackageDAO workPackageDAO;


    public List<WorkPackage> findAll() throws AppException {
        return workPackageDAO.findAll();
    }


    public WorkPackage get(String barcode) throws AppException {

        return workPackageDAO.get(barcode);
    }


}
