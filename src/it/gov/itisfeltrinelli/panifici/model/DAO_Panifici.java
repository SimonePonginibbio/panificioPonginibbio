package it.gov.itisfeltrinelli.panifici.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DAO_Panifici {
	private Connection connection;

	private final String url;
	private final String user;
	private final String password;

	private Comparator<Panificio> sortPanifici = new Comparator<Panificio>() {

		@Override
		public int compare(Panificio o1, Panificio o2) {
			if (o1.getRegione().equalsIgnoreCase(o2.getRegione()))
				if (o1.getProvincia().equalsIgnoreCase(o2.getProvincia()))
					if (o1.getCitta().equalsIgnoreCase(o2.getCitta()))
						return o1.getPanetteria().compareToIgnoreCase(o2.getPanetteria());
					else
						return o1.getCitta().compareToIgnoreCase(o2.getCitta());
				else
					return o1.getProvincia().compareToIgnoreCase(o2.getProvincia());
			else
				return o1.getRegione().compareToIgnoreCase(o2.getRegione());
		}
	};

	private final String tabella = "panifici";

	private void connection() throws Exception {
		connection = DriverManager.getConnection(url, user, password);
	}

	private void disconnect() throws Exception {
		connection.close();
	}

	public DAO_Panifici(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public ArrayList<String> getALLProvincie() throws Exception {
		ArrayList<String> risultati = getALL("Provincia");
		return risultati;
	}

	public ArrayList<String> getALLCitta() throws Exception {
		ArrayList<String> risultati = getALL("Citta");
		return risultati;
	}

	private ArrayList<String> getALL(String colonna) throws Exception {
		ArrayList<String> risultati = new ArrayList<String>();
		connection();
		Statement statement = connection.createStatement();
		String sql = "SELECT DISTINCT " + colonna + " FROM " + tabella;
		ResultSet risultato = statement.executeQuery(sql);
		while (risultato.next())
			risultati.add(risultato.getString(colonna).toLowerCase());
		statement.close();
		disconnect();
		Collections.sort(risultati);
		return risultati;
	}

	public ArrayList<String> getProvincia(String citta) throws Exception {
		ArrayList<String> risultato = getInfo("Provincia", "Citta = '" + citta + "';");
		return risultato;
	}

	public ArrayList<String> getCitta(String provicia) throws Exception {
		ArrayList<String> risultato = getInfo("Citta", "Provincia = '" + provicia + "';");
		return risultato;
	}

	private ArrayList<String> getInfo(String colonna, String condizione) throws Exception {
		ArrayList<String> risultati = new ArrayList<String>();
		connection();
		Statement statement = connection.createStatement();
		String sql = "SELECT DISTINCT " + colonna + " FROM " + tabella + " WHERE " + condizione;
		ResultSet risultato = statement.executeQuery(sql);
		while (risultato.next())
			risultati.add(risultato.getString(colonna).toLowerCase());
		statement.close();
		disconnect();
		Collections.sort(risultati);
		return risultati;
	}

	public ArrayList<Panificio> getALLPanifici() throws Exception {
		ArrayList<Panificio> risultati = new ArrayList<Panificio>();
		connection();
		String sql = "SELECT Citta, Provincia, Regione, Panetteria FROM " + tabella;
		Statement statement = connection.createStatement();
		ResultSet risultato = statement.executeQuery(sql);
		while (risultato.next()) {
			Panificio nuovo = new Panificio();
			nuovo.setCitta(risultato.getString("Citta"));
			nuovo.setPanetteria(risultato.getString("Panetteria"));
			nuovo.setRegione(risultato.getString("Regione"));
			nuovo.setProvincia(risultato.getString("Provincia"));
			risultati.add(nuovo);
		}
		Collections.sort(risultati, sortPanifici);
		statement.close();
		disconnect();
		return risultati;
	}

	public ArrayList<Panificio> getPanificiPerCittà(String citta) throws Exception {
		ArrayList<Panificio> risultati = new ArrayList<Panificio>();
		connection();
		String sql = "SELECT Citta, Provincia, Regione, Panetteria FROM " + tabella + " WHERE Citta = '" + citta + "'";
		Statement statement = connection.createStatement();
		ResultSet risultato = statement.executeQuery(sql);
		while (risultato.next()) {
			Panificio nuovo = new Panificio();
			nuovo.setCitta(risultato.getString("Citta"));
			nuovo.setPanetteria(risultato.getString("Panetteria"));
			nuovo.setRegione(risultato.getString("Regione"));
			nuovo.setProvincia(risultato.getString("Provincia"));
			risultati.add(nuovo);
		}
		Collections.sort(risultati, sortPanifici);
		statement.close();
		disconnect();
		return risultati;
	}

	public ArrayList<Panificio> getPanificiPerProvincia(String provincia) throws Exception {
		ArrayList<Panificio> risultati = new ArrayList<Panificio>();
		connection();
		String sql = "SELECT Citta, Provincia, Regione, Panetteria FROM " + tabella + " WHERE Provincia = '" + provincia
				+ "'";
		Statement statement = connection.createStatement();
		ResultSet risultato = statement.executeQuery(sql);
		while (risultato.next()) {
			Panificio nuovo = new Panificio();
			nuovo.setCitta(risultato.getString("Citta"));
			nuovo.setPanetteria(risultato.getString("Panetteria"));
			nuovo.setRegione(risultato.getString("Regione"));
			nuovo.setProvincia(risultato.getString("Provincia"));
			risultati.add(nuovo);
		}
		Collections.sort(risultati, sortPanifici);
		statement.close();
		disconnect();
		return risultati;
	}

	public ArrayList<Panificio> getPanificiPerProvinciaECitta(String provincia, String citta) throws Exception {
		ArrayList<Panificio> risultati = new ArrayList<Panificio>();
		connection();
		String sql = "SELECT Citta, Provincia, Regione, Panetteria FROM " + tabella + " WHERE Provincia = '" + provincia
				+ "' AND Citta = '" + citta + "'";
		Statement statement = connection.createStatement();
		ResultSet risultato = statement.executeQuery(sql);
		while (risultato.next()) {
			Panificio nuovo = new Panificio();
			nuovo.setCitta(risultato.getString("Citta"));
			nuovo.setPanetteria(risultato.getString("Panetteria"));
			nuovo.setRegione(risultato.getString("Regione"));
			nuovo.setProvincia(risultato.getString("Provincia"));
			risultati.add(nuovo);
		}
		Collections.sort(risultati, sortPanifici);
		statement.close();
		disconnect();
		return risultati;
	}
}
