package com.mxi.maintsuite.to;

/**
 * Created by millanes on 20-03-17.
 */


import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.Date;


@JsonRootName(value = "Part")
@ApiModel(value = "Part", description = "Information associated to a Part")
@Getter
@Setter
@ToString
@XmlRootElement
public class Part implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @ApiModelProperty(value = "Identifier of a part in the product Line Planning", required = true)
    private Long id;


    @NotNull
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    private Long taskId;

    @NotNull
    @ApiModelProperty(value = "Code of identifier of a part in MXI", required = true)
    private Integer codeMxi;


    @NotNull
    @ApiModelProperty(value = "Code of identifier of a group of part in MXI", required = true)
    private Integer codeGroupMxi;


    @NotNull
    @ApiModelProperty(value = "Status of part from MXI", required = true)
    private String status;


    @NotNull
    @ApiModelProperty(value = "Quantity required of the part", required = true)
    private Double quantity;


    @NotNull
    @ApiModelProperty(value = "Date estimated arrival of part (ETA)")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date estimatedArrival;


    @NotNull
    @ApiModelProperty(value = "Name of a task in the product Line Planning", required = true)
    private String name;


}
