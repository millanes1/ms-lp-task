package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by millanes on 21-03-17.
 */

@Entity
@Table(name = "LP_AIRCRAFT")
@NamedQueries({@NamedQuery(name = "Aircraft.findAll", query = "SELECT a FROM Aircraft a"),
        @NamedQuery(name = "Aircraft.getById", query = "SELECT a FROM Aircraft a WHERE upper(a.tail)=upper(trim(:tail))")

})
@Getter
@Setter
@ToString
public class Aircraft implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @NotNull
    @Column(name = "LPAC_AC_REG_CD")
    @JsonProperty("tail")
    @ApiModelProperty(value = "Identifier for Tail", required = true)
    @Getter
    private String tail;

    @NotNull
    @Column(name = "LPAC_ASSMBL_CD")
    @JsonProperty("fleet")
    @ApiModelProperty(value = "Identifier for Fleet", required = true)
    private String fleet;

    @NotNull
    @Column(name = "LPAC_AUTHORITY_CD")
    @JsonProperty("authority")
    @ApiModelProperty(value = "Identifier for authority", required = true)
    private String authority;


    @Transient
    @JsonProperty("operator")
    @ApiModelProperty(value = "Identifier for operator /PENDIENTE CREACION EN BD")
    private String operator;

}
