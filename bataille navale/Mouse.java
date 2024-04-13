

import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Mouse implements MouseListener,MouseMotionListener {
	private int w=0,clique=0;
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
                  System.out.println("mouse pos X : " + evenement.getX());
              	  System.out.println("mouse pos Y : " + evenement.getY());
                //si la position  recupere et entre x et x  et y et y alors tu fait:
                //bouton0
              	  if(pan.page==0)
                if(x>=101 && x<=250 && y>=301 && y<=353){
                	//pan.state sera utilise comme variable quand je clique a cette position le resultat obtenu sera utilise dans panel.java
                	pan.page=1;
                  //pan.states avec un s va me permetre de ne pas rentres dans une boucle infini
            
              	
              	pan.removeAll();
                }
              	  if(pan.page==1)
                if(x>=102 && x<=252&& y>=393 && y<=439){
                if(!pan.lignes.getText().equals("") || !pan.colonnes.getText().equals("") && !pan.bateau.getText().equals("")){
                    //Si les valeurs ont bien ete renseignees on les recupere
                    int lignes=Integer.parseInt(pan.lignes.getText());
                    int colonnes=Integer.parseInt(pan.colonnes.getText());
                    int bateau=Integer.parseInt(pan.bateau.getText());
                    //Si les valeurs sont dans l'intervalle des valeurs possibles on les accepte
                    if(lignes>=2 && lignes<=10 && colonnes>=2  && colonnes<=10 && bateau<lignes*colonnes ) {
                      pan.largeur=lignes;
                      pan.hauteur=colonnes;
                      pan.nbbateauchoisi=bateau;
              		 
                  
                 }}
         
                pan.page=2;
               
                pan.removeAll();}
              	  
              	  if(pan.page==2) {
              		
              	int a=evenement.getX();
                int b=evenement.getY();
           a/=30;
           b/=30;
              	if(a>=0 &&a<pan.largeur && b>=0 && b<pan.hauteur){
              		if(w!=pan.nbbateauchoisi) {
              		pan.grillesposejoueur[a][b]=1;
              	
					if(pan.grillesposejoueur[a][b]==1)
              			w++;
              		pan.v=a;
              		pan.n=b;
              		pan.removeAll();
              	
              		}
              		}
              if(pan.page==2 && w==pan.nbbateauchoisi)
              		 if(x>=102 && x<=252&& y>=393 && y<=439){
              			 pan.page=3;
              
              		 }
              		  
              	  }
              	  
              	  
              	if(pan.page==3 && x>=101 && x<=250 && y>=301 && y<=353){
              		pan.page=4;
             
              	 }
              	if(pan.page==4) {
              		
              		int p=evenement.getX();
                    int q=evenement.getY();
                p/=30;
               q/=30;
               if(clique==0)
                  	if(p>=0 &&p<pan.largeur && q>=0 && q<pan.hauteur){
                  
                  		pan.grillesbonbjoueur[p][q]=1;
                  	
    					if(pan.grillesbonbjoueur[p][q]==1)
                  			
                  		pan.v=p;
                  		pan.n=q;
                  		clique=1;
                 
                  		
              	
              	
                  		
              	
              	
              	
              	
              	
                  	}
                  	}
                  	if(pan.page==4 && clique==1)
                  	 if(x>=102 && x<=252&& y>=393 && y<=439){
                  		 clique=0;
              			 pan.page=5;
              			
              			 
              		}
              
                  	if(pan.page==5 && clique==0)
                    	 if(x>=100 && x<=249&& y>=355 && y<=404){
                    		 pan.page=4;
                    		
                    	 }
                  	
              	  
                pan.repaint();
              }

                






@Override
public void mouseReleased(MouseEvent evenement) {
}
}
