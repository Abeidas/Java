package aufgabec;

public class Serie {
	private String serieName;
	private String directorLastName;
	private String directorFirstName;
	private enum GENRE {
		Action, Comedy, Thriller, Adventure
	};
	private GENRE genre;
	public String getName() {
		return serieName;
	}

	public String getFilmsName() {
		return serieName;
	}

	public GENRE getGenre() {
		return genre;
	}

	public void serieFilmsName(String serieName) {
		this.serieName = serieName;
	}

	public void setGenre(GENRE genre) {
		this.genre = genre;
	}

	public String getDirectorLastName() {
		return directorLastName;
	}

	public String getDirectorFirstName() {
		return directorFirstName;
	}

	public void setName(String name) {
		this.serieName = name;
	}

	public void setDirectorLastName(String directorLastName) {
		this.directorLastName = directorLastName;
	}

	public void setDirectorFirstName(String directorFirstName) {
		this.directorFirstName = directorFirstName;
	}

	public Serie(String serieName) {
		this.serieName = serieName;
	}
}
