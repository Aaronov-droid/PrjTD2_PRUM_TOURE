package metier;

import java.time.LocalDateTime;

public class Abonnement {
	private int id_abonnement;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin;
	private int id_client;
	private int id_revue;
	
	public Abonnement(int id_abonnement, LocalDateTime dateDebutAbo, LocalDateTime dateFinAbo, int id_client, int id_revue) {
		super();
		this.id_abonnement = id_abonnement;
		this.date_debut = dateDebutAbo;
		this.date_fin = dateFinAbo;
		this.id_client = id_client;
		this.id_revue = id_revue;
	}
	public LocalDateTime getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}
	public LocalDateTime getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getId_revue() {
		return id_revue;
	}
	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}
	@Override
	public String toString() {
		return "Abonnement [id_abonnement=" + id_abonnement + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", id_client=" + id_client + ", id_revue=" + id_revue + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_debut == null) ? 0 : date_debut.hashCode());
		result = prime * result + ((date_fin == null) ? 0 : date_fin.hashCode());
		result = prime * result + id_abonnement;
		result = prime * result + id_client;
		result = prime * result + id_revue;
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
		Abonnement other = (Abonnement) obj;
		if (date_debut == null) {
			if (other.date_debut != null)
				return false;
		} else if (!date_debut.equals(other.date_debut))
			return false;
		if (date_fin == null) {
			if (other.date_fin != null)
				return false;
		} else if (!date_fin.equals(other.date_fin))
			return false;
		if (id_abonnement != other.id_abonnement)
			return false;
		if (id_client != other.id_client)
			return false;
		if (id_revue != other.id_revue)
			return false;
		return true;
	}
	public void setId_abonnement(int i) {
		// TODO Auto-generated method stub
		
	}
	public int getId_abonnement() {
		// TODO Auto-generated method stub
		return 0;
	}
}
