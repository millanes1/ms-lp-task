package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.TaskDAOImpl;
import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Task;
import com.mxi.maintsuite.dao.TaskDAO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;


/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class TaskService {

    private static TaskDAO taskDAO=new TaskDAOImpl();
    @EJB
    private WorkPackageService workPackageService;
    @EJB
    private ToolService toolService;

    @EJB
    private AircraftService aircraftService;

    @EJB
    private LabourService labourService;
    @EJB
    private PartService partService;

    public List<Task> findAll() throws AppException {

        List<Task> taskList = taskDAO.findAll();
        this.complete(taskList);
        return taskList;

    }

    public List<Task> findByUser(String userMail, Integer offset, Integer limit) throws AppException {

        List<Task> taskList = taskDAO.findByPagination(offset, limit);
        this.complete(taskList);
        return taskList;
    }


    public Task get(final Long id) throws AppException {
        Task task = taskDAO.get(id);
        this.complete(task);
        return task;
    }


    public Task get(final String barcode) throws AppException {

        Task task = taskDAO.get(barcode);


        this.complete(task);
        return task;
    }


    public List<Task> findByAircraft(final String tail) throws AppException {

        List<Task> taskList = taskDAO.findByAircraft(tail);
        this.complete(taskList);
        return taskList;
    }

    public List<Task> findByWorkPackage(final String barcode) throws AppException {

        List<Task> taskList = taskDAO.findByWorkPackage(barcode);
        this.complete(taskList);
        return taskList;
    }


    private void complete(Task task) throws AppException {

        if (task != null) {
            task.setToolList(toolService.findByTask(task.getId()));
            task.setWorkPackage(workPackageService.get(task.getBarcodeWP()));
            task.setAircraft(aircraftService.get(task.getTail()));
            task.setLabourList(labourService.findByTask(task.getId()));
            task.setPartList(partService.findByTask(task.getId()));
        }
    }

    private void complete(List<Task> taskList) throws AppException {
        for (Task item : taskList) {
            this.complete(item);
        }
    }
}



