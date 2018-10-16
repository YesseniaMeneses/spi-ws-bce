
package com.cobiscorp.ecobis.spi.service.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.cobiscorp.ecobis.spi.service.impl.Response;

@XmlRootElement(name = "executeResponse", namespace = "http://api.service.spi.ecobis.cobiscorp.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeResponse", namespace = "http://api.service.spi.ecobis.cobiscorp.com/")
public class ExecuteResponse {

    @XmlElement(name = "return", namespace = "")
    private Response _return;

    /**
     * 
     * @return
     *     returns Response
     */
    public Response getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Response _return) {
        this._return = _return;
    }

}
