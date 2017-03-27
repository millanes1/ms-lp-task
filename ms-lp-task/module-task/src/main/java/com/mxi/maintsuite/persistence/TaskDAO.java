package com.mxi.maintsuite.persistence;

import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.to.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

@ApplicationScoped
public class TaskDAO {

    @Inject
    PersistenceHelper helper;

    public Task get(Long id) {

        return helper.getEntityManager().createNamedQuery("Task.getById", Task.class).setParameter("id", id).getSingleResult();
    }

    public Task get(String barcode) {

        return helper.getEntityManager().createNamedQuery("Task.getByBarcode", Task.class).setParameter("barcode", barcode).getSingleResult();
    }

    public List<Task> findAll() {

        final List<Task> taskList = helper.getEntityManager().createNamedQuery("Task.findAll", Task.class).getResultList();
        return taskList;
    }

    public List<Task> findByPagination(Integer offset, Integer limit) {

        offset = (offset != null && offset > 0) ? offset - 1 : offset;
        final List<Task> taskList = helper.getEntityManager().createNamedQuery("Task.findAll", Task.class).setFirstResult(offset).setMaxResults(limit).getResultList();

        return taskList;
    }

    public List<Task> findByWorkPackage(String barcode) {

        return helper.getEntityManager().createNamedQuery("Task.findByWorkPackage", Task.class).setParameter("barcode", barcode).getResultList();
    }

    public List<Task> findByAircraft(String tail) {

        return helper.getEntityManager().createNamedQuery("Task.findByAircraft", Task.class).setParameter("tail", tail).getResultList();
    }
}
