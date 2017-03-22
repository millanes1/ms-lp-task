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
@Table(name = "LP_TOOL")
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
    @Column(name = "LPTL_CODE")
    @NotNull
    @ApiModelProperty(value = "Identifier of a tool in the product Line Planning", required = true)
    private Long id;

    @Column(name = "LPTK_CODE")
    @NotNull
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    private Long taskId;

    @Column(name = "LPTL_CODE_MXI")
    @NotNull
    @ApiModelProperty(value = "Code of identifier of a tool in MXI", required = true)
    private Integer codeMxi;

    @Column(name = "LPTL_NAME")
    @NotNull
    @ApiModelProperty(value = "Name of a tool", required = true)
    private String name;


    @Column(name = "LPTL_QUANTITY")
    @NotNull
    @ApiModelProperty(value = "Quantity required of the tool", required = true)
    private Double quantity;

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

    public Integer getCodeMxi() {
        return codeMxi;
    }

    public void setCodeMxi(Integer codeMxi) {
        this.codeMxi = codeMxi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", codeMxi=" + codeMxi +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
