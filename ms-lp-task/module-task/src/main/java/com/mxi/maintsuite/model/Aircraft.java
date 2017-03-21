package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by millanes on 21-03-17.
 */

@Entity
@Table(name = "LP_AIRCRAFT")
@NamedQueries({@NamedQuery(name = "Aircraft.findAll", query = "SELECT a FROM Aircraft a"),
        @NamedQuery(name = "Aircraft.getById", query = "SELECT a FROM Aircraft a WHERE a.tail=:tail")

})
public class Aircraft implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @NotNull
    @Column(name = "LPAC_AC_REG_CD")
    private String tail;

    @NotNull
    @Column(name = "LPAC_ASSMBL_CD")
    private String fleet;

    @NotNull
    @Column(name = "LPAC_AUTHORITY_CD")
    private String operator;

    @JsonProperty("tail")
    @ApiModelProperty(value = "Identifier for Tail", required = true)
    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
    @JsonProperty("fleet")
    @ApiModelProperty(value = "Identifier for Fleet", required = true)
    public String getFleet() {
        return fleet;
    }

    public void setFleet(String fleet) {
        this.fleet = fleet;
    }

    @JsonProperty("operator")
    @ApiModelProperty(value = "Identifier for operator", required = true)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "tail='" + tail + '\'' +
                ", fleet='" + fleet + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
