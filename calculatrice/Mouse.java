package calculatrice;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import java.awt.event.*;





public class Mouse implements MouseListener,MouseMotionListener {
	private int i=1; 
   public Panel pan;
              public  Mouse(Panel panneau) {
                this.pan=panneau;
              }
     

			@Override
              public void mouseClicked(MouseEvent evenement) {
              }
              @Override
              public void mouseDragged(MouseEvent evenement) {

              }
              @Override
              public void mouseEntered(MouseEvent evenement) {

              }
              @Override
              public void mouseExited(MouseEvent evenement) {

              }
              @Override
              public void mouseMoved(MouseEvent evenement) {
              }
              @Override
              public void mousePressed(MouseEvent evenement) {
                //declaration de variable pour recupere la position 
                int x=evenement.getX();
                  int y=evenement.getY();
                 //affiche la position de la la souris (clique droit)
                  
                //si la position  recupere et entre x et x  et y et y alors tu fait:
                //bouton0
                if(x>=12 && x<=63 && y>=403 && y<=447){
                	//pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                	pan.state=1;
                  //pan.states avec un s va me permetre de ne pas rentres dans une boucle infini
              	 pan.states = 1;
	    	      
              
                }
             	  //si la position position recupere et entre x et x  et y et y alors tu fait:
                //bouton1
                if(x>=66 && x<=116 && y>=403 && y<=452){
                  //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                	pan.state=2;
            pan.states=1;
              
                }
               //si la position position recupere et entre x et x  et y et y alors tu fait: 
              //bouton2
                if(x>=121 && x<=171 && y>=403 && y<=452){
                  //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                	pan.state=3;
                  pan.states=1;
                }
                //si la position position recupere et entre x et x  et y et y alors tu fait:
              //bouton3
                if(x>=177 && x<=222 && y>=403 && y<=452){
                	//pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=4;

                  pan.states=1;
              
                }
                
                
                //si la position position recupere et entre x et x  et y et y alors tu fait:
              //bouton=
                if(x>=230 && x<=379 && y>=405 && y<=452){
                	//pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=5;
                  pan.states=1;
              
                }
                //si la position position recupere et entre x et x  et y et y alors tu fait:
                //bouton4
                if(x>=12&& x<=59 && y>=358 && y<=400){
                  //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=6;
                  pan.states=1;
              
                }
                //si la position position recupere et entre x et x  et y et y alors tu fait:
                 //bouton5
                if(x>=66&& x<=116&& y>=358 && y<=400){
                 //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=7;
                  pan.states=1;
              
                }
                  //si la position position recupere et entre x et x  et y et y alors tu fait:
                 //bouton6
                if(x>=121&& x<=171&& y>=358 && y<=400){
                 //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=8;
                  pan.states=1;
              
                }
                  //si la position position recupere et entre x et x  et y et y alors tu fait:
                 //bouton7
                if(x>=177&& x<=222&& y>=358 && y<=400){
                 //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=9;
                  pan.states=1;
              
                }
                //si la position position recupere et entre x et x  et y et y alors tu fait:
                  //bouton8
                if(x>=12&& x<=59&& y>=302 && y<=351){
                  //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=10;
                  pan.states=1;
              
                }

                  //bouton9
                if(x>=66&& x<=116&& y>=302 && y<=351){
                 //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=11;
                  pan.states=1;
              
                }
                //si la position position recupere et entre x et x  et y et y alors tu fait:
                //bouton+
                if(x>=230 && x<=379 && y>=358 && y<=400){
                  //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=12;
                  pan.states=1;
                  
                 
                 }
                 //si la position position recupere et entre x et x  et y et y alors tu fait:
                  //bouton-
                if(x>=230 && x<=379 && y>=302 && y<=351){
                 //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=13;
                  pan.states=1;}
                  //si la position position recupere et entre x et x  et y et y alors tu fait:
                  //boutonX
                if(x>=230 && x<=379 && y>=246 && y<=302){
                 //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=14;  
                  pan.states=1;}
                  //si la position position recupere et entre x et x  et y et y alors tu fait:
                  //bouton/
                if(x>=230 && x<=379 && y>=190 && y<=253){
                 //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                  pan.state=15; 
                  pan.states=1;}
                
                if(x>=119 && x<=220 && y>=300 && y<=349){
                    //pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                     pan.state=16; 
                     pan.states=1;
                    
                     }

                pan.repaint();
              }


			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
}