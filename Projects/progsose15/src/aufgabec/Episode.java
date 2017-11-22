package aufgabec;

public class Episode {
	private Season season;
	private String episodeName;
	private short episodeNumber;
	private short dayOfProduction;
	private short monthOfProduction;
	private short yearOfProduction;
	public Episode(Season season, short episodeNumber) {
		this.season = season;
		this.episodeNumber = episodeNumber;
	}
	private String Date = dayOfProduction + "/" + monthOfProduction + "/" + yearOfProduction;
	private String firstNameOfProducer;
	private String lastNameOfProducer;
	private String producersName = firstNameOfProducer + " " + lastNameOfProducer;
	public Season getSeason() {
		return season;
	}
	public String getEpisodeName() {
		return episodeName;
	}
	public short getEpisodeNumber() {
		return episodeNumber;
	}
	public short getDayOfProduction() {
		return dayOfProduction;
	}
	public String getDate() {
		return Date;
	}
	public String getProducersName() {
		return producersName;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}
	public void setEpisodeNumber(short episodeNumber) {
		this.episodeNumber = episodeNumber;
	}
	public void setDayOfProduction(short dayOfProduction) {
		this.dayOfProduction = dayOfProduction;
	}
	public void setDate(String date) {
		Date = date;
	}
	public void setProducersName(String producersName) {
		this.producersName = producersName;
	}
	
}
