package com.mxi.maintsuite.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by millanes on 21-03-17.
 */


@Getter
@Setter
@ToString
@XmlRootElement
public class Aircraft implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @NotNull
    @JsonProperty("tail")
    @ApiModelProperty(value = "Identifier for Tail", required = true)
    @Getter
    private String tail;

    @NotNull
    @JsonProperty("fleet")
    @ApiModelProperty(value = "Identifier for Fleet", required = true)
    private String fleet;

    @NotNull
    @JsonProperty("authority")
    @ApiModelProperty(value = "Identifier for authority", required = true)
    private String authority;


    @NotNull
    @JsonProperty("operator")
    @ApiModelProperty(value = "Identifier for operator")
    private String operator;


}
