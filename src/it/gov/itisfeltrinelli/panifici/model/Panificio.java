package it.gov.itisfeltrinelli.panifici.model;

public class Panificio {
	
	private String regione;
	private String provincia;
	private String citta;
	private String panetteria;
	
	@Override
	public String toString() {
		return "PanificiBean [regione=" + regione + ", provincia=" + provincia + ", citta=" + citta + ", panetteria="
				+ panetteria + "]";
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getPanetteria() {
		return panetteria;
	}
	public void setPanetteria(String panetteria) {
		this.panetteria = panetteria;
	}
	

}
