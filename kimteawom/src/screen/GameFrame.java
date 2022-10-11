package screen;

import java.awt.*;
import javax.swing.*;
import operation.InputKey;

import operation.InputKey;

//���� ������ Ŭ����
public class GameFrame extends JFrame {
	
	/*���� ������ ������*/
	public GameFrame() throws HeadlessException {
		super();
		
		this.addKeyListener(new InputKey());
		this.setFocusable(true);//�������� ��Ŀ���� ���� �� �ֵ��� ����
		this.requestFocus(); //��Ŀ�� ����
	
		setTitle("�ڹٶ� ������");
		setSize(GameField.gamefield.returnFieldSize()+20, GameField.gamefield.returnFieldSize()+40); //������ ����
		setLocationRelativeTo(null); //ȭ�� �߾ӿ� â ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//â ������ ����
		setResizable(false); //â ũ�� ���� �Ұ�
		setVisible(true); //â�� ���̰� ����
	}
}
