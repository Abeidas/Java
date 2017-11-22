package aufgabec;

public class Season {
	private Serie serie;
	private String seasonName;
	private short seasonNumber;
	public Serie getSerie() {
		return serie;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public short getSeasonNumber() {
		return seasonNumber;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	public void setSeasonNumber(short seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	public Season(Serie serie, short seasonNumber) {
		this.serie = serie;
		this.seasonNumber = seasonNumber;
	}
	
}
