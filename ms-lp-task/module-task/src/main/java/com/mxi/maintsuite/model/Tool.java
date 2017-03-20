package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "REST_DB_TOOLS")
@NamedQueries({
        @NamedQuery(name = "Tool.findAll", query = "SELECT t FROM Tool t"),
        @NamedQuery(name = "Tool.getById", query = "SELECT t FROM Tool t WHERE t.id=:id"),
        @NamedQuery(name = "Tool.findByTaskId", query = "SELECT t FROM Tool t WHERE t.taskId=:id")
})
@XmlRootElement
@JsonRootName(value = "Tool")
public class Tool implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TOOL_ID")
    private Integer id;

    @Column(name = "TOOL_NAME")
    private String name;
    @Column(name = "TASK_ID")
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