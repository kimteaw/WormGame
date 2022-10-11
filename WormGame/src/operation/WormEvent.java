package operation;

import javax.swing.event.*;

import element.Worm;
import element.block.TelpoBlock;
import element.worm.WormBody;
import element.worm.WormHead;
import screen.*;

public class WormEvent extends Thread {
	
	//지렁이 이동속도 (1000은 임시)
	int wormSpeed = 150;

	WormDirection wormDirection = ManageElement.elementManager.wormDirection;
	
	public WormEvent() {
	}
	
	@Override
	public void run() {

		while(true) {
			try {
				Thread.sleep(wormSpeed);
				if(wormDirection.getIsMove() == true) {
					switch(wormDirection.getDirection()) {
					//오른쪽 : x+1, y
					case RIGHT: 
						ManageElement.elementManager.checkMove(+1, 0);
						ManageElement.elementManager.moveWorm(+1, 0);
						System.out.println(wormDirection.getDirection() + "호출"); 
						break;
					//왼쪽 : x-1, y
					case LEFT: 
						ManageElement.elementManager.checkMove(-1, 0);
						ManageElement.elementManager.moveWorm(-1, 0);
						System.out.println(wormDirection.getDirection() + "호출"); 
						break;
					//위쪽 : x, y+1
					case UP:
						ManageElement.elementManager.checkMove(0, -1);
						ManageElement.elementManager.moveWorm(0, -1);
						System.out.println(wormDirection.getDirection() + "호출"); 
						break;
					//아래쪽 : x, y-1
					case DOWN:
						ManageElement.elementManager.checkMove(0, +1);						
						ManageElement.elementManager.moveWorm(0, +1);
						System.out.println(wormDirection.getDirection() + "호출"); 
						break;
					}
				}
				else {
					System.out.println(wormDirection.getIsMove());
				}
				wormDirection.setKeyPressed(false);
				wormDirection.setIsMove(true);
				if( ManageElement.elementManager.returnisGameOver()) {
					break;
				}
			}
			catch(InterruptedException e) {return;}
		}
	}
	
	
	//지렁이 이동속도 return 메소드
	public int getWormSpeed() {
		return wormSpeed;
	}
	
	//지렁이 이동속도 설정 메소드
	public void setWormSpeed(int i) {
		wormSpeed += i;
	}
	
}
