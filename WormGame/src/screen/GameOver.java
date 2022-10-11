package screen;
import java.awt.*;
import javax.swing.*;
import screen.*;
import element.*;
import element.block.TelpoBlock;
import operation.ManageElement;
import operation.WormEvent;

//���� ���� �г� Ŭ����
public class GameOver extends JPanel {
	
	int x=0;	
	boolean isGameOver = false;
	boolean isEnd =false;
	
	/*���� ���� �г� ������*/
	public GameOver() {
		ManageElement.elementManager.setisGameOver(true);
      //���� Ȯ��
      System.out.println("���� ���� ����");
      
      //���� ������ ����Ʈ���� ���ӿ��� �гη� ����
      ((JFrame) GameField.gamefield.getTopLevelAncestor()).setContentPane(this);
      
      //���� ���� �׸���
      getParent().revalidate();
      getParent().repaint();
      
      //���� ���� ä���
      Thread thread = new Thread(new Runnable() {

   	  	@Override
        public void run() {
           // TODO �ڵ� ������ �޼ҵ� ����
           // TODO �ڵ� ������ �޼ҵ� ����
            try {
	               
               for(int i=0;i<24;i++) {
                  Thread.sleep(100);
                  x++;
                  isGameOver= true;
                  revalidate();
                  repaint();
	                     
               }
            } catch (InterruptedException e) {
               // TODO �ڵ� ������ catch ���
               e.printStackTrace();
            }
            finally {
               isEnd =true;
               repaint();
            };
         }
      
      });
      thread.start();
  }
	   

	   
   /*���� ���� �г� �޼ҵ�*/
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //���� Ȯ��
      System.out.println("���ӿ��� ����Ʈ������Ʈ ����");
      
      setBackground(Color.black);
      
      //���â ���빰 ��ºκ�
      if(isEnd) {
         g.setColor(Color.white);
         g.setFont(new Font("",Font.BOLD,30));
         g.drawString("�����ϼ̽��ϴ�.", (GameField.gamefield.elementNum/2)*11, (GameField.gamefield.elementNum)*11);
      }

	  //���� �������� ȿ��
      else if(this.isGameOver) {
         for(int i=0;i<GameField.gamefield.elementNum-1;i++) {
              for(int j=0;j<=x;j++) {
                 if(i==0||j==0||i==GameField.gamefield.elementNum||j==GameField.gamefield.elementNum) {
                    continue;
                  }
                  if(x<9) {
                     g.setColor(Color.white);
                     g.setFont(new Font("",Font.BOLD,30));
                     g.drawString("GAME OVER!",(GameField.gamefield.elementNum/2+1)*11, (GameField.gamefield.elementNum)*11);
                  }
                  
                  g.setColor(Color.gray);
                  g.fillRect(20*i, j*20, 15, 15);
              }
         }
      }
	      
      //�׵θ� �簢�� �׸���
      g.setColor(Color.white);
      for(int i = 0; i < GameField.gamefield.elementNum; i++) {
         for(int j = 0; j < GameField.gamefield.elementNum; j++) {
            if(i==0||j==0||i==GameField.gamefield.elementNum-1||j==GameField.gamefield.elementNum-1)
            g.fillRect(i*GameField.gamefield.elementSize, j*GameField.gamefield.elementSize, 15, 15);
         }
         
      }
 
   }
}
