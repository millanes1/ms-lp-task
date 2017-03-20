package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "REST_DB_TASKS")
@NamedQueries({@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
        @NamedQuery(name = "Task.getById", query = "SELECT t FROM Task t WHERE t.id=:id"),
        @NamedQuery(name = "Task.findByWorkPackageId", query = "SELECT t FROM Task t WHERE t.workPackageId=:id")

})
@JsonRootName(value = "Task")
@ApiModel(value = "Task", description = "Information associated to a Task")
@XmlRootElement
public class Task implements Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "TASK_ID")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @NotNull
    @ApiModelProperty(value = "name", required = true)
    @Column(name = "TASK_NAME")
    private String name;

    @ApiModelProperty(value = "workPackageId", required = false)
    @Column(name = "WRPK_ID")
    private Integer workPackageId;

    @Transient
    private List<Tool> toolList;


    public Task() {
        this.toolList = new ArrayList<Tool>();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkPackageId() {
        return workPackageId;
    }

    public void setWorkPackageId(Integer workPackageId) {
        this.workPackageId = workPackageId;
    }

    public List<Tool> getToolList() {
        return toolList;
    }

    public void setToolList(List<Tool> toolList) {
        this.toolList = toolList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workPackageId=" + workPackageId +
                ", toolList=" + toolList +
                '}';
    }
}