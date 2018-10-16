
package com.cobiscorp.ecobis.spi.service.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "in2cm", namespace = "http://api.service.spi.ecobis.cobiscorp.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "in2cm", namespace = "http://api.service.spi.ecobis.cobiscorp.com/")
public class In2cm {

    @XmlElement(name = "arg0", namespace = "")
    private double arg0;

    /**
     * 
     * @return
     *     returns double
     */
    public double getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(double arg0) {
        this.arg0 = arg0;
    }

}
