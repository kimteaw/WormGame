package operation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import element.Worm;
import operation.WormDirection.Direction;


public class InputKey extends KeyAdapter {
	
	
	interface InputMethod {
		void LeftKeyPressed();
		void RightKeyPressed();
		void UpKeyPressed();
		void DownKeyPressed();
	}
	
	private InputMethod im;
	public InputKey() {
	}
	

	private void Log(String str) {
		System.out.println(str);
	}

	
	//Ű�� ������ �� ȣ��Ǵ� �޼ҵ�
	@Override
	public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub

		super.keyPressed(e);
		
		int keyCode = e.getKeyCode();

		//Ű �Է��� �ѹ� �޾��� ��
		if(ManageElement.elementManager.wormDirection.getKeyPressed() == true) return;
		//�Էµ� Ű�� üũ�ؼ� ?
		switch (keyCode) {
		
		//Left Key�� ������ ��
		case KeyEvent.VK_LEFT:
			
			//�ݴ� ����Ű�� ���� ����Ű�� ������ ��
			if(ManageElement.elementManager.wormDirection.getDirection() == Direction.RIGHT || ManageElement.elementManager.wormDirection.getDirection() == Direction.LEFT) break;
			
			//ȥ�� �������� �԰� Ű�Է��� �ݴ�� �޴� �޼ҵ尡 true�� �� ��
			else if(ManageElement.elementManager.wormDirection.getisReverse() == true) {
				Log("Right Key");
				//Direction�� RIGHT �� ����
				ManageElement.elementManager.wormDirection.setDirection(Direction.RIGHT);
				//Ű�Է� ���θ� true�� ����
				ManageElement.elementManager.wormDirection.setKeyPressed(true);
				System.out.println(ManageElement.elementManager.wormDirection.getDirection());
				//im.LeftKeyPressed();
				break;
			}
			
			//�Ϲ����� ��Ȳ�� ��
			else {
				Log("Left Key");
				ManageElement.elementManager.wormDirection.setDirection(Direction.LEFT);
				ManageElement.elementManager.wormDirection.setKeyPressed(true);
				System.out.println(ManageElement.elementManager.wormDirection.getDirection());
				//im.LeftKeyPressed();
				break;
			}
			
		//Up Key�� ������ ��
		case KeyEvent.VK_UP:

			//�ݴ� ����Ű�� ���� ����Ű�� ������ ��
			if(ManageElement.elementManager.wormDirection.getDirection() == Direction.DOWN || ManageElement.elementManager.wormDirection.getDirection() == Direction.UP) break;
			
			//ȥ�� �������� �԰� Ű�Է��� �ݴ�� �޴� �޼ҵ尡 true�� �� ��
			else if(ManageElement.elementManager.wormDirection.getisReverse() == true) {
				Log("DOWN Key");
				ManageElement.elementManager.wormDirection.setDirection(Direction.DOWN);
				ManageElement.elementManager.wormDirection.setKeyPressed(true);
				System.out.println(ManageElement.elementManager.wormDirection.getDirection());
				//im.LeftKeyPressed();
				break;
			}

			//�Ϲ����� ��Ȳ�� ��
			else {
				Log("Up Key");
				ManageElement.elementManager.wormDirection.setDirection(Direction.UP);
				ManageElement.elementManager.wormDirection.setKeyPressed(true);
				System.out.println(ManageElement.elementManager.wormDirection.getDirection());
				//im.LeftKeyPressed();
				break;
			}
			
		//Right Key�� ������ ��	
		case KeyEvent.VK_RIGHT:

			//�ݴ� ����Ű�� ���� ����Ű�� ������ ��
			if(ManageElement.elementManager.wormDirection.getDirection() == Direction.LEFT || ManageElement.elementManager.wormDirection.getDirection() == Direction.RIGHT) break;
			
			//ȥ�� �������� �԰� Ű�Է��� �ݴ�� �޴� �޼ҵ尡 true�� �� ��
			else if(ManageElement.elementManager.wormDirection.getisReverse() == true) {
				Log("LEFT Key");
				ManageElement.elementManager.wormDirection.setDirection(Direction.LEFT);
				ManageElement.elementManager.wormDirection.setKeyPressed(true);
				System.out.println(ManageElement.elementManager.wormDirection.getDirection());
				//im.LeftKeyPressed();
				break;
			}

			//�Ϲ����� ��Ȳ�� ��
			else {
				Log("Right Key");
				ManageElement.elementManager.wormDirection.setDirection(Direction.RIGHT);
				ManageElement.elementManager.wormDirection.setKeyPressed(true);
				System.out.println(ManageElement.elementManager.wormDirection.getDirection());
				//im.LeftKeyPressed();
				break;
			}
			
		//Down Key�� ������ ��
		case KeyEvent.VK_DOWN:

			//�ݴ� ����Ű�� ���� ����Ű�� ������ ��
			if(ManageElement.elementManager.wormDirection.getDirection() == Direction.UP || ManageElement.elementManager.wormDirection.getDirection() == Direction.DOWN) break;
			
			//ȥ�� �������� �԰� Ű�Է��� �ݴ�� �޴� �޼ҵ尡 true�� �� ��
			else if(ManageElement.elementManager.wormDirection.getisReverse() == true) {
				Log("UP Key");
				ManageElement.elementManager.wormDirection.setDirection(Direction.UP);
				ManageElement.elementManager.wormDirection.setKeyPressed(true);
				System.out.println(ManageElement.elementManager.wormDirection.getDirection());
				//im.LeftKeyPressed();
				break;
			}

			//�Ϲ����� ��Ȳ�� ��
			else {
				Log("Down Key");
				ManageElement.elementManager.wormDirection.setDirection(Direction.DOWN);
				ManageElement.elementManager.wormDirection.setKeyPressed(true);
				System.out.println(ManageElement.elementManager.wormDirection.getDirection());
				//im.LeftKeyPressed();
				break;
			}
			
		default:
			break;
		}
	}
}
