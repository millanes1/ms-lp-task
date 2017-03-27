package com.mxi.maintsuite.persistence;

import com.mxi.maintsuite.PersistenceHelper;
import com.mxi.maintsuite.to.WorkPackage;

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

    public WorkPackage get(String barcode) {

        return helper.getEntityManager().createNamedQuery("WorkPackage.getByBarcode", WorkPackage.class).setParameter("barcode",barcode).getSingleResult();
    }


    public List<WorkPackage> findAll() {
        return helper.getEntityManager().createNamedQuery("WorkPackage.findAll", WorkPackage.class).getResultList();

    }


}