package screen;
import java.awt.*;
import javax.swing.*;
import screen.*;
import element.*;
import element.block.TelpoBlock;
import operation.ManageElement;
import operation.WormEvent;

//게임 오버 패널 클래스
public class GameOver extends JPanel {
	
	int x=0;	
	boolean isGameOver = false;
	boolean isEnd =false;
	
	/*게임 오버 패널 생성자*/
	public GameOver() {
		ManageElement.elementManager.setisGameOver(true);
      //동작 확인
      System.out.println("게임 오버 생성");
      
      //게임 프레임 컨텐트팬을 게임오버 패널로 변경
      ((JFrame) GameField.gamefield.getTopLevelAncestor()).setContentPane(this);
      
      //게임 오버 그리기
      getParent().revalidate();
      getParent().repaint();
      
      //안쪽 내용 채우기
      Thread thread = new Thread(new Runnable() {

   	  	@Override
        public void run() {
           // TODO 자동 생성된 메소드 스텁
           // TODO 자동 생성된 메소드 스텁
            try {
	               
               for(int i=0;i<24;i++) {
                  Thread.sleep(100);
                  x++;
                  isGameOver= true;
                  revalidate();
                  repaint();
	                     
               }
            } catch (InterruptedException e) {
               // TODO 자동 생성된 catch 블록
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
	   

	   
   /*게임 오버 패널 메소드*/
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //동작 확인
      System.out.println("게임오버 페인트컴포넌트 실행");
      
      setBackground(Color.black);
      
      //결과창 내용물 출력부분
      if(isEnd) {
         g.setColor(Color.white);
         g.setFont(new Font("",Font.BOLD,30));
         g.drawString("수고하셨습니다.", (GameField.gamefield.elementNum/2)*11, (GameField.gamefield.elementNum)*11);
      }

	  //셔터 내려가는 효과
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
	      
      //테두리 사각형 그리기
      g.setColor(Color.white);
      for(int i = 0; i < GameField.gamefield.elementNum; i++) {
         for(int j = 0; j < GameField.gamefield.elementNum; j++) {
            if(i==0||j==0||i==GameField.gamefield.elementNum-1||j==GameField.gamefield.elementNum-1)
            g.fillRect(i*GameField.gamefield.elementSize, j*GameField.gamefield.elementSize, 15, 15);
         }
         
      }
 
   }
}
