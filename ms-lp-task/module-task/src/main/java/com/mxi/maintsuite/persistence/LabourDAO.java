package com.mxi.maintsuite.persistence;

import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.to.Labour;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

@ApplicationScoped
public class LabourDAO {

    @Inject
    PersistenceHelper helper;

    public Labour get(Long id) {

        return helper.getEntityManager().createNamedQuery("Labour.getById", Labour.class).setParameter("id", id).getSingleResult();
    }


    public List<Labour> findAll() {
        return helper.getEntityManager().createNamedQuery("Labour.findAll", Labour.class).getResultList();

    }

    public List<Labour> findByTask(Long taskId) {

        return helper.getEntityManager().createNamedQuery("Labour.findByTaskId", Labour.class).setParameter("taskId", taskId).getResultList();
    }
}