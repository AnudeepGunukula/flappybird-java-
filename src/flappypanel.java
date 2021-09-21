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
	final int WALLVELOCITY=5;
	final int WALLWIDTH =50;
	int flappyheight=HEIGHT/4;
	int velcoity=0;
	double flappyV=0,flappyA=0,flappyI=1;
	boolean gameOver=false;
	
	
	int[] wallx= {WIDTH,WIDTH+WIDTH/2};
	int[] gap = {(int)(Math.random()*HEIGHT/1.5),(int)(Math.random()*HEIGHT)};
	
	
	
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
		flappyA += flappyI;
		flappyV += flappyA;
		wallx[0] -= WALLVELOCITY;
		wallx[1]-= WALLVELOCITY;
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int code=e.getKeyCode();
		if(code==e.VK_SPACE)
		{	
			flappyA = -9.5;
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
		
		if(!gameOver)
		{
			drawWall(g);
			logic();
			drawFlappy(g);
		}
		
	}
	
	private void drawFlappy(Graphics g)
	{
		g.setColor(Color.WHITE);
		
		g.fillRect(75, (int)(flappyheight+flappyV), 25, 25);
	}
	
	private void drawWall(Graphics g)
	{
		for(int i=0;i<2;i++)
		{
			g.setColor(Color.RED);
			g.fillRect(wallx[i], 0, WALLWIDTH, HEIGHT);
			
			
			g.setColor(Color.BLACK);
			g.fillRect(wallx[i], gap[i], WALLWIDTH, 125);
		}
		
	}
	
	private void logic()
	{
		for(int i=0;i<2;i++)
		{
			if(wallx[i]<=100 && wallx[i]+WALLWIDTH >= 100)
			{
				int flappyrange=(int) (flappyheight+flappyV);
				if(((flappyrange>=0) && (flappyrange<=gap[i])) || ((flappyrange+5>=gap[i]+100) && (flappyrange+25<=HEIGHT)))
	              {
		               gameOver=true;
	              }
			}
			
			if(wallx[i]+WALLWIDTH<=0)
			{
				wallx[i]=WIDTH;
				gap[i]=(int)(Math.random()*HEIGHT/1.5);
			}
		}
		
		
	}

}
