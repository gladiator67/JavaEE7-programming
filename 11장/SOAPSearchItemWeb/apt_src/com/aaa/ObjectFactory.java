
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

    private final static QName _GetProductsInfo_QNAME = new QName("http://www.aaa.com", "getProductsInfo");
    private final static QName _GetProductsInfoResponse_QNAME = new QName("http://www.aaa.com", "getProductsInfoResponse");
    private final static QName _SetShopItems_QNAME = new QName("http://www.aaa.com", "setShopItems");
    private final static QName _SetShopItemsResponse_QNAME = new QName("http://www.aaa.com", "setShopItemsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aaa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductsInfoResponse }
     * 
     */
    public GetProductsInfoResponse createGetProductsInfoResponse() {
        return new GetProductsInfoResponse();
    }

    /**
     * Create an instance of {@link GetProductsInfo }
     * 
     */
    public GetProductsInfo createGetProductsInfo() {
        return new GetProductsInfo();
    }

    /**
     * Create an instance of {@link Products }
     * 
     */
    public Products createProducts() {
        return new Products();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link SetShopItems }
     * 
     */
    public SetShopItems createSetShopItems() {
        return new SetShopItems();
    }

    /**
     * Create an instance of {@link SetShopItemsResponse }
     * 
     */
    public SetShopItemsResponse createSetShopItemsResponse() {
        return new SetShopItemsResponse();
    }

    /**
     * Create an instance of {@link Shop }
     * 
     */
    public Shop createShop() {
        return new Shop();
    }

    /**
     * Create an instance of {@link GetProductsInfoResponse.Return }
     * 
     */
    public GetProductsInfoResponse.Return createGetProductsInfoResponseReturn() {
        return new GetProductsInfoResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.aaa.com", name = "getProductsInfo")
    public JAXBElement<GetProductsInfo> createGetProductsInfo(GetProductsInfo value) {
        return new JAXBElement<GetProductsInfo>(_GetProductsInfo_QNAME, GetProductsInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.aaa.com", name = "getProductsInfoResponse")
    public JAXBElement<GetProductsInfoResponse> createGetProductsInfoResponse(GetProductsInfoResponse value) {
        return new JAXBElement<GetProductsInfoResponse>(_GetProductsInfoResponse_QNAME, GetProductsInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetShopItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.aaa.com", name = "setShopItems")
    public JAXBElement<SetShopItems> createSetShopItems(SetShopItems value) {
        return new JAXBElement<SetShopItems>(_SetShopItems_QNAME, SetShopItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetShopItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.aaa.com", name = "setShopItemsResponse")
    public JAXBElement<SetShopItemsResponse> createSetShopItemsResponse(SetShopItemsResponse value) {
        return new JAXBElement<SetShopItemsResponse>(_SetShopItemsResponse_QNAME, SetShopItemsResponse.class, null, value);
    }

}
