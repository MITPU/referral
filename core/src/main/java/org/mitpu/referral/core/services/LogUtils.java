package org.mitpu.referral.core.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.controllers.GlobalExceptionHandler;
import org.mitpu.referral.core.controllers.dto.Dto;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

// TODO use SL4J instead of log4j implementation.
public class LogUtils {

    private static final Logger LOGGER = LogManager.getLogger(LogUtils.class);

    // TODO enable log4j's attaching reqID feature.
    public static final String MESSAGE_FORMAT = "[ReqID=%s] %s";

    // TODO create http request/response handler's wrapper class which will have a logger.
    public static void logWebRequest(Dto dto, HttpServletRequest request, String body) {
        String dtoMessage = String.format("DTO: %s", dto.getObjectName());
        String urlMessage = String.format("URL: %s %s", request.getMethod(), request.getRequestURL());
        StringBuilder headerBuilder = new StringBuilder();
        if (request.getHeaderNames() != null) {
            Enumeration headerNames = request.getHeaderNames();
            headerBuilder.append("\n");
            while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                headerBuilder.append(key);
                headerBuilder.append("=");
                headerBuilder.append(request.getHeader(key));
                headerBuilder.append("\n");
            }
        }
        String headerMessage = String.format("Header: %s", headerBuilder.toString());
        String bodyMessage = String.format("Body: %s", body);
        LOGGER.info(String.format(MESSAGE_FORMAT, dto.getReqID(), "=== New request is received. ==="));
        LOGGER.info(String.format(MESSAGE_FORMAT, dto.getReqID(), dtoMessage));
        LOGGER.info(String.format(MESSAGE_FORMAT, dto.getReqID(), urlMessage));
        LOGGER.info(String.format(MESSAGE_FORMAT, dto.getReqID(), headerMessage));
        LOGGER.info(String.format(MESSAGE_FORMAT, dto.getReqID(), bodyMessage));
    }

    public static void logWebResponse(Dto dto, HttpStatus httpStatus) {
        String bodyMessage = String.format("Body: %s", dto.toString());
        String httpStatusMessage = String.format("HTTP status: %s", httpStatus);
        LOGGER.info(String.format(MESSAGE_FORMAT, dto.getReqID(), "=== Response is sent. ==="));
        LOGGER.info(String.format(MESSAGE_FORMAT, dto.getReqID(), bodyMessage));
        LOGGER.info(String.format(MESSAGE_FORMAT, dto.getReqID(), httpStatusMessage));
    }
}
