package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "LP_WORK_PACKAGE")
@NamedQueries({
        @NamedQuery(name = "WorkPackage.findAll", query = "SELECT w FROM WorkPackage w"),
        @NamedQuery(name = "WorkPackage.getByBarcode", query = "SELECT w FROM WorkPackage w WHERE upper(w.barcode)=trim(upper(:barcode))")
})
@JsonRootName(value = "WorkPackage")
@ApiModel(value = "WorkPackage", description = "Information associated to a WorkPackage")
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

    public WorkPackage() {

    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "WorkPackage{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
