package com.mxi.maintsuite.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


@JsonRootName(value = "WorkPackage")
@ApiModel(value = "WorkPackage", description = "Information associated to a WorkPackage")
@Getter
@Setter
@ToString
@XmlRootElement
public class WorkPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "Visual identifier of a Work Package", required = true)
    private String barcode;


    @NotNull
    @ApiModelProperty(value = "Name of a Work Package", required = true)
    private String name;


    @NotNull
    @ApiModelProperty(value = "Status of Work Package from MXI", required = true)
    private String status;


    @NotNull
    @ApiModelProperty(value = "Location where it programming work package for you execution")
    private String location;


    @JsonFormat(
            pattern = "dd-MMM-yyyy hh:mm")
    @ApiModelProperty(value = "Date and time off works start")
    private Date beginDate;

    @JsonFormat(
            pattern = "dd-MMM-yyyy hh:mm")
    @ApiModelProperty(value = "Date and time off works finish")
    private Date endDate;


}
