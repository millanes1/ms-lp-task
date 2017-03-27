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

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@JsonRootName(value = "Tool")
@ApiModel(value = "Tool", description = "Information associated to a Tool")
@Getter
@Setter
@ToString
@XmlRootElement
public class Tool implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @ApiModelProperty(value = "Identifier of a tool in the product Line Planning", required = true)
    private Long id;


    @NotNull
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    private Long taskId;

    @NotNull
    @ApiModelProperty(value = "Code of identifier of a tool in MXI", required = true)
    private Integer codeMxi;


    @NotNull
    @ApiModelProperty(value = "Name of a tool", required = true)
    private String name;


    @NotNull
    @ApiModelProperty(value = "Quantity required of the tool", required = true)
    private Double quantity;

}
