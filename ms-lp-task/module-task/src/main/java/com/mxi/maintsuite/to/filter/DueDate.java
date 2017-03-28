package com.mxi.maintsuite.to.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by millanes on 28-03-17.
 */
@Getter
@Setter
@ToString
@XmlRootElement
public class DueDate implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date to;
    private Date from;


}



















