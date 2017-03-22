package com.mxi.maintsuite.persistence;

import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.model.Task;
import com.mxi.maintsuite.model.Tool;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

@ApplicationScoped
public class ToolDAO {

    @Inject
    PersistenceHelper helper;

    public Tool get(Long id) {

        return helper.getEntityManager().createNamedQuery("Tool.getById", Tool.class).setParameter("id", id).getSingleResult();
    }


    public List<Tool> findAll() {
        return helper.getEntityManager().createNamedQuery("Tool.findAll", Tool.class).getResultList();

    }

    public List<Tool> findByTask(Long taskId) {

        return helper.getEntityManager().createNamedQuery("Tool.findByTaskId", Tool.class).setParameter("taskId", taskId).getResultList();
    }
}