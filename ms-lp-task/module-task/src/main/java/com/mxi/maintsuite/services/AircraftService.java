package com.mxi.maintsuite.services;

import com.mxi.maintsuite.model.Aircraft;
import com.mxi.maintsuite.model.WorkPackage;
import com.mxi.maintsuite.persistence.AircraftDAO;
import com.mxi.maintsuite.persistence.WorkPackageDAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class AircraftService {

    @Inject
    private AircraftDAO aircraftDAO;


    public List<Aircraft> findAll() {
        ;
        return aircraftDAO.findAll();

    }

    public Aircraft get(String tail) {

        return aircraftDAO.get(tail);
    }


}
