
package no.cengen.external.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.cengen.external.service package. 
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

    private final static QName _CallerId_QNAME = new QName("http://service.soap.pg6100.nith.no/", "CallerId");
    private final static QName _GetGamesResponse_QNAME = new QName("http://service.soap.pg6100.nith.no/", "getGamesResponse");
    private final static QName _SOAPException_QNAME = new QName("http://service.soap.pg6100.nith.no/", "SOAPException");
    private final static QName _Game_QNAME = new QName("http://service.soap.pg6100.nith.no/", "game");
    private final static QName _GetTeamsResponse_QNAME = new QName("http://service.soap.pg6100.nith.no/", "getTeamsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.cengen.external.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Team }
     * 
     */
    public Team createTeam() {
        return new Team();
    }

    /**
     * Create an instance of {@link GameResponse }
     * 
     */
    public GameResponse createGameResponse() {
        return new GameResponse();
    }

    /**
     * Create an instance of {@link TeamResponse }
     * 
     */
    public TeamResponse createTeamResponse() {
        return new TeamResponse();
    }

    /**
     * Create an instance of {@link SOAPException }
     * 
     */
    public SOAPException createSOAPException() {
        return new SOAPException();
    }

    /**
     * Create an instance of {@link Team.Players }
     * 
     */
    public Team.Players createTeamPlayers() {
        return new Team.Players();
    }

    /**
     * Create an instance of {@link GameResponse.Games }
     * 
     */
    public GameResponse.Games createGameResponseGames() {
        return new GameResponse.Games();
    }

    /**
     * Create an instance of {@link TeamResponse.Teams }
     * 
     */
    public TeamResponse.Teams createTeamResponseTeams() {
        return new TeamResponse.Teams();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.pg6100.nith.no/", name = "CallerId")
    public JAXBElement<String> createCallerId(String value) {
        return new JAXBElement<String>(_CallerId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.pg6100.nith.no/", name = "getGamesResponse")
    public JAXBElement<GameResponse> createGetGamesResponse(GameResponse value) {
        return new JAXBElement<GameResponse>(_GetGamesResponse_QNAME, GameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.pg6100.nith.no/", name = "SOAPException")
    public JAXBElement<SOAPException> createSOAPException(SOAPException value) {
        return new JAXBElement<SOAPException>(_SOAPException_QNAME, SOAPException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.pg6100.nith.no/", name = "game")
    public JAXBElement<String> createGame(String value) {
        return new JAXBElement<String>(_Game_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TeamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.pg6100.nith.no/", name = "getTeamsResponse")
    public JAXBElement<TeamResponse> createGetTeamsResponse(TeamResponse value) {
        return new JAXBElement<TeamResponse>(_GetTeamsResponse_QNAME, TeamResponse.class, null, value);
    }

}
