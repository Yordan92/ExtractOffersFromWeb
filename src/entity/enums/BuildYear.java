package entity.enums;

public enum BuildYear {
	AFTER_2016("���� 2006�."),
	BETWEEN_2000_2005("2000 - 2005�."),
	BETWEEN_1990_1999("1990 - 1999�."),
	BEFORE_1990("����� 1990�.");
	
	private String year;

	public String getYear() {
		return year;
	}

	private BuildYear(String year) {
		this.year = year;
	} 
	
}
