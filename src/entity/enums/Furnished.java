package entity.enums;

public enum Furnished {
	FURNISHED("Обзаведен"),
	SEMI_FURNISHED("Полуобзаведен"),
	NOT_FURNISHED("Необзаведен");
	
	private String state;

	public String getState() {
		return state;
	}
	
	private Furnished(String state) {
		this.state = state;
	}
	
	

}
