package com.mxi.maintsuite.services;

import com.mxi.maintsuite.exception.NotFoundException;
import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.persistence.TaskDAO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
    @EJB
    private ToolService toolService;

    @EJB
    AircraftService aircraftService;

    public List<Task> findAll() throws NotFoundException {

        List<Task> taskList = taskDAO.findAll();
        this.complete(taskList);
        return taskList;
    }


    public Task get(Long id) throws NotFoundException {
        Task task = taskDAO.get(id);
        this.complete(task);
        return task;
    }


    public Task get(String barcode) throws NotFoundException {

        Task task = taskDAO.get(barcode);
        this.complete(task);
        return task;
    }


    public List<Task> findByAircraft(String tail) throws NotFoundException {

        List<Task> taskList = taskDAO.findByAircraft(tail);
        this.complete(taskList);
        return taskList;
    }

    public List<Task> findByWorkPackage(String barcode) throws NotFoundException {

        List<Task> taskList = taskDAO.findByWorkPackage(barcode);
        this.complete(taskList);
        return taskList;
    }

    private void complete(Task task) throws NotFoundException {

        if (task != null && task.getBarcodeWP() != null) {
            task.setToolList(toolService.findByTask(task.getId()));
            task.setWorkPackage(workPackageService.get(task.getBarcodeWP()));
            task.setAircraft(aircraftService.get(task.getTail()));
        }
    }

    private void complete(List<Task> taskList) throws NotFoundException {
        for (Task item : taskList) {
            this.complete(item);
        }
    }
}



