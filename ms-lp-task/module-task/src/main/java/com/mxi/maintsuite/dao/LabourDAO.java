package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Labour;

import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

public interface LabourDAO {

    Labour get(final Long id);

    List<Labour> findAll();

    List<Labour> findByTask(final Long taskId);
}