package com.mxi.maintsuite.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "REST_DB_WORKPACKAGES")
@NamedQueries({
        @NamedQuery(name = "WorkPackage.findAll", query = "SELECT w FROM WorkPackage w"),
        @NamedQuery(name = "WorkPackage.getById", query = "SELECT w FROM WorkPackage w WHERE w.id=:id")
})
@XmlRootElement
@JsonRootName(value = "WorkPackage")
public class WorkPackage implements Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WRPK_ID")
    private Integer id;

    @Column(name = "WRPK_NAME")
    private String name;

    @Column(name = "WRPK_BARCODE")
    private String barcode;


    public WorkPackage() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    @Override
    public String toString() {
        return "WorkPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode='" + barcode + '\'' +
                '}';
    }
}