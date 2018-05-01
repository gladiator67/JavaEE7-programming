
package com.aaa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>item complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="item"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shop" type="{http://www.aaa.com}shop" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
    "color",
    "id",
    "name",
    "price",
    "provider",
    "shop"
})
public class Item {

    protected String color;
    protected int id;
    protected String name;
    protected int price;
    protected String provider;
    protected Shop shop;

    /**
     * color 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * color 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * id 속성의 값을 가져옵니다.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * id 속성의 값을 설정합니다.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * price 속성의 값을 가져옵니다.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * price 속성의 값을 설정합니다.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * provider 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvider() {
        return provider;
    }

    /**
     * provider 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvider(String value) {
        this.provider = value;
    }

    /**
     * shop 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Shop }
     *     
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * shop 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Shop }
     *     
     */
    public void setShop(Shop value) {
        this.shop = value;
    }

}
