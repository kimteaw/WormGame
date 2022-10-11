package element;

public abstract class Item extends Element {

	/*아이템 클래스 생성자*/
	public Item(int elementX, int elementY) {
		super(elementX, elementY);
		// TODO Auto-generated constructor stub
		
		//동작 확인
		System.out.println("아이템 생성자 호출");
	}

	@Override
	public void executeElement() {
		// TODO 자동 생성된 메소드 스텁
		executeItem();
	}
	abstract public void executeItem();
}
