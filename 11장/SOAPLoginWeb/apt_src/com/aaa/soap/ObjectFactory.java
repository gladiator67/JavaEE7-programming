
package com.aaa.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aaa.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginFunc_QNAME = new QName("http://soap.aaa.com/", "loginFunc");
    private final static QName _LoginFuncResponse_QNAME = new QName("http://soap.aaa.com/", "loginFuncResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aaa.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginFunc }
     * 
     */
    public LoginFunc createLoginFunc() {
        return new LoginFunc();
    }

    /**
     * Create an instance of {@link LoginFuncResponse }
     * 
     */
    public LoginFuncResponse createLoginFuncResponse() {
        return new LoginFuncResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginFunc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.aaa.com/", name = "loginFunc")
    public JAXBElement<LoginFunc> createLoginFunc(LoginFunc value) {
        return new JAXBElement<LoginFunc>(_LoginFunc_QNAME, LoginFunc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginFuncResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.aaa.com/", name = "loginFuncResponse")
    public JAXBElement<LoginFuncResponse> createLoginFuncResponse(LoginFuncResponse value) {
        return new JAXBElement<LoginFuncResponse>(_LoginFuncResponse_QNAME, LoginFuncResponse.class, null, value);
    }

}
