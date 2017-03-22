package com.mxi.maintsuite.persistence;

import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.model.Part;
import com.mxi.maintsuite.model.Tool;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

@ApplicationScoped
public class PartDAO {

    @Inject
    PersistenceHelper helper;

    public Part get(Long id) {

        return helper.getEntityManager().createNamedQuery("Part.getById", Part.class).setParameter("id", id).getSingleResult();
    }


    public List<Part> findAll() {
        return helper.getEntityManager().createNamedQuery("Part.findAll", Part.class).getResultList();

    }

    public List<Part> findByTask(Long taskId) {

        return helper.getEntityManager().createNamedQuery("Part.findByTaskId", Part.class).setParameter("taskId", taskId).getResultList();
    }
}