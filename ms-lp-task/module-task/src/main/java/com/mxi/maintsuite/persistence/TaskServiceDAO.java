package com.mxi.maintsuite.persistence;

import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.model.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

@ApplicationScoped
public class TaskServiceDAO {

    @Inject
    PersistenceHelper helper;

    public Task get(Integer id) {

        return null;
    }


    public List<Task> findAll() {
        final List<Task> taskList = helper.getEntityManager().createNamedQuery("Task.findAll", Task.class).getResultList();
        return taskList;
    }


}
