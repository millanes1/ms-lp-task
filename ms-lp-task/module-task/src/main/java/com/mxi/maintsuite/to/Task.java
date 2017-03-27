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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "LINE_PLANNING.LP_TASK")
@NamedQueries({@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t ORDER BY t.id asc "),
        @NamedQuery(name = "Task.getById", query = "SELECT t FROM Task t WHERE t.id=:id"),
        @NamedQuery(name = "Task.getByBarcode", query = "SELECT t FROM Task t WHERE upper(t.barcode)=upper(trim(:barcode))"),
        @NamedQuery(name = "Task.findByAircraft", query = "SELECT t FROM Task t WHERE upper(t.tail)=upper(trim(:tail))"),
        @NamedQuery(name = "Task.findByWorkPackage", query = "SELECT t FROM Task t WHERE upper(t.barcodeWP)=upper(trim(:barcode))")

})
@JsonRootName(value = "Task")
@ApiModel(value = "Task", description = "Information associated to a Task")
@Getter
@Setter
@ToString
@XmlRootElement
public class Task implements Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "LPTK_CODE")
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    private Long id;


    @NotNull
    @Column(name = "LPTK_BARCODE")
    @ApiModelProperty(value = "Visual identifier of a task", required = true)
    private String barcode;


    @NotNull
    @ApiModelProperty(value = "Code of identifier of a task in MXI", required = true)
    @Column(name = "LPTK_CODE_MXI")
    private Integer codeMxi;

    @NotNull
    @ApiModelProperty(value = "Registration code of an aircraft", required = true)
    @Column(name = "LPAC_AC_REG_CD")
    private String tail;

    @NotNull
    @ApiModelProperty(value = "Visual identifier of a Work Package")
    @Column(name = "LPWP_BARCODE")
    private String barcodeWP;


    @NotNull
    @ApiModelProperty(value = "Name of a task", required = true)
    @Column(name = "LPTK_NAME")
    private String name;


    @NotNull
    @ApiModelProperty(value = "Status of task from MXI", required = true)
    @Column(name = "LPTK_STATUS")
    private String status;


    @NotNull
    @ApiModelProperty(value = "Classification the type of Task", required = true)
    @Column(name = "LPTK_TASK_TYPE")
    private String type;


    @NotNull
    @ApiModelProperty(value = "Date of defined limit for execution of task", required = true)
    @Column(name = "LPTK_DUE_DATE")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dueDate;


    @ApiModelProperty(value = "Date extended of defined limit for execution of task")
    @Column(name = "LPTK_DUE_DATE_EXT")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dueDateExtended;


    @ApiModelProperty(value = "Date of defined limit for execution of task, attribute for product Line Planning", required = true)
    @Column(name = "LPTK_DUE_DATE_FNL")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dueDateLimit;


    @ApiModelProperty(value = "Percent of programming ideal minimum for a task")
    @Column(name = "LPTK_YIELD")
    private Double yield;


    @NotNull
    @ApiModelProperty(value = "Duration that has a task")
    @Column(name = "LPTK_DURATION")
    private Double duration;


    @ApiModelProperty(value = "Value that identifies a concept global priority")
    @Column(name = "LPTK_PRIORITY")
    private Integer priority;

    @ApiModelProperty(value = "Status of a task in the product Line Planning")
    @Column(name = "LPTK_SCHED_STATUS")
    private String scheduleStatus;

    @ApiModelProperty(value = "workPackage", required = false)
    @Transient
    private WorkPackage workPackage;


    @ApiModelProperty(value = "Detail Aircraft", required = false)
    @Transient
    private Aircraft aircraft;


    @Transient
    private List<Tool> toolList;
    @Transient
    private List<Labour> labourList;
    @Transient
    private List<Part> partList;

    public Task() {
        this.toolList = new ArrayList<Tool>();
        this.workPackage = new WorkPackage();
        this.aircraft = new Aircraft();
        this.labourList = new ArrayList<Labour>();
        this.partList = new ArrayList<Part>();
    }

}