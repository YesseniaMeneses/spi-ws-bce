
package com.cobiscorp.ecobis.spi.service.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.cobiscorp.ecobis.spi.service.impl.Request;

@XmlRootElement(name = "execute", namespace = "http://api.service.spi.ecobis.cobiscorp.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "execute", namespace = "http://api.service.spi.ecobis.cobiscorp.com/")
public class Execute {

    @XmlElement(name = "arg0", namespace = "")
    private Request arg0;

    /**
     * 
     * @return
     *     returns Request
     */
    public Request getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(Request arg0) {
        this.arg0 = arg0;
    }

}
