


import javax.swing.*;
import java.awt.*;
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JTextField;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Panel  extends JComponent
{
	
	
	private static final long serialVersionUID = 1L;


	public Panel() {
		
	}




	
	public Panel pans;
	public int page=0;
	private int w=0;
	private int compteurs=0;
	

	public JTextField lignes=new JTextField();
	public JTextField colonnes=new JTextField();
	public JTextField bateau=new JTextField();
	public int largeur,hauteur,nbbateauchoisi;
	public int grillesposejoueur[][] = new int[10][10];
	public int grillesbonbjoueur[][] = new int[10][10];
	public int grillesbonbordi[][] = new int[10][10];
	public int grillesposeordi[][] = new int[10][10];
	public int v,n,res=0;
	private JLabel titre=new JLabel();
	
	//creation methodes text pour inseret le nombre colonnes, lignes, bateaux  
	private void text() {
	
	   Font f = new Font("Serif", Font.PLAIN, 60);
	   
	    lignes.setFont(f);
	    lignes.setBounds(10,50,180,50);
	    this.add(lignes);    
	    
	    colonnes.setFont(f);
	    colonnes.setBounds(10,150,180,50);
	    this.add(colonnes);   
	    
	    bateau.setFont(f);
	    bateau.setBounds(10,250,180,50);
	    this.add(bateau);   
	    
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	
	public void paintComponent(Graphics g) {
	
		this.setLayout(null);
		//methode pour dessine le fond blanc avec les carre
		  Fond.dessinerFondBlanc(g);

		  
		  
		  //page menu principale
		  if(page==0) {
		  	 Dessin.dessinerBouton(g, "Jouer");
			
			//affiche le titre du jeu
			   JLabel titre = new JLabel("Bataille navale");
 Font e = new Font("Serif", Font.PLAIN | Font.ITALIC, 50);
         
    titre.setFont(e);
         
          //position du titre
          titre.setBounds(20,0,400,100);
          this.add(titre);  
          //couleur du titre
          titre.setForeground(Color.blue);
          titre.setText("Bataille navale");
  
       ImageIcon imageIcon = new ImageIcon("685775.png"); 
                Image image = imageIcon.getImage();
                  g.drawImage(image, 8, 40, 300, 300, null);
			    //methode dessin pour bouton jouer
			  
          
       
		  }
		  
		   
		  
		  
		  
		  
		  //page menu choix taille 
	if(page==1) {
 this.removeAll();
		//apelle de la methode text pour saisir les valeur 
		 text();
	
		//bouton jouer
				//methode dessin pour bouton jouer
			   
            Dessin.dessinerBouton1(g, "Jouer");
		  //ecrit indication
		 Dessin.dessinerIndication(g);

	}


	
	
	
	
	
	//page jeu position bateau joueur
	if(page==2) {
		
	
		
		 
		  g.setColor(this.getBackground());
		  g.fillRect(0, 0, this.getWidth(), this.getHeight());
		  int nbbateau=0;
		 

		  g.drawString(Integer.toString(nbbateau), 100,340);
		 //methode pour dessine le fond blanc avec les carre
		  Fond.dessinerFondBlanc(g);
		  //cette boucle va permettre de positionez les bateau 
		  for(int i=0; i<largeur; i++){
		    for(int j=0; j<hauteur; j++) {
		    	//met la position =1
		    	if(grillesposejoueur[i][j]==1){
		    		//si le tableau i,j est = 1 colorie la position  en vert
		       
		        Dessin.dessinerCaseVert(g, i, j);
		        //affiche le bouton jouer 
		        //bouton jouer
				//methode dessin pour bouton jouer
			   
           		 Dessin.dessinerBouton2(g, "Jouer");
				 // Affichez l'image du bateau a linterieur de la case verte
				  Dessin.dessinerBateau(g, i, j);
		      }
		      //sinon si cest = 0 en gris
		      
		      if(grillesposejoueur[i][j]==0)
		      {
		    	  
		         Dessin.dessinerCaseGris(g, i, j);

		    
		      }
		      //indication en bleu
		      g.setColor(Color.blue);
		      g.drawString("positionez vos bateaux !!!", 100, 350);
		      }
		  }}
	
	
	
	
	
	
	
			//page position bateaux ordi
		    if(page==3) {
		    	//tant que w nest pas egale au nombre de bateau repeter
		    	while(w!=Integer.parseInt(bateau.getText())) {
		    		//ajoute 1 a w
		    		w++;
		    		System.out.println(w);
		    	 
		    	System.out.println("ordi a positionez ces bateau");
		    	//choisi un nombre aleatoire 
		    	 Random ran=new Random();
		         int x=ran.nextInt(largeur);
		         int y=ran.nextInt(hauteur);
		         //si la possition du tableau = 0 alors elle devient 1
		         if(grillesposeordi[x][y]==0)
		        	 grillesposeordi[x][y]=1;
		         else 
		        	 //sinon si la position du tableau egale a 1 w-1 pour etre sure que tout les bateaux sont positionnez
		        	 w--;
		       
		    	 }
		    	//verifie si tout les bateaux sont possitionez
		    	if(w==Integer.parseInt(bateau.getText())) {
		    		
		    		
				 //dessine bouton suivant
				//methode dessin pour bouton suivant
			   
            Dessin.dessinerBouton(g, "Suivant");
				    //indication
				      g.drawString("ordinateur a possitionez ses bateaux !!!", 90, 150);
		    	}}
		    
		    
		    
		    
		    
		    
		    
		  //page jeu
		    if(page==4) {
		    	//partie joueur
		    	repaint();
		        //3 pour : bateau trouvé
		        //2 pour : pas de bateau
		        //0 pas encore découvert (pas de clique à cette position)
		        
		        g.setColor(this.getBackground());
		        g.fillRect(0, 0, this.getWidth(), this.getHeight());
		        int nbbateau=0;
		        
		        g.drawString(Integer.toString(nbbateau), 90,95);
		        //methode pour dessine le fond en blanc avec les carre
		        Fond.dessinerFondBlanc(g);
		        // cette boucle vérifie s'il y a un bateau à la position 
		        for(int i=0; i<largeur; i++){
		            for(int j=0; j<hauteur; j++) {
		                g.setColor(Color.blue);
		                g.drawString("positionnez vos bombes !!!", 100, 350);
		                repaint();
		                
		                //si la bombe est à la position du bateau alors la position du tableau =3
		                if(grillesbonbjoueur[i][j]==1 && grillesposeordi[i][j]==1){
		                    System.out.println("bateau trouvé");
		                    grillesbonbjoueur[i][j]=3;
		                    
		                    //condition qui vérifie si tous les bateaux sont trouvés à chaque fois qu'un bateau est trouvé, res prend +1 
		                    //si res = au nombre de bateaux saisis, alors tous les bateaux sont trouvés
		                    res++;
		                    if(res==Integer.parseInt(bateau.getText()))
		                        System.out.println("tous les bateaux ont été trouvés");
		                    
		                }
		                
		                //condition 3= bateau trouvé dessine case en rouge
		                if(grillesbonbjoueur[i][j]==3){
		                    Dessin.dessinerCaseRouge(g, i, j);
		                    // Chargez et affichez l'image
		                    // Affichez le bateau à l'intérieur de la case rouge
    					Dessin.dessinerBateau(g, i, j);
		                   //dessine bouton suivant
				//methode dessin pour bouton suivant
			   
            		Dessin.dessinerBouton3(g, "Suivant");
		                    
		                }
		                
		                //si la position de la bombe du joueur n'est pas égale à celle du bateau, alors elle devient égale à 2
		                if(grillesbonbjoueur[i][j] == 1 && grillesposeordi[i][j] == 0){
		                    grillesbonbjoueur[i][j] = 2;
		                   
		                }
		                
		                //condition 2= aucun bateau dessine case en bleu
		                if(grillesbonbjoueur[i][j] == 2){
		                    Dessin.dessinerCaseBleu(g, i, j);
		                   //dessine bouton suivant
				//methode dessin pour bouton suivant
			   
            Dessin.dessinerBouton3(g, "Suivant");
		                    // Affichez plouf à l'intérieur de la case bleu
		                     Dessin.dessinerPlouf(g, i, j);
		                }
		                
		                //condition 0= case non cliquée dessine case en gris
		                if(grillesbonbjoueur[i][j] == 0){
		                    Dessin.dessinerCaseGris(g, i, j);
		                   
		                   
		                }
		                
		            }
		        }
		    }
		    	if(page==5) {
		    //partie de le ordinateur
		    		System.out.println("5");
		    			 g.drawString("suivant", 135, 415);
		    			    g.setColor(Color.blue);
		    			    
		    	
		    			   
		  		    	  g.setColor(this.getBackground());
		  		  		  g.fillRect(0, 0, this.getWidth(), this.getHeight());
		  		  		  int nbbateau=0;
		  		  		
		  		  		  g.drawString(Integer.toString(nbbateau), 90,95);
		  		  		 
		  		  		 Random ran=new Random();
		  		  		 int gg=1;
		  		         int x=ran.nextInt(largeur);
		  		         int y=ran.nextInt(hauteur);
		  		       //methode pour dessinne le fond avec carre blanc
		  		         
		  		      Fond.dessinerFondBlanc(g);
	    					
		    			     
		    			
		  	
           					
		  		  		 // cette boucle verifie si il ya un bateau a la position 
		  		  		  while(gg==1)
		  		  			
	  		  		    	gg=0;
		  		         for(int i=0; i<largeur; i++){
		  		  		    for(int j=0; j<hauteur; j++) {
		  		  		   if(grillesbonbordi[x][y]==0){ 
		  		  		   grillesbonbordi[x][y]=1;
		  		  
		  		  		
		  		  		    }
		  		  		   //si la bombe est a la position du bateau alors la position du tableau =3
		  		  		    	if(grillesbonbordi[i][j]==1&&grillesposejoueur[i][j]==1){
		  		  		    		
		  		  		    	
		  		  		    grillesbonbordi[i][j]=3;
		  		  		    		 
		  		  		      //condition qui verifie si tous les bateaux sont trouver a chaque fois que un bateau est trouver res prend +1 
		  		  		    		//si res = au nombre de bateau saisie alors tout les bateau sont trouver
		  		  		        res++;
		  		  		        if(res==Integer.parseInt(bateau.getText()))
		  		  		        	System.out.println("tous les bateau ont ete trouver");
		  		  		       
		  		  		      }
		  		  		    	
		  		  		    	//condition 3= bateau trouver dessine case en rouge rouge
		  		  		    	if(grillesbonbordi[i][j]==3){
		  		  		    		
		  		  		        Dessin.dessinerCaseRouge(g, i, j);
		  		  		         //dessine bouton suivant
				//methode dessin pour bouton suivant
			   
            Dessin.dessinerBouton4(g, "Suivant");
	  						 // Affichez le bateau à l'intérieur de la case rouge
    							Dessin.dessinerBateau(g, i, j);
	  						 
	
		  					   
		  		  		      
		  		  		      }
		  		  		    
		  		  		    	
		  		  		    	
		  		  		    	
		  		  		    	//si la position de la bombe du jouer n'est pas egale a celle du bateau alors elle devient egale a 2
		  		  		    	if(grillesbonbordi[i][j] == 1 &&grillesposejoueur[v][n]==0){
		  		  		    		
		  		  		    	grillesbonbordi[i][j]=2;
		  			  		   
		  			  		      }
		  		  		    
		  		  		    	
		  		  		    	
		  		  		  	//condition 2= aucun bateau dessine case en bleu
		  		  		    	if(grillesbonbordi[i][j]==2){
		  		  		    		
		  			  		        Dessin.dessinerCaseBleu(g, i, j);
		  			  		        //dessine bouton suivant
				//methode dessin pour bouton suivant
			   
            						Dessin.dessinerBouton4(g, "Suivant");
		  						  g.drawString("ordinateur a positionez une bombe !!!", 90, 340);
		  						 // Affichez plouf à l'intérieur de la case bleu
		                    	Dessin.dessinerPlouf(g, i, j);
		  			  		   
		  			  		      }
		  		  		    
		  		  		    	
		  		  		    	
		  		  		    //condition 0= case non cliquerdessine case en gris
		  		  		      if(grillesbonbordi[i][j]==0)
		  		  		      {

		  		  		        Dessin.dessinerCaseGris(g, i, j);
		  		  		    

		  		  		      }
		  		  		
		  		  		  
		  		  		 }
		  		  		    
		    	
		    		
		  		  				    	}
		    		
		    	}
		  		  
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
	}
		    	
		    	
		    	
		    	
		 		
}