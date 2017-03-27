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

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@JsonRootName(value = "Labour")
@ApiModel(value = "Labour", description = "Information associated to a Labour")
@Getter
@Setter
@ToString
@XmlRootElement
public class Labour implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "dentifier of a labour in the product Line Planning", required = true)
    private Long id;


    @NotNull
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    private Long taskId;


    @NotNull
    @ApiModelProperty(value = "Ability required for labour execution", required = true)
    private String skill;


    @NotNull
    @ApiModelProperty(value = "People required for labour execution", required = true)
    private Integer manRequired;


    @NotNull
    @ApiModelProperty(value = "Man hours required for labour execution", required = true)
    private Double manHrs;


}
