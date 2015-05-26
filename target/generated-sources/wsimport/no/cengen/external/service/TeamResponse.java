
package no.cengen.external.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for teamResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="teamResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="teams" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="team" type="{http://service.soap.pg6100.nith.no/}team" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "teamResponse", propOrder = {
    "teams"
})
public class TeamResponse {

    protected TeamResponse.Teams teams;

    /**
     * Gets the value of the teams property.
     * 
     * @return
     *     possible object is
     *     {@link TeamResponse.Teams }
     *     
     */
    public TeamResponse.Teams getTeams() {
        return teams;
    }

    /**
     * Sets the value of the teams property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeamResponse.Teams }
     *     
     */
    public void setTeams(TeamResponse.Teams value) {
        this.teams = value;
    }


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
     *         &lt;element name="team" type="{http://service.soap.pg6100.nith.no/}team" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "team"
    })
    public static class Teams {

        protected List<Team> team;

        /**
         * Gets the value of the team property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the team property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTeam().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Team }
         * 
         * 
         */
        public List<Team> getTeam() {
            if (team == null) {
                team = new ArrayList<Team>();
            }
            return this.team;
        }

    }

}
