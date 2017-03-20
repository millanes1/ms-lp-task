package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "REST_DB_TASKS")
@NamedQueries({@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
        @NamedQuery(name = "Task.getById", query = "SELECT t FROM Task t WHERE t.id=:id"),
        @NamedQuery(name = "Task.findByWorpackageId", query = "SELECT t FROM Task t WHERE t.workpackageId=:id")

})
@JsonRootName(value = "Task")
@XmlRootElement
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


    public Task() {

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

    public Integer getWorkpackageId() {
        return workpackageId;
    }

    public void setWorkpackageId(Integer workpackageId) {
        this.workpackageId = workpackageId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workpackageId=" + workpackageId +
                '}';
    }
}