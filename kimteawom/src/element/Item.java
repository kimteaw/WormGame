package element;

public abstract class Item extends Element {

	/*������ Ŭ���� ������*/
	public Item(int elementX, int elementY) {
		super(elementX, elementY);
		// TODO Auto-generated constructor stub
		
		//���� Ȯ��
		System.out.println("������ ������ ȣ��");
	}

	@Override
	public void executeElement() {
		// TODO �ڵ� ������ �޼ҵ� ����
		executeItem();
	}
	abstract public void executeItem();
}
