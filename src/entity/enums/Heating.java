package entity.enums;

public enum Heating {
	TEC("���"),
	LOCAL_HEATING("������� ���������"),
	ELECTRIC_HEATING("�������������"),
	NO_HEATING("��� ���������");
	
	private String type;
	
	public String getType() {
		return this.type;
	}
	
	private Heating(String type) {
		this.type = type;
	}
}
