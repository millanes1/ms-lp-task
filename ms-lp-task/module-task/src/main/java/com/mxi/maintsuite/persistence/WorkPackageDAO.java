package com.mxi.maintsuite.persistence;

import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.model.Tool;
import com.mxi.maintsuite.model.WorkPackage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

@ApplicationScoped
public class WorkPackageDAO {

    @Inject
    PersistenceHelper helper;

    public WorkPackage get(Integer id) {

        return helper.getEntityManager().createNamedQuery("WorkPackage.getById", WorkPackage.class).setParameter("id", id).getSingleResult();
    }


    public List<WorkPackage> findAll() {
        return helper.getEntityManager().createNamedQuery("WorkPackage.findAll", WorkPackage.class).getResultList();

    }


}