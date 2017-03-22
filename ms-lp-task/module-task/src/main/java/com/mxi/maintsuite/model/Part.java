package com.mxi.maintsuite.model;

/**
 * Created by millanes on 20-03-17.
 */


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "LP_PART")
@NamedQueries({
        @NamedQuery(name = "Part.findAll", query = "SELECT p FROM Part p"),
        @NamedQuery(name = "Part.getById", query = "SELECT p FROM Part p WHERE p.id=:id"),
        @NamedQuery(name = "Part.findByTaskId", query = "SELECT p FROM Part p WHERE p.taskId=:taskId")
})
@JsonRootName(value = "Part")
@ApiModel(value = "Part", description = "Information associated to a Part")
@XmlRootElement
public class Part implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "LPPT_CODE")
    @NotNull
    @ApiModelProperty(value = "Identifier of a part in the product Line Planning", required = true)
    private Long id;

    @Column(name = "LPTK_CODE")
    @NotNull
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    private Long taskId;

    @Column(name = "LPPT_CODE_MXI")
    @NotNull
    @ApiModelProperty(value = "Code of identifier of a part in MXI", required = true)
    private Integer codeMxi;

    @Column(name = "LPPT_CODE_MXI_GROUP")
    @NotNull
    @ApiModelProperty(value = "Code of identifier of a group of part in MXI", required = true)
    private Integer codeGroupMxi;


    @Column(name = "LPPT_STATUS")
    @NotNull
    @ApiModelProperty(value = "Status of part from MXI", required = true)
    private String status;


    @Column(name = "LPTT_QUANTITY")
    @NotNull
    @ApiModelProperty(value = "Quantity required of the part", required = true)
    private Double quantity;

    @Column(name = "LPTT_DATE_ETA")
    @NotNull
    @ApiModelProperty(value = "Date estimated arrival of part (ETA)")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date estimatedArrival;

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

    public Integer getCodeGroupMxi() {
        return codeGroupMxi;
    }

    public void setCodeGroupMxi(Integer codeGroupMxi) {
        this.codeGroupMxi = codeGroupMxi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(Date estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", codeMxi=" + codeMxi +
                ", codeGroupMxi=" + codeGroupMxi +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", estimatedArrival=" + estimatedArrival +
                '}';
    }
}
