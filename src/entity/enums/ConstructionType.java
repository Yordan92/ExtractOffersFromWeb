package entity.enums;

public enum ConstructionType {
	BRICK("Тухла"),
	BEAMS("Гредоред"),
	PANEL("Панел"),
	EPK("ЕПК");
	
	private String type;
	
	public String getType() {
		return this.type;
	}
	
	private ConstructionType(String type) {
		this.type = type;
	}
}
