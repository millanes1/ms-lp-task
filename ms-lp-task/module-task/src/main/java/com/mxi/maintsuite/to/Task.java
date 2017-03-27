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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@JsonRootName(value = "Task")
@ApiModel(value = "Task", description = "Information associated to a Task")
@Getter
@Setter
@ToString
@XmlRootElement
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    private Long id;


    @NotNull
    @ApiModelProperty(value = "Visual identifier of a task", required = true)
    private String barcode;


    @NotNull
    @ApiModelProperty(value = "Code of identifier of a task in MXI", required = true)
    private Integer codeMxi;

    @NotNull
    @ApiModelProperty(value = "Registration code of an aircraft", required = true)
    private String tail;

    @NotNull
    @ApiModelProperty(value = "Visual identifier of a Work Package")
    private String barcodeWP;


    @NotNull
    @ApiModelProperty(value = "Name of a task", required = true)
    private String name;


    @NotNull
    @ApiModelProperty(value = "Status of task from MXI", required = true)
    private String status;


    @NotNull
    @ApiModelProperty(value = "Classification the type of Task", required = true)
    private String type;


    @NotNull
    @ApiModelProperty(value = "Date of defined limit for execution of task", required = true)
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dueDate;


    @ApiModelProperty(value = "Date extended of defined limit for execution of task")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dueDateExtended;


    @ApiModelProperty(value = "Date of defined limit for execution of task, attribute for product Line Planning", required = true)
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dueDateLimit;


    @ApiModelProperty(value = "Percent of programming ideal minimum for a task")
    private Double yield;


    @NotNull
    @ApiModelProperty(value = "Duration that has a task")
    private Double duration;


    @ApiModelProperty(value = "Value that identifies a concept global priority")
    private Integer priority;

    @ApiModelProperty(value = "Status of a task in the product Line Planning")
    private String scheduleStatus;

    @ApiModelProperty(value = "workPackage", required = false)
    private WorkPackage workPackage;


    @ApiModelProperty(value = "Detail Aircraft", required = false)
    private Aircraft aircraft;


    private List<Tool> toolList;
    private List<Labour> labourList;


    private List<Part> partList;

    public Task() {
        this.toolList = new ArrayList<Tool>();
        this.workPackage = new WorkPackage();
        this.aircraft = new Aircraft();
        this.labourList = new ArrayList<Labour>();
        this.partList = new ArrayList<Part>();
    }

}