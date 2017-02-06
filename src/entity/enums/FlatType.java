package entity.enums;

public enum FlatType {
	ONE_ROOM("���������"),
	TWO_ROOMS("��������"),
	THREE_ROOMS("��������"),
	FOUR_ROOMS("�����������"),
	MANY_ROOMS("����������"),
	MAISONETTE("�������"),
	ROOM("����");
	
	private final String bgTranslate;
	
	public String getBgTranslate() {
		return bgTranslate;
	}

	private FlatType(String bgTranslate) {
		this.bgTranslate = bgTranslate;
	}
	

}
