package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.AircraftDAO;
import com.mxi.maintsuite.dao.AircraftDAOImpl;
import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Aircraft;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class AircraftService {


    private static AircraftDAO aircraftDAO = new AircraftDAOImpl();


    public List<Aircraft> findAll() throws AppException {
        ;
        return aircraftDAO.findAll();

    }

    public Aircraft get(final String tail) throws AppException {

        return aircraftDAO.get(tail);
    }


}
