
package ru.javaops.masterjava.xml.schema;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="email" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="flag" use="required" type="{http://javaops.ru}flagType" />
 *       &lt;attribute name="city" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="groups" type="{http://www.w3.org/2001/XMLSchema}IDREFS" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fullName"
})
@XmlRootElement(name = "User")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class User {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String fullName;
    @XmlAttribute(name = "email")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String email;
    @XmlAttribute(name = "flag", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected FlagType flag;
    @XmlAttribute(name = "city", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Object city;
    @XmlAttribute(name = "groups")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Object> groups;

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the flag property.
     * 
     * @return
     *     possible object is
     *     {@link FlagType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public FlagType getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlagType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setFlag(FlagType value) {
        this.flag = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Object getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setCity(Object value) {
        this.city = value;
    }

    /**
     * Gets the value of the groups property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groups property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroups().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-10-13T09:54:48+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Object> getGroups() {
        if (groups == null) {
            groups = new ArrayList<Object>();
        }
        return this.groups;
    }

}
