

import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

public class Windows extends WindowAdapter {


	

		Windows()

		{
	


    JFrame f = new JFrame("Dessiner une ligne");
    f.addWindowListener(this);
    // Bloquer la taille de la fenêtre
        f.setResizable(false);
    f.setSize(400,500);
    Panel panneau = new Panel();
    panneau.setBounds(0, 0, 400, 500);
    
    
   Mouse souris = new Mouse(panneau);
    panneau.addMouseListener(souris);
    f.getContentPane().setLayout(null);
    f.getContentPane().add(panneau);
    
    


  
   
    
    f.setVisible(true);
  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
}
		public static void main(String[] args)

		{

		new Windows();

		}
}
