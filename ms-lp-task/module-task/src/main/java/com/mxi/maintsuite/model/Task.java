package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "LP_TASK")
@NamedQueries({@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
        @NamedQuery(name = "Task.getById", query = "SELECT t FROM Task t WHERE t.id=:id"),
        @NamedQuery(name = "Task.getByBarcode", query = "SELECT t FROM Task t WHERE upper(t.barcode)=upper(trim(:barcode))"),
        @NamedQuery(name = "Task.findByAircraft", query = "SELECT t FROM Task t WHERE upper(t.tail)=upper(trim(:tail))"),
        @NamedQuery(name = "Task.findByWorkPackage", query = "SELECT t FROM Task t WHERE upper(t.barcodeWP)=upper(trim(:barcode))")

})
@JsonRootName(value = "Task")
@ApiModel(value = "Task", description = "Information associated to a Task")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getCodeMxi() {
        return codeMxi;
    }

    public void setCodeMxi(Integer codeMxi) {
        this.codeMxi = codeMxi;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getBarcodeWP() {
        return barcodeWP;
    }

    public void setBarcodeWP(String barcodeWP) {
        this.barcodeWP = barcodeWP;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDateExtended() {
        return dueDateExtended;
    }

    public void setDueDateExtended(Date dueDateExtended) {
        this.dueDateExtended = dueDateExtended;
    }

    public Date getDueDateLimit() {
        return dueDateLimit;
    }

    public void setDueDateLimit(Date dueDateLimit) {
        this.dueDateLimit = dueDateLimit;
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public WorkPackage getWorkPackage() {
        return workPackage;
    }

    public void setWorkPackage(WorkPackage workPackage) {
        this.workPackage = workPackage;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public List<Tool> getToolList() {
        return toolList;
    }

    public void setToolList(List<Tool> toolList) {
        this.toolList = toolList;
    }

    public List<Labour> getLabourList() {
        return labourList;
    }

    public void setLabourList(List<Labour> labourList) {
        this.labourList = labourList;
    }

    public List<Part> getPartList() {
        return partList;
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", codeMxi=" + codeMxi +
                ", tail='" + tail + '\'' +
                ", barcodeWP='" + barcodeWP + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", dueDate=" + dueDate +
                ", dueDateExtended=" + dueDateExtended +
                ", dueDateLimit=" + dueDateLimit +
                ", yield=" + yield +
                ", duration=" + duration +
                ", priority=" + priority +
                ", scheduleStatus='" + scheduleStatus + '\'' +
                ", workPackage=" + workPackage +
                ", aircraft=" + aircraft +
                ", toolList=" + toolList +
                ", labourList=" + labourList +
                ", partList=" + partList +
                '}';
    }
}