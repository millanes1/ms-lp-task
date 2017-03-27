package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Task;

import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

public interface TaskDAO {


    Task get(final Long id);

    Task get(final String barcode);

    List<Task> findAll();

    List<Task> findByPagination(Integer offset, Integer limit);

    List<Task> findByWorkPackage(final String barcode);

    List<Task> findByAircraft(final String tail);
}