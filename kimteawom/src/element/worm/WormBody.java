package element.worm;

import java.awt.Color;
import element.Worm;
import operation.ManageElement;
import screen.GameOver;
public class WormBody extends Worm {
	   
	   public WormBody() {
	      super(1,1);
	      super.color = Color.green;

	      System.out.println("�����̹ٵ� �����");
	   }
	   public WormBody(int wormX, int wormY) {
	      super(wormX,wormY);


	      super.color = Color.GREEN;
	      // TODO Auto-generated constructor stub


	      /*�̻��� �߰� - ����*/
	      wormVector.add(this);
	      
	      //���� Ȯ��
	      System.out.println("�����̹ٵ� ������ ȣ��");
	   }
	   private void executeWormBody() {
		      //�����̰� �״´�.
		    new GameOver();

		   }
		@Override
		public void executeWorm() {
			// TODO �ڵ� ������ �޼ҵ� ����
			executeWormBody();
		}
	}