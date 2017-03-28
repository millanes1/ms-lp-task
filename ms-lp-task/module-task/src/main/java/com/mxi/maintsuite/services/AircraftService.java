package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.AircraftDAO;
import com.mxi.maintsuite.dao.AircraftDAOImpl;
import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Aircraft;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.mxi.maintsuite.rest.filter.AppConstants.BLOG_POST_URL;
import static com.mxi.maintsuite.rest.filter.AppConstants.MESSAGE_404;

/**
 * Created by millanes on 20-03-17.
 */
@Stateless
@LocalBean
public class AircraftService {


    private static AircraftDAO aircraftDAO = new AircraftDAOImpl();


    public List<Aircraft> findAll() throws AppException {

        return aircraftDAO.findAll();

    }

    public Aircraft get(final String tail) throws AppException {

        return aircraftDAO.get(tail);

    }

    public List<Aircraft> filter(Aircraft filter) throws AppException {
       return  aircraftDAO.filter(filter);
    }
}
