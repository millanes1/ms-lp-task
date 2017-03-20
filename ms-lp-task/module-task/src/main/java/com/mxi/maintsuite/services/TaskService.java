package com.mxi.maintsuite.services;

import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.persistence.TaskDAO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class TaskService {
    @Inject
    private TaskDAO taskDAO;
    @EJB
    private WorkPackageService workPackageService;


    public List<Task> findAll() {
        return taskDAO.findAll();
    }


    public Task get(Integer id) {

        return taskDAO.get(id);

    }


    public List<Task> findByWorkPackage(Integer workPackageId) {
        return taskDAO.findByWorkPackage(workPackageId);


    }


}
