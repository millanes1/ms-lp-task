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


@Entity
@Table(name = "LINE_PLANNING.LP_WORK_PACKAGE")
@NamedQueries({
        @NamedQuery(name = "WorkPackage.findAll", query = "SELECT w FROM WorkPackage w"),
        @NamedQuery(name = "WorkPackage.getByBarcode", query = "SELECT w FROM WorkPackage w WHERE upper(w.barcode)=trim(upper(:barcode))")
})
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
    @Column(name = "LPWP_BARCODE")
    @NotNull
    @ApiModelProperty(value = "Visual identifier of a Work Package", required = true)
    private String barcode;

    @Column(name = "LPWP_NAME")
    @NotNull
    @ApiModelProperty(value = "Name of a Work Package", required = true)
    private String name;


    @Column(name = "LPWP_STATUS")
    @NotNull
    @ApiModelProperty(value = "Status of Work Package from MXI", required = true)
    private String status;


    @Column(name = "LPWP_LOCATION")
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
