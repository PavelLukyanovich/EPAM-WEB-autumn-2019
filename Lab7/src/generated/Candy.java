//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.01 at 03:48:05 PM GMT+02:00 
//


package generated;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for candy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="candy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ingredients" type="{}ingredientsType"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="energy" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="production" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filling" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candy", propOrder = {
    "ingredients",
    "name",
    "energy",
    "production",
    "filling"
})
@XmlSeeAlso({
    Mycandy.class
})
@XmlRootElement
public abstract class Candy {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected IngredientsType ingredients;
    @XmlElement(required = true)
    protected String name;
    protected int energy;
    @XmlElement(required = true)
    protected String production;
    protected boolean filling;

    /**
     * Gets the value of the ingredients property.
     * 
     * @return
     *     possible object is
     *     {@link IngredientsType }
     *     
     */
    public IngredientsType getIngredients() {
        return ingredients;
    }

    /**
     * Sets the value of the ingredients property.
     * 
     * @param value
     *     allowed object is
     *     {@link IngredientsType }
     *     
     */
    public void setIngredients(IngredientsType value) {
        this.ingredients = value;
    }

    /**
     * Gets the value of the name property.
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
     * Sets the value of the name property.
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
     * Gets the value of the energy property.
     * 
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Sets the value of the energy property.
     * 
     */
    public void setEnergy(int value) {
        this.energy = value;
    }

    /**
     * Gets the value of the production property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduction() {
        return production;
    }

    /**
     * Sets the value of the production property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduction(String value) {
        this.production = value;
    }

    /**
     * Gets the value of the filling property.
     * 
     */
    public boolean isFilling() {
        return filling;
    }

    /**
     * Sets the value of the filling property.
     * 
     */
    public void setFilling(boolean value) {
        this.filling = value;
    }

}
