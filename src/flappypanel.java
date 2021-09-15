import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class flappypanel extends JPanel implements KeyListener,ActionListener{
	
	
	final int WIDTH=525,HEIGHT=550;
	int flappyheight=HEIGHT/4;
	int velcoity=0;
	int flappyV=0,flappyA=2;
	
	public flappypanel()
	{
		setSize(WIDTH,HEIGHT);
		setFocusable(true);
		addKeyListener(this);
		setBackground(Color.BLACK);
		new Timer(40,this).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		flappyV += flappyA;
				
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int code=e.getKeyCode();
		if(code==e.VK_SPACE)
		{
			if(flappyV-30 >= -133)
			        flappyV-=30;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawFlappy(g);
	}
	
	private void drawFlappy(Graphics g)
	{
		g.setColor(Color.WHITE);
		
		g.fillRect(150, flappyheight+flappyV, 25, 25);
	}

}
