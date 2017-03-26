package com.mxi.maintsuite.services;

import com.mxi.maintsuite.errorhandling.AppException;
import com.mxi.maintsuite.exception.NotFoundException;
import com.mxi.maintsuite.filter.AppConstants;
import com.mxi.maintsuite.model.Labour;
import com.mxi.maintsuite.model.Pagination;
import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.persistence.TaskDAO;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
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

        System.out.println("Pagination out :" + offset + " / " + limit);

        List<Task> taskList = taskDAO.findByPagination(offset, limit);
        this.complete(taskList);
        return taskList;
    }


    public Task get(Long id) throws AppException {
        Task task = taskDAO.get(id);
        this.complete(task);
        return task;
    }


    public Task get(String barcode) throws AppException {

        Task task = taskDAO.get(barcode);

        if (task != null && StringUtils.isNotEmpty(task.getBarcode())) {
            throw new AppException(Response.Status.NOT_FOUND.getStatusCode(),
                    404,
                    "The podcast you requested with id " + barcode + " was not found in the database",
                    "Verify the existence of the podcast with the id " + barcode + " in the database",
                    AppConstants.BLOG_POST_URL);
        }


        this.complete(task);
        return task;
    }


    public List<Task> findByAircraft(String tail) throws AppException {

        List<Task> taskList = taskDAO.findByAircraft(tail);
        this.complete(taskList);
        return taskList;
    }

    public List<Task> findByWorkPackage(String barcode) throws AppException {

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



