package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.TaskDAO;
import com.mxi.maintsuite.dao.TaskDAOImpl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class FilterService {

    private static TaskDAO taskDAO = new TaskDAOImpl();
    @EJB
    private WorkPackageService workPackageService;

}



