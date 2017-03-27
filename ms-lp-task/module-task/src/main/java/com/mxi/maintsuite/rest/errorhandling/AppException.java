package com.mxi.maintsuite.rest.errorhandling;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by millanes on 23-03-17.
 */
@Getter
@Setter
@ToString
public class AppException extends Exception {

    private static final long serialVersionUID = -8999932578270387947L;

    /**
     * contains redundantly the HTTP status of the response sent back to the client in case of error, so that
     * the developer does not have to look into the response headers. If null a default
     */
    private Integer status;

    /**
     * application specific error code
     */
    private int code;

    /**
     * link documenting the exception
     */
    private String link;

    /**
     * detailed error description for developers
     */
    private String developerMessage;

    /**
     * @param status
     * @param code
     * @param message
     * @param developerMessage
     * @param link
     */
    public AppException(int status, int code, String message,
                        String developerMessage, String link) {
        super(message);
        this.status = status;
        this.code = code;
        this.developerMessage = developerMessage;
        this.link = link;
    }

    public AppException() {
    }


}