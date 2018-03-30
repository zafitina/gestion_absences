package istv.l3.absence.model;

import istv.l3.absence.enumeration.TypeCours;

public class Event {

	private int id;
	private String title;
	private String start;
	private String url;
	private String end;
	private String color;

	public Event() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getColor() {
		return color;
	}

	public String getColor(Seance seance) {
		if (seance.getTypeCours() == TypeCours.CM) {
			return "violet";
		}
		if (seance.getTypeCours() == TypeCours.TD) {
			return "blue";
		}
		return "green";
	}

	public void setColor(String color) {
		this.color = color;
	}
}
