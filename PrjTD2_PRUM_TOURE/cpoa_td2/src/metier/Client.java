package metier;


public class Client {
	
	protected String code_postal;
	protected int id_client;
	protected String nom;
	protected String no_rue;
	protected String pays;
	protected String prenom;
	protected String Ville;
	protected String Voie;
	
	public Client(String code_postal, int id_client, String nom, String no_rue, String pays, String prenom, String ville,
			String voie) {
		super();
		this.code_postal = code_postal;
		this.id_client = id_client;
		this.nom = nom;
		this.no_rue = no_rue;
		this.pays = pays;
		this.prenom = prenom;
		Ville = ville;
		Voie = voie;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNo_rue() {
		return no_rue;
	}

	public void setNo_rue(String no_rue) {
		this.no_rue = no_rue;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getVoie() {
		return Voie;
	}

	public void setVoie(String voie) {
		Voie = voie;
	}

	@Override
	public String toString() {
		return "Client [code_postal=" + code_postal + ", id_client=" + id_client + ", nom=" + nom + ", no_rue=" + no_rue
				+ ", pays=" + pays + ", prenom=" + prenom + ", Ville=" + Ville + ", Voie=" + Voie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ville == null) ? 0 : Ville.hashCode());
		result = prime * result + ((Voie == null) ? 0 : Voie.hashCode());
		result = prime * result + ((code_postal == null) ? 0 : code_postal.hashCode());
		result = prime * result + id_client;
		result = prime * result + ((no_rue == null) ? 0 : no_rue.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (Ville == null) {
			if (other.Ville != null)
				return false;
		} else if (!Ville.equals(other.Ville))
			return false;
		if (Voie == null) {
			if (other.Voie != null)
				return false;
		} else if (!Voie.equals(other.Voie))
			return false;
		if (code_postal == null) {
			if (other.code_postal != null)
				return false;
		} else if (!code_postal.equals(other.code_postal))
			return false;
		if (id_client != other.id_client)
			return false;
		if (no_rue == null) {
			if (other.no_rue != null)
				return false;
		} else if (!no_rue.equals(other.no_rue))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	
	
	

}
