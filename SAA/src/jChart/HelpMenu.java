package jChart;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HelpMenu implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_F1){
			help();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	public static void help(){
		Display.panel.setVisible(false);
		Display.viewPanel.setVisible(false);
		Display.helpPanel.setVisible(true);
	}
}
