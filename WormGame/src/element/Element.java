package element;

import java.awt.*;
import screen.*;

//��� �߻� Ŭ����
public abstract class Element {
		
	/*��� Ŭ���� �ʵ�*/
	protected int elementX; //����� X��ǥ
	protected int elementY; //����� Y��ǥ
	protected Color color; //��Ҹ��� �����ִ� ���� ����
	
	/*��� Ŭ���� ������*/
	public Element(int elementX, int elementY) {
		this.elementX = elementX;
		this.elementY = elementY;
		
		//���� Ȯ��
		System.out.println("element ������ �۵�");
	}
	
	/*��� Ŭ���� �޼ҵ�*/
	//����� X��ǥ ����
	public int returnX() {
		return this.elementX;
	}
	//����� Y��ǥ ����
	public int returnY() {
		return this.elementY;
	}
	//����� ���� ������ �����ϴ� �޼ҵ�
	public Color returnColor() {
		return this.color;
	}
	//����� ��ǥ���� �����ϴ� �޼ҵ�
	public void setXY(int x, int y) {
	      this.elementX = x;
	      this.elementY =y;
	}

	abstract public void executeElement();
}
