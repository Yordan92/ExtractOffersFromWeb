package entity.enums;

public enum ConstructionType {
	BRICK("�����"),
	BEAMS("��������"),
	PANEL("�����"),
	EPK("���");
	
	private String type;
	
	public String getType() {
		return this.type;
	}
	
	private ConstructionType(String type) {
		this.type = type;
	}
}
