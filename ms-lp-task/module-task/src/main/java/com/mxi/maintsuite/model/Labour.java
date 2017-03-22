package com.mxi.maintsuite.model;

/**
 * Created by millanes on 20-03-17.
 */


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "LP_LABOUR")
@NamedQueries({
        @NamedQuery(name = "Labour.findAll", query = "SELECT l FROM Labour l"),
        @NamedQuery(name = "Labour.getById", query = "SELECT l FROM Labour l WHERE l.id=:id"),
        @NamedQuery(name = "Labour.findByTaskId", query = "SELECT l FROM Labour l WHERE l.taskId=:taskId")
})
@JsonRootName(value = "Labour")
@ApiModel(value = "Labour", description = "Information associated to a Labour")
@XmlRootElement
public class Labour implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "LPLB_CODE")
    @NotNull
    @ApiModelProperty(value = "dentifier of a labour in the product Line Planning", required = true)
    private Long id;

    @Column(name = "LPTK_CODE")
    @NotNull
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    private Long taskId;

    @Column(name = "LPLB_SKILL")
    @NotNull
    @ApiModelProperty(value = "Ability required for labour execution", required = true)
    private String skill;

    @Column(name = "LPLB_MAN_REQUIRED")
    @NotNull
    @ApiModelProperty(value = "People required for labour execution", required = true)
    private Integer manRequired;


    @Column(name = "LPLB_MAN_HR")
    @NotNull
    @ApiModelProperty(value = "Man hours required for labour execution", required = true)
    private Double manHrs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getManRequired() {
        return manRequired;
    }

    public void setManRequired(Integer manRequired) {
        this.manRequired = manRequired;
    }

    public Double getManHrs() {
        return manHrs;
    }

    public void setManHrs(Double manHrs) {
        this.manHrs = manHrs;
    }

    @Override
    public String toString() {
        return "Labour{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", skill='" + skill + '\'' +
                ", manRequired=" + manRequired +
                ", manHrs=" + manHrs +
                '}';
    }
}