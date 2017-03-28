package com.mxi.maintsuite.to.filter;

import com.mxi.maintsuite.to.Aircraft;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by millanes on 27-03-17.
 */
@Getter
@Setter
@ToString
@XmlRootElement
public class SettingFilter implements Serializable {
    private static final long serialVersionUID = 1L;

    private Aircraft aircraft;
    private DueDate dueDate;
}
