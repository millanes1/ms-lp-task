package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by millanes on 19-03-17.
 */
@XmlRootElement
@JsonRootName(value = "Aircraft")
public class Aircraft implements Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    private String tail;
    private String fleet;
    private String operator;

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getFleet() {
        return fleet;
    }

    public void setFleet(String fleet) {
        this.fleet = fleet;
    }

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
