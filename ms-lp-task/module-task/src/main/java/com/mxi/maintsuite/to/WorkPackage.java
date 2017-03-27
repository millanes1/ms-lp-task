package com.mxi.maintsuite.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
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
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "LPWP_DATE_TIME_START")
    @ApiModelProperty(value = "Date and time off works start")
    private Date beginDate;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "LPWP_DATE_TIME_END")
    @ApiModelProperty(value = "Date and time off works finish")
    private Date endDate;


}
