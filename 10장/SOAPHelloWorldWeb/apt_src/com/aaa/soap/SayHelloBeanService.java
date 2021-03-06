package com.aaa.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2018-02-25T19:09:50.656+09:00
 * Generated source version: 3.1.12
 * 
 */
@WebServiceClient(name = "SayHelloBeanService", 
                  wsdlLocation = "http://localhost:8080/SOAPHelloWorldWeb/SayHelloBean?wsdl",
                  targetNamespace = "http://soap.aaa.com/") 
public class SayHelloBeanService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.aaa.com/", "SayHelloBeanService");
    public final static QName SayHelloBeanPort = new QName("http://soap.aaa.com/", "SayHelloBeanPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/SOAPHelloWorldWeb/SayHelloBean?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SayHelloBeanService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/SOAPHelloWorldWeb/SayHelloBean?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SayHelloBeanService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SayHelloBeanService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SayHelloBeanService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public SayHelloBeanService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SayHelloBeanService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SayHelloBeanService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ISayHelloPort
     */
    @WebEndpoint(name = "SayHelloBeanPort")
    public ISayHelloPort getSayHelloBeanPort() {
        return super.getPort(SayHelloBeanPort, ISayHelloPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ISayHelloPort
     */
    @WebEndpoint(name = "SayHelloBeanPort")
    public ISayHelloPort getSayHelloBeanPort(WebServiceFeature... features) {
        return super.getPort(SayHelloBeanPort, ISayHelloPort.class, features);
    }

}
