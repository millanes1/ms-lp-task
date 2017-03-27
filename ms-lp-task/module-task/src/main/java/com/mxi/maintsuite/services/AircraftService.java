package com.mxi.maintsuite.services;

import com.mxi.maintsuite.errorhandling.AppException;
import com.mxi.maintsuite.persistence.AircraftDAO;
import com.mxi.maintsuite.to.Aircraft;
import lombok.extern.slf4j.Slf4j;

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


    public List<Aircraft> findAll() throws AppException {
        ;
        return aircraftDAO.findAll();

    }

    public Aircraft get(String tail) throws AppException {

        return aircraftDAO.get(tail);
    }


}
