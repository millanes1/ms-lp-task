package com.mxi.maintsuite.model;

/**
 * Created by millanes on 20-03-17.
 */


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "REST_DB_TOOLS")
@NamedQueries({
        @NamedQuery(name = "Tool.findAll", query = "SELECT t FROM Tool t"),
        @NamedQuery(name = "Tool.getById", query = "SELECT t FROM Tool t WHERE t.id=:id"),
        @NamedQuery(name = "Tool.findByTaskId", query = "SELECT t FROM Tool t WHERE t.taskId=:taskId")
})
@JsonRootName(value = "Tool")
@ApiModel(value = "Tool", description = "Information associated to a Tool")
@XmlRootElement
public class Tool implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TOOL_ID")
    @NotNull
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @Column(name = "TOOL_NAME")
    @NotNull
    @ApiModelProperty(value = "name", required = true)
    private String name;

    @Column(name = "TASK_ID")
    @NotNull
    @ApiModelProperty(value = "taskId", required = true)
    private Integer taskId;

    public Tool() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Tool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskId=" + taskId +
                '}';
    }
}
