package com.mxi.maintsuite.to;

/**
 * Created by millanes on 20-03-17.
 */


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "LINE_PLANNING.LP_TOOL")
@NamedQueries({
        @NamedQuery(name = "Tool.findAll", query = "SELECT t FROM Tool t"),
        @NamedQuery(name = "Tool.getById", query = "SELECT t FROM Tool t WHERE t.id=:id"),
        @NamedQuery(name = "Tool.findByTaskId", query = "SELECT t FROM Tool t WHERE t.taskId=:taskId")
})
@JsonRootName(value = "Tool")
@ApiModel(value = "Tool", description = "Information associated to a Tool")
@Getter
@Setter
@ToString
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

}
