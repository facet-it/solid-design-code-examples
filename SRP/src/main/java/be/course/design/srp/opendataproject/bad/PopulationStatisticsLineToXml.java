package be.course.design.srp.opendataproject.bad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "line")
public class PopulationStatisticsLineToXml {
    
    private String refnisCodeGemeente;
    private String naamGemeenteNl;
    private String naamGemeenteFr;
    private String refnisCodeArrondissement;
    private String naamArrondissementNl;
    private String naamArrondissementFr;
    private String refnisCodeProvincie;
    private String naamProvincieNl;
    private String naamProvincieFr;
    private String refnisCodeGewest;
    private String naamGewestNl;
    private String naamGewestFr;
    private String geslacht;
    private String nationaliteitsCode;
    private String nationaliteitNl;
    private String nationaliteitFr;
    private String codeBurgerlijkeStaat;
    private String burgerlijkeStaatNl;
    private String burgerlijkeStaatFr;
    private Integer leeftijd;
    private Integer aantal;
    private String jaartal;

    public String getRefnisCodeGemeente() {
        return refnisCodeGemeente;
    }

    @XmlElement(name = "refnisGemeente")
    public void setRefnisCodeGemeente(String refnisCodeGemeente) {
        this.refnisCodeGemeente = refnisCodeGemeente;
    }

    public String getNaamGemeenteNl() {
        return naamGemeenteNl;
    }

    @XmlElement(name = "naamGemeenteNl")
    public void setNaamGemeenteNl(String naamGemeenteNl) {
        this.naamGemeenteNl = naamGemeenteNl;
    }

    public String getNaamGemeenteFr() {
        return naamGemeenteFr;
    }

    @XmlElement(name = "naamGemeenteFr")
    public void setNaamGemeenteFr(String naamGemeenteFr) {
        this.naamGemeenteFr = naamGemeenteFr;
    }

    public String getRefnisCodeArrondissement() {
        return refnisCodeArrondissement;
    }

    @XmlElement(name = "refnisArrondissement")
    public void setRefnisCodeArrondissement(String refnisCodeArrondissement) {
        this.refnisCodeArrondissement = refnisCodeArrondissement;
    }

    public String getNaamArrondissementNl() {
        return naamArrondissementNl;
    }

    @XmlElement(name = "naamArrondissementNl")
    public void setNaamArrondissementNl(String naamArrondissementNl) {
        this.naamArrondissementNl = naamArrondissementNl;
    }

    public String getNaamArrondissementFr() {
        return naamArrondissementFr;
    }

    @XmlElement(name = "naamArrondissementFr")
    public void setNaamArrondissementFr(String naamArrondissementFr) {
        this.naamArrondissementFr = naamArrondissementFr;
    }

    public String getRefnisCodeProvincie() {
        return refnisCodeProvincie;
    }

    @XmlElement(name = "refnisProvincie")
    public void setRefnisCodeProvincie(String refnisCodeProvincie) {
        this.refnisCodeProvincie = refnisCodeProvincie;
    }

    public String getNaamProvincieNl() {
        return naamProvincieNl;
    }

    @XmlElement(name = "naamProvincieNl")
    public void setNaamProvincieNl(String naamProvincieNl) {
        this.naamProvincieNl = naamProvincieNl;
    }

    public String getNaamProvincieFr() {
        return naamProvincieFr;
    }

    @XmlElement(name = "naamProvincieFr")
    public void setNaamProvincieFr(String naamProvincieFr) {
        this.naamProvincieFr = naamProvincieFr;
    }

    public String getRefnisCodeGewest() {
        return refnisCodeGewest;
    }

    @XmlElement(name = "refnisGewest")
    public void setRefnisCodeGewest(String refnisCodeGewest) {
        this.refnisCodeGewest = refnisCodeGewest;
    }

    public String getNaamGewestNl() {
        return naamGewestNl;
    }

    @XmlElement(name = "naamGewestNl")
    public void setNaamGewestNl(String naamGewestNl) {
        this.naamGewestNl = naamGewestNl;
    }

    public String getNaamGewestFr() {
        return naamGewestFr;
    }

    @XmlElement(name = "naamGewestFr")
    public void setNaamGewestFr(String naamGewestFr) {
        this.naamGewestFr = naamGewestFr;
    }

    public String getGeslacht() {
        return geslacht;
    }

    @XmlElement(name = "geslacht")
    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getNationaliteitsCode() {
        return nationaliteitsCode;
    }

    @XmlElement(name = "codeNationaliteit")
    public void setNationaliteitsCode(String nationaliteitsCode) {
        this.nationaliteitsCode = nationaliteitsCode;
    }

    public String getNationaliteitNl() {
        return nationaliteitNl;
    }

    @XmlElement(name = "nationaliteitNl")
    public void setNationaliteitNl(String nationaliteitNl) {
        this.nationaliteitNl = nationaliteitNl;
    }

    public String getNationaliteitFr() {
        return nationaliteitFr;
    }

    @XmlElement(name = "nationaliteitFr")
    public void setNationaliteitFr(String nationaliteitFr) {
        this.nationaliteitFr = nationaliteitFr;
    }

    public String getCodeBurgerlijkeStaat() {
        return codeBurgerlijkeStaat;
    }

    @XmlElement(name = "codeBurgerlijkeStaat")
    public void setCodeBurgerlijkeStaat(String codeBurgerlijkeStaat) {
        this.codeBurgerlijkeStaat = codeBurgerlijkeStaat;
    }

    public String getBurgerlijkeStaatNl() {
        return burgerlijkeStaatNl;
    }

    @XmlElement(name = "burgerlijkeStaatNl")
    public void setBurgerlijkeStaatNl(String burgerlijkeStaatNl) {
        this.burgerlijkeStaatNl = burgerlijkeStaatNl;
    }

    public String getBurgerlijkeStaatFr() {
        return burgerlijkeStaatFr;
    }

    @XmlElement(name = "burgerlijkeStaatFr")
    public void setBurgerlijkeStaatFr(String burgerlijkeStaatFr) {
        this.burgerlijkeStaatFr = burgerlijkeStaatFr;
    }

    public Integer getLeeftijd() {
        return leeftijd;
    }

    @XmlElement(name = "leeftijd")
    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd = leeftijd;
    }

    public Integer getAantal() {
        return aantal;
    }

    @XmlElement(name = "aantal")
    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    public String getJaartal() {
        return jaartal;
    }

    @XmlElement(name = "jaartal")
    public void setJaartal(String jaartal) {
        this.jaartal = jaartal;
    }

}
