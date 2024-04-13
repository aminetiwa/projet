import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Dessin extends JComponent  {
  private JLabel titre=new JLabel();
   




    public static void dessinerBouton(Graphics g,String texte) {
        g.setColor(Color.white);
        g.fillRect(100, 300, 150, 50);
        g.setColor(Color.blue);
        g.drawRect(100, 300, 150, 50);
        g.drawString(texte, 155, 325);
    }
    //bouton1 pour page 1 et 2
  public static void dessinerBouton1(Graphics g,String texte) {
        g.setColor(Color.white);
         g.fillRect(100, 390, 150, 50);
           g.setColor(Color.blue);
         g.drawString(texte, 155, 415);
          g.drawRect(100, 390, 150, 50);
   
    }
    //bouton2 pour page 3
public static void dessinerBouton2(Graphics g,String texte) {
       g.setColor(Color.blue);
              
                g.drawRect(100, 390, 150, 50);

                 g.drawString(texte, 155, 415);
    }
   //bouton3 pour page 5
public static void dessinerBouton3(Graphics g,String texte) {
      
                            g.setColor(Color.white);
                            g.fillRect(100, 390, 150, 50);
                            g.setColor(Color.blue);
                            g.drawRect(100, 390, 150, 50);
                            g.drawString(texte, 155, 415);
                            g.setColor(Color.blue);
    }
  //bouton4 pour page 6
public static void dessinerBouton4(Graphics g,String texte) {
      
                            g.setColor(Color.white);
                             g.fillRect(100, 355, 150, 50);
                             g.setColor(Color.blue);
                             g.drawRect(100, 355, 150, 50);
                              g.drawString(texte, 155, 380);
                                g.setColor(Color.blue);    }

                                //dessine bateau
public static void dessinerBateau(Graphics g,int i,int j) {
      
                          // Affichez l'image du bateau a linterieur de la case verte
                  ImageIcon imageIcon = new ImageIcon("685775.png"); 
                Image image = imageIcon.getImage();
                  g.drawImage(image, i * 30, j * 30, 29, 29, null);
       
              }
                                      //dessine plouf
public static void dessinerPlouf(Graphics g,int i,int j) {
      
                          // Affichez l'image du bateau a linterieur de la case verte
                  ImageIcon imageIcon = new ImageIcon("4323660-200.png"); 
                Image image = imageIcon.getImage();
                  g.drawImage(image, i * 30, j * 30, 29, 29, null);
              }
public static void dessinerCaseBleu(Graphics g,int i,int j) {
      
                 g.setColor(Color.blue);
                                g.fillRect(i*30,j*30,29,29);
              }

public static void dessinerCaseRouge(Graphics g,int i,int j) {
      
                 g.setColor(Color.red);
                                g.fillRect(i*30,j*30,29,29);

      }
      public static void dessinerCaseGris(Graphics g,int i,int j) {
      
                 g.setColor(Color.GRAY);
                                g.fillRect(i*30,j*30,29,29);

      }
      public static void dessinerCaseVert(Graphics g,int i,int j) {
      
                 g.setColor(Color.green);
                                g.fillRect(i*30,j*30,29,29);

      }
       public static void dessinerIndication(Graphics g) {
       g.drawString("nombre ligne entre 2 et 10 :", 10, 45);
         g.drawString("nombre colonnes entre 2 et 10 :", 10, 145);
          g.drawString("nombre bateaux :", 10, 245);
}
 public static void dessinerTitre(Graphics g, JPanel panel) {
   JLabel titre = new JLabel("Bataille navale");
 Font e = new Font("Serif", Font.PLAIN | Font.ITALIC, 50);
         
    titre.setFont(e);
         
          //position du titre
          titre.setBounds(20,0,400,100);
          panel.add(titre);  
          //couleur du titre
          titre.setForeground(Color.blue);
          titre.setText("Bataille navale");
  
       ImageIcon imageIcon = new ImageIcon("685775.png"); 
                Image image = imageIcon.getImage();
                  g.drawImage(image, 8, 40, 300, 300, null);
}

  }