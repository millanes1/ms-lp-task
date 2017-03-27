package com.mxi.maintsuite.rest.errorhandling;

/**
 * Created by millanes on 23-03-17.
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.beanutils.BeanUtils;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.InvocationTargetException;

@Getter
@Setter
@ToString
@XmlRootElement
public class ErrorMessage {

    /**
     * contains the same HTTP Status code returned by the server
     */
    @XmlElement(name = "status")
    int status;

    /**
     * application specific error code
     */
    @XmlElement(name = "code")
    int code;

    /**
     * message describing the error
     */
    @XmlElement(name = "message")
    String message;

    /**
     * link point to page where the error message is documented
     */
    @XmlElement(name = "link")
    String link;

    /**
     * extra information that might useful for developers
     */
    @XmlElement(name = "developerMessage")
    String developerMessage;


    public ErrorMessage(AppException ex) {
        try {
            BeanUtils.copyProperties(this, ex);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
          //  e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
         //   e.printStackTrace();
        }
    }

    public ErrorMessage(NotFoundException ex) {
        this.status = Response.Status.NOT_FOUND.getStatusCode();
        this.message = ex.getMessage();
        this.link = "https://jersey.java.net/apidocs/2.8/jersey/javax/ws/rs/NotFoundException.html";
    }

    public ErrorMessage() {
    }

}