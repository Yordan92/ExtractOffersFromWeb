package entity.enums;

public enum FlatType {
	ONE_ROOM("Едностаен"),
	TWO_ROOMS("Двустаен"),
	THREE_ROOMS("Тристаен"),
	FOUR_ROOMS("Четиристаен"),
	MANY_ROOMS("Многостаен"),
	MAISONETTE("Мезонет"),
	ROOM("Стая");
	
	private final String bgTranslate;
	
	public String getBgTranslate() {
		return bgTranslate;
	}

	private FlatType(String bgTranslate) {
		this.bgTranslate = bgTranslate;
	}
	

}
