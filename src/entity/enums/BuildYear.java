package entity.enums;

public enum BuildYear {
	AFTER_2016("след 2006г."),
	BETWEEN_2000_2005("2000 - 2005г."),
	BETWEEN_1990_1999("1990 - 1999г."),
	BEFORE_1990("преди 1990г.");
	
	private String year;

	public String getYear() {
		return year;
	}

	private BuildYear(String year) {
		this.year = year;
	} 
	
}
