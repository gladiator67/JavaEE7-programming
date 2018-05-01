
package com.aaa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aaa package. 
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

    private final static QName _GetMember_QNAME = new QName("http://www.aaa.com", "getMember");
    private final static QName _GetMemberResponse_QNAME = new QName("http://www.aaa.com", "getMemberResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aaa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMemberResponse }
     * 
     */
    public GetMemberResponse createGetMemberResponse() {
        return new GetMemberResponse();
    }

    /**
     * Create an instance of {@link GetMember }
     * 
     */
    public GetMember createGetMember() {
        return new GetMember();
    }

    /**
     * Create an instance of {@link Member }
     * 
     */
    public Member createMember() {
        return new Member();
    }

    /**
     * Create an instance of {@link GetMemberResponse.Return }
     * 
     */
    public GetMemberResponse.Return createGetMemberResponseReturn() {
        return new GetMemberResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMember }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.aaa.com", name = "getMember")
    public JAXBElement<GetMember> createGetMember(GetMember value) {
        return new JAXBElement<GetMember>(_GetMember_QNAME, GetMember.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMemberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.aaa.com", name = "getMemberResponse")
    public JAXBElement<GetMemberResponse> createGetMemberResponse(GetMemberResponse value) {
        return new JAXBElement<GetMemberResponse>(_GetMemberResponse_QNAME, GetMemberResponse.class, null, value);
    }

}
