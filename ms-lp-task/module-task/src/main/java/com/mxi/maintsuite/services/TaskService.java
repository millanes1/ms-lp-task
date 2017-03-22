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

    public List<Task> findAll() throws NotFoundException {
        List<Task> taskList = taskDAO.findAll();
        //this.complete(taskList);

        return taskList;
    }


    public Task get(Long id) throws NotFoundException {
        Task task = taskDAO.get(id);
        // if (task != null && task.getWorkPackageId() != null) {
        //   task.setToolList(toolService.findByTask(task.getId()));
        // task.setWorkPackage(workPackageService.get(task.getWorkPackageId()));
        //}
        return taskDAO.get(id);


    }


    public Task get(String barcode) throws NotFoundException {

        return taskDAO.get(barcode);
    }


    public List<Task> findByAircraft(String tail) throws NotFoundException {

        return taskDAO.findByAircraft(tail);


    }

    public List<Task> findByWorkPackage(String barcode) throws NotFoundException {
        List<Task> taskList = taskDAO.findByWorkPackage(barcode);
        //  this.complete(taskList);

        return taskList;


    }

  /*  private void complete(List<Task> taskList) throws NotFoundException {
        for (Task item : taskList) {
            item.setToolList(toolService.findByTask(item.getId()));
            ;
           /* if (item != null && item.getWorkPackageId() != null) {
                item.setWorkPackage(workPackageService.get(item.getWorkPackageId()));
            }*/
    // }
}



