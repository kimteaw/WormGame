package screen;

import java.awt.Color;
import java.util.*;
import javax.swing.JPanel;
import element.*;
import element.item.GoodItem;

//���� �ʵ� �г� Ŭ����
public class GameField extends JPanel {
	
	//���α׷� ���� �� ���� �ʵ� ��ü ����, ���� �߰� ���� �Ұ� 
	public static final GameField gamefield = new GameField(); 
	
	/*���� �ʵ� �ʵ�*/
	public final int elementNum = 24; //����� ����
	public final int elementSize = 20; //����� ũ��
	
	private HashMap<Locate, Element> elementMap = new HashMap<>(); //��ǥ�� ��Ҹ� �����ϴ� �ؽø� 
	private HashMap<Locate, ElementPanel> panelMap = new HashMap<>(); //��ǥ�� ����г��� �����ϴ� �ؽø� 

	
	/*���� �ʵ� ������*/
	private GameField() {
		//��ġ ������ ����
		this.setLayout(null);
		//���� �ʵ��� ũ��� ��ġ
		this.setBounds(0, 0, returnFieldSize(), returnFieldSize());
		//���� Ȯ��
		System.out.println("gamefield ��ü ����");
	}
	
	/*���� �ʵ� �޼ҵ�*/
	
	//���� �ʵ� ũ�⸦ �������ִ� �޼ҵ�
	public int returnFieldSize() {
		return elementNum*elementSize;
	}
	
	//�ʵ带 �ʱ�ȭ�ϴ� �޼ҵ�
	public void initField() {
		//��ǥ : (0~23, 0~23)
		for(int x = 0; x < elementNum; x++) {
			for(int y = 0; y < elementNum; y++) {
				//�ؽø� Ű: Locate(��ǥ) ��ü ���������� ���� �� ���� 
				elementMap.put(new Locate(x, y), null); //��Ҹ� ��: null
				panelMap.put(new Locate(x, y), new ElementPanel(x, y)); //�гθ� ��: �� �г�
			}
		}
		
		//���� �ʵ� �ٽ� �׸���
		revalidate();
		repaint();
		
		//���� ���� - ����
		setBackground(Color.BLACK);
	}
	
	//�ش� ��ǥ�� ����ִ� element�� �������ִ� �޼ҵ�
	public Element checkElement(int checkX, int checkY) {
		//�ش� ��ǥ�� ��ġ�ϴ� ��ǥ Ű ���� ����ִ� element�� ������ null ����
		return elementMap.get(new Locate(checkX, checkY));
	}
	
	//������ element�� �޾Ƽ� �ؽøʿ� �����ϴ� �޼ҵ�
	public void setElement(Element element) {		
		Locate locate = new Locate(element.returnX(), element.returnY());
		
		//��Ҹʿ� ��� ����ֱ�
		elementMap.replace(locate, element);
		
		//�г� ���� ȣ��
		setPanel(locate, element);
		
		//���� Ȯ��
		System.out.println("�ؽøʿ� ��� set");
	}
	
	//element ���� �޼ҵ�
	public void removeElement(int elementX, int elementY) {
		Locate locate = new Locate(elementX, elementY);
		
		//��Ҹʿ� null �ֱ�
		elementMap.replace(locate, null);

		//�г� ���� ȣ�� - null
		setPanel(locate, null);
	}
	
	//�ش� ��ǥ�� ����ִ� panel�� �����ϴ� �޼ҵ� - ��� ���� �� ���� �� ȣ��
	private void setPanel(Locate locate, Element element) {
		panelMap.get(locate).inputElement(element);
	}
}

//��ǥ Ű Ŭ����
class Locate {
	
	/*��ǥ Ŭ���� �ʵ�*/
	private int X; //X��ǥ, Y��ǥ
	private int Y;
	
	
	/*��ǥ Ŭ���� ������*/
	public Locate(int x, int y) {
		this.X = x;
		this.Y = y;
	}
	
	/*��ǥ Ŭ���� �޼ҵ�*/
	public int returnX() {
		return this.X;
	}
	public int returnY() {
		return this.Y;
	}
	
	
	/*�������̵�*/
	//equals �������̵�
	@Override
	public boolean equals(Object object) {
		Locate locateObject = (Locate) object;
		System.out.print(locateObject);
		if (this.X == locateObject.X && this.Y == locateObject.Y)
			return true;
		else
			return false;
	}
	
	//�ؽ��ڵ� �������̵�
	@Override
	public int hashCode() {
		return Objects.hash(X, Y);
	}
}

