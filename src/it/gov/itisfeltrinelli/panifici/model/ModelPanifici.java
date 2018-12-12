package it.gov.itisfeltrinelli.panifici.model;

import java.util.ArrayList;

public class ModelPanifici {
	private DAO_Panifici database;

	public void setDatabase(DAO_Panifici database) {
		this.database = database;
	}

	public ArrayList<String> getProvincie() {
		ArrayList<String> provincie = new ArrayList<String>();
		try {
			provincie = database.getALLProvincie();
		} catch (Exception e) {
			e.printStackTrace();
		}
		provincie.add(0, "tutte");
		return provincie;
	}

	public ArrayList<String> getCitta() {
		ArrayList<String> citta = new ArrayList<String>();
		try {
			citta = database.getALLCitta();
		} catch (Exception e) {
			e.printStackTrace();
		}
		citta.add(0, "tutte");
		return citta;
	}

	public ArrayList<String> getCitta(String provicia) {
		ArrayList<String> citta = new ArrayList<String>();
		try {
			citta = database.getCitta(provicia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		citta.add(0, "tutte");
		return citta;
	}

	public ArrayList<Panificio> getALLPanifici() {
		ArrayList<Panificio> panifici = new ArrayList<Panificio>();
		try {
			panifici = database.getALLPanifici();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panifici;
	}

	public ArrayList<Panificio> getPanificiPerCittà(String citta) {
		ArrayList<Panificio> panifici = new ArrayList<Panificio>();
		try {
			panifici = database.getPanificiPerCittà(citta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panifici;
	}

	public ArrayList<Panificio> getPanificiPerProvincia(String provincia) {
		ArrayList<Panificio> panifici = new ArrayList<Panificio>();
		try {
			panifici = database.getPanificiPerProvincia(provincia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panifici;
	}

	public ArrayList<Panificio> getPanificiPerProvinciaECittà(String provincia, String citta) {
		ArrayList<Panificio> panifici = new ArrayList<Panificio>();
		try {
			panifici = database.getPanificiPerProvinciaECitta(provincia, citta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panifici;
	}

	public ArrayList<String> getProvincia(String citta) {
		ArrayList<String> provicie = new ArrayList<String>();
		try {
			provicie = database.getProvincia(citta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return provicie;
	}
}
