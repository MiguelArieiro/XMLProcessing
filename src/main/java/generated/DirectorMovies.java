//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.17 at 12:25:07 AM BST 
//

package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}movieCatalog"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "name", "movieCatalog" })
@XmlRootElement(name = "directorMovies")
public class DirectorMovies {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected MovieCatalog movieCatalog;

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the movieCatalog property.
     * 
     * @return possible object is {@link MovieCatalog }
     * 
     */
    public MovieCatalog getMovieCatalog() {
        if (movieCatalog == null) {
            movieCatalog = new MovieCatalog();
        }
        return movieCatalog;
    }

    /**
     * Sets the value of the movieCatalog property.
     * 
     * @param value allowed object is {@link MovieCatalog }
     * 
     */
    public void setMovieCatalog(MovieCatalog value) {
        this.movieCatalog = value;
    }

    @Override
    public String toString() {

        return "DirectorMovies:\n\tname=" + name + "\tmovieCatalog:\n" + movieCatalog;
    }

}
