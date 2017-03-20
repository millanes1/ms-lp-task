package com.mxi.maintsuite.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "REST_DB_TASKS")
@NamedQueries({@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
        @NamedQuery(name = "Task.getById", query = "SELECT t FROM Task t WHERE t.id=:id"),
        @NamedQuery(name = "Task.findByWorpackageId", query = "SELECT t FROM Task t WHERE t.workpackageId=:id")

})

@XmlRootElement
@JsonRootName(value = "Task")
public class Task implements Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TASK_ID")
    private Integer id;

    @Column(name = "TASK_NAME")
    private String name;


    @Column(name = "WRPK_ID")
    private Integer workpackageId;

    @Transient
    private WorkPackage workPackage;

    @Transient
    private List<Tool> toolList;
    @Transient
    private List<Labour> labourList;

    @Transient
    private List<Part> partList;


    public Task() {
        this.toolList = new ArrayList<Tool>();
        this.workPackage = new WorkPackage();
        this.labourList = new ArrayList<Labour>();
        this.partList = new ArrayList<Part>();
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

    public List<Tool> getToolList() {
        return toolList;
    }

    public void setToolList(List<Tool> toolList) {
        this.toolList = toolList;
    }

    public Integer getWorkpackageId() {
        return workpackageId;
    }

    public void setWorkpackageId(int workpackageId) {
        this.workpackageId = workpackageId;
    }

    public void setWorkpackageId(Integer workpackageId) {
        this.workpackageId = workpackageId;
    }

    public WorkPackage getWorkPackage() {
        return workPackage;
    }

    public void setWorkPackage(WorkPackage workPackage) {
        this.workPackage = workPackage;
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
                ", name='" + name + '\'' +
                ", workpackageId=" + workpackageId +
                ", workPackage=" + workPackage +
                ", toolList=" + toolList +
                ", labourList=" + labourList +
                ", partList=" + partList +
                '}';
    }

}