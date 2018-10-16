package com.cobiscorp.ecobis.spi.service.impl;

import java.io.Serializable;

public class Response implements Serializable {
    Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
