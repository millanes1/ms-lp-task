package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Aircraft;
import com.mxi.maintsuite.to.Labour;

import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

public interface AircraftDAO {

    Aircraft get(final String tail);

    List<Aircraft> findAll();

    List<Aircraft> filter(final Aircraft filter);
}