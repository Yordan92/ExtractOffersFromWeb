package entity.enums;

public enum Heating {
	TEC("ТЕЦ"),
	LOCAL_HEATING("Локално отопление"),
	ELECTRIC_HEATING("Електричество"),
	NO_HEATING("Без отопление");
	
	private String type;
	
	public String getType() {
		return this.type;
	}
	
	private Heating(String type) {
		this.type = type;
	}
}
