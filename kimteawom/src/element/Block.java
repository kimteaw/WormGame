package element;

public abstract class Block extends Element {
	
	/*��� Ŭ���� ������*/
	public Block(int blockX, int blockY) {
		super(blockX, blockY);
		
		//���� Ȯ��
		System.out.println("��� ������ ȣ��");
	}
	
	/*��� Ŭ���� �߻� �޼ҵ�*/
	//����� ����� �۵� ��Ű�� �߻� �޼ҵ�
	@Override
	public void executeElement() {
		// TODO �ڵ� ������ �޼ҵ� ����
		executeBlock();
	}
	abstract public void executeBlock();
}