package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.WorkPackage;

import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */


public interface WorkPackageDAO {


    WorkPackage get(final String barcode);


    List<WorkPackage> findAll();


}