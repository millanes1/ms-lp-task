package com.mxi.maintsuite.services;

import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.model.WorkPackage;
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
        List<Task> taskList = taskDAO.findAll();
        this.complete(taskList);

        return taskList;
    }


    public Task get(Integer id) {
        Task task = taskDAO.get(id);
        if (task != null && task.getWorkPackageId() != null) {
            task.setWorkPackage(workPackageService.get(task.getWorkPackageId()));
        }
        return taskDAO.get(id);


    }


    public List<Task> findByWorkPackage(Integer workPackageId) {
        List<Task> taskList = taskDAO.findByWorkPackage(workPackageId);
        this.complete(taskList);

        return taskList;


    }

    private void complete(List<Task> taskList) {
        for (Task item : taskList) {
            if (item != null && item.getWorkPackageId() != null) {
                item.setWorkPackage(workPackageService.get(item.getWorkPackageId()));
            }
        }
    }
}

