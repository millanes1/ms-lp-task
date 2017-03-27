package com.mxi.maintsuite.services;

import com.mxi.maintsuite.dao.AircraftDAO;
import com.mxi.maintsuite.dao.AircraftDAOImpl;
import com.mxi.maintsuite.rest.errorhandling.AppException;
import com.mxi.maintsuite.to.Aircraft;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
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

        List<Aircraft> aircrafts = aircraftDAO.findAll();

        if (aircrafts == null || (aircrafts != null && aircrafts.isEmpty())) {

            throw new AppException(Response.Status.NOT_FOUND.getStatusCode(), 404, MESSAGE_404,
                    null, BLOG_POST_URL);
        }

        return aircrafts;

    }

    public Aircraft get(final String tail) throws AppException {

        Aircraft aircraft = aircraftDAO.get(tail);

        if (aircraft == null || (aircraft != null && StringUtils.isNotEmpty(aircraft.getTail()))) {
            throw new AppException(Response.Status.NOT_FOUND.getStatusCode(), 404, MESSAGE_404,
                    null, BLOG_POST_URL);
        }

        return aircraft;
    }


}
