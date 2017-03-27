package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Tool;

import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */


public interface ToolDAO {


    Tool get(final Long id);


    List<Tool> findAll();

    List<Tool> findByTask(final Long taskId);
}