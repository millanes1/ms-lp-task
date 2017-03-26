package com.mxi.maintsuite.model;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.QueryParam;

/**
 * Created by millanes on 20-03-17.
 */
@Getter
@Setter
@ToString
public class Pagination {


    @QueryParam("page")
    @ApiParam("number of records to page")
    private Integer skip;

    @QueryParam("limit")
    @ApiParam("maximum number of records to return")
    private Integer limit;

}
