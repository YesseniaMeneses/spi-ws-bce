package com.cobiscorp.ecobis.spi.service.api;

import com.cobiscorp.ecobis.spi.service.impl.Request;
import com.cobiscorp.ecobis.spi.service.impl.Response;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UC
{
    @WebMethod Response execute(Request request);
}