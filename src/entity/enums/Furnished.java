package entity.enums;

public enum Furnished {
	FURNISHED("���������"),
	SEMI_FURNISHED("�������������"),
	NOT_FURNISHED("�����������");
	
	private String state;

	public String getState() {
		return state;
	}
	
	private Furnished(String state) {
		this.state = state;
	}
	
	

}
