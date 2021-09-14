import javax.swing.JFrame;

public class flappy extends JFrame {
	
	 public flappy()
	 {
		 setTitle("Flappy Bird Game");
		 add(new flappypanel());
		 setSize(500,500);
		 setVisible(true);
		 setResizable(false);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	
	 public static void main(String[] args)
	 {
		 new flappy();
	 }
}