package com.mxi.maintsuite.persistence;

import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.model.Aircraft;
import com.mxi.maintsuite.model.WorkPackage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

@ApplicationScoped
public class AircraftDAO {

    @Inject
    PersistenceHelper helper;

    public Aircraft get(String tail) {

        return helper.getEntityManager().createNamedQuery("Aircraft.getById", Aircraft.class).setParameter("tail", tail).getSingleResult();
    }


    public List<Aircraft> findAll() {
        return helper.getEntityManager().createNamedQuery("Aircraft.findAll", Aircraft.class).getResultList();

    }


}