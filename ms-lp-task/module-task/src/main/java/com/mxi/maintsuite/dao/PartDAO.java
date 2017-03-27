package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Part;

import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */


public interface PartDAO {


    Part get(final Long id);


    List<Part> findAll();

    List<Part> findByTask(final Long taskId);
}