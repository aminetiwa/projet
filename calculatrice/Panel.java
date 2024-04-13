package calculatrice;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;


import javax.swing.JTextField;

import javax.swing.JComponent;
import javax.swing.JLabel;
public class Panel  extends JComponent 
{
	
	
	
	public Panel() {
		
	}
	public Panel pans;
	public int state,states,compt=-1,t=0;
	private int a=0,b=0,c=0,d=0,e=0;
	// creation de jlabel pour afficher les numeros saisie et le resultat 
	 private JLabel text=new JLabel();
	 private JLabel historique1=new JLabel();
	 //creation de la methode text en priver car les autre fichier.java nont pas besoin 
	private void text() {
		//pour choisir la taile des chiffre afficher
	   Font f = new Font("Serif", Font.PLAIN | Font.ITALIC, 60);
	   Font e = new Font("Serif", Font.PLAIN | Font.ITALIC, 20);
	    text.setFont(f);
	    historique1.setFont(e);
	    //position jlabel
	    text.setBounds(0,0,400,100);
	    this.add(text);    
	    historique1.setBounds(15, 170,400,100);
	    this.add(historique1);

	}
	
	
	
	//creation methode en public  car windows.java a besoin pour afficher les dessin
	//cette methode va permettre dessiner et colorier
	//panel.java a besoin car il a recupere la position du clique est a attribuer une valeur a pan.state 
	//cette valeur attribuer a pan.state sera utilise
	public void paintComponent(Graphics g) {
		 //apel de la fonction text pour afficher le jlabel
		  text();
		  //chois couleur

		  
		   g.setColor(Color.white);
		   g.fillRect(0, 0, 4000, 5000);
		    g.setColor(Color.blue);
		   
		    
		    //case0
			   //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(10, 400, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("0", 30, 430);
			  
			    //case1
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(65, 400, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("1", 85, 430);
			    
			    //case2
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(120, 400, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("2", 135, 430);
			    
			    //case3
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(175, 400, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("3", 190, 430);
			    
			    //case=
			    //dessine un rectangle et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(230, 400, 150, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("=", 300, 430);

			    //case4
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(10, 355, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("4", 30, 380);
			    
			    //case5
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(65, 355, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("5", 85, 380);
			    
			    //case6
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(120, 355, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("6", 135, 380);
			    
			    //case7
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(175, 355, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("7", 190, 380);
			    
			    //case+
			    //dessine un rectangle et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(230, 355, 150, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("+", 300, 380);


			    //case8
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(10, 300, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("8", 30, 325);
			    
			    //case9
			    //dessine un carre et le positione (position x,position y,taille x ,taille y)
			    g.drawRect(65, 300, 50, 50);
			    //dessine une chaine de caractaire "" a la position x , y
			    g.drawString("9", 85, 325);


		
		    
		    //case/
		    //dessine un rectangle et le positione (position x,position y,taille x ,taille y)
		    g.drawRect(230, 190, 150, 50);
		    //dessine une chaine de caractaire "" a la position x , y
		    g.drawString("/", 300, 210);
		    
			//caseX
			//dessine un rectangle et le positione (position x,position y,taille x ,taille y)
		    g.drawRect(230, 245, 150, 50);
		    //dessine une chaine de caractaire "" a la position x , y
		    g.drawString("X", 300, 270);
		    
		    //case-
		    //dessine un rectangle et le positione (position x,position y,taille x ,taille y)
		    g.drawRect(230, 300, 150, 50);
		    //dessine une chaine de caractaire "" a la position x , y
		    g.drawString("-", 300, 325);


		    //case ce
		    //dessine un rectangle et le positione (position x,position y,taille x ,taille y)
		     g.drawRect(120, 300, 105, 50);
		     //dessine une chaine de caractaire "" a la position x , y
		    g.drawString("ce", 155, 325);
		    
		    //case ce
		    //dessine un rectangle et le positione (position x,position y,taille x ,taille y)
		     g.drawRect(10, 190,215, 105);
		     //dessine une chaine de caractaire "" a la position x , y
		    g.drawString("historique", 80, 210);


		    //bouton 0
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==1) {
		    	 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 

		    	 if(states!=0){
		    	 //va ecrire le chiffre saisie a coter de celui existant 
		    	
		    	text.setText(text.getText()+"0");
		    	historique1.setText(historique1.getText()+"0");
		    	  g.fillRect(10, 400, 50, 50);
		    	  g.setColor(Color.white);
			    	 g.drawString("0", 30, 430);
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    } 
		    	  
		    
		    //bouton1
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==2) {
		    	 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		
		    		  g.fillRect(65, 400, 50, 50);
		    		  g.setColor(Color.white);
		    		  g.drawString("1", 85, 430);
		    		 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"1");
		    	historique1.setText(historique1.getText()+"1");
		    	
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    //bouton2
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==3) {
		    	
		    	if(states!=0){
		    		
		    		 g.fillRect(120, 400, 50, 50);
		    		 g.setColor(Color.white);
		    		 g.drawString("2", 135, 430);
		    		 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"2");
		    	historique1.setText(historique1.getText()+"2");
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    
		    //bouton3
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==4) {
		    	
		    	 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		
		    		 g.fillRect(175, 400, 50, 50);
		    		 g.setColor(Color.white);
		    		 g.drawString("3", 190, 430);
		    		 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"3");
		    	historique1.setText(historique1.getText()+"3");
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    
		   
		    //bouton4
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==6) {
		    	 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		 
		    		 g.fillRect(10, 355, 50, 50);
		    		 g.setColor(Color.white);
		    		 g.drawString("4", 30, 380);
		    		 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"4");
		    	historique1.setText(historique1.getText()+"4");
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    
		    //bouton5
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==7) {
		     //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		
		    		 g.fillRect(65, 355, 50, 50);
		    		 g.setColor(Color.white);
		    		 g.drawString("5", 85, 380);
		    		 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"5");
		    	historique1.setText(historique1.getText()+"5");
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    
		    //bouton6
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==8) {
		     //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    if(states!=0){
		    	
		    	g.fillRect(120, 355, 50, 50);
		    	g.setColor(Color.white);
		    	g.drawString("6", 135, 380);
		    	 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"6");
		    	historique1.setText(historique1.getText()+"6");
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    
		    //bouton7
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==9) {
		    	 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		
		    		 g.fillRect(175, 355, 50, 50);
		    		 g.setColor(Color.white);
		    		 g.drawString("7", 190, 380);

		    		 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"7");
		    	historique1.setText(historique1.getText()+"7");
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    
		    //bouton8
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==10) {
		    	 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		
		    		  g.fillRect(10, 300, 50, 50);
		    		  g.setColor(Color.white);
		    		  g.drawString("8", 30, 325);
		    		 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"8");
		    	historique1.setText(historique1.getText()+"8");
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    
		    //bouton9
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==11) {
		    	 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		 
		    		 g.fillRect(65, 300, 50, 50);
		    		 g.setColor(Color.white);
		    		 g.drawString("9", 85, 325);
		    		 //va ecrire le chiffre saisie a coter de celui existant 
		    	text.setText(text.getText()+"9");
		    	historique1.setText(historique1.getText()+"9");
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    	}
		    }
		    
		    //bouton+
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==12) {
		    	 
		    	 
		    	t=1;
		    	compt=0;
		    	//ce si fonctionnera uniquement pour le premier clique
		    	if(compt<1){
		    		 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		historique1.setText(historique1.getText()+"+");
		    		//a stock la valeur saisie
		    		a=Integer.parseInt(text.getText());
		    		//efface toute la saisie afficher 
		    	text.setText("");

		    //states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    states=0;
		    }}//compt devient = 2 fin du si (compt<1) definitvement
			compt=2;
		    //si le premier si (state) est valider et que compt et superieur a 2 cela veut dire que ce n'est pas le premier clique
		    	if(compt>=2 ){
		    		//b stocke la valeur saisie 
		    		b=Integer.parseInt(text.getText());
		    		//a stocke le calcule a + b
		    		a=a+b;

		    		
		    		//efface toute valeur saisi
		    		text.setText("");
		    		
		    		//compt devient egale a 1 meme raison questates avec un s
		    		compt=1;
		    	}
		    	
		    	
		    	
		    	


		    	
		    	}
		    	

		   
		    //bouton-
		    	//si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==13) {
		    	 
		    	 
		    	t=2;
		    	compt=0;
		    	//ce si fonctionnera uniquement pour le premier clique
		    	if(compt<1){
		    		 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		historique1.setText(historique1.getText()+"-");
		    		//a stock la valeur saisie
		    		c=Integer.parseInt(text.getText());
		    		//efface toute la saisie afficher 
		    	text.setText("");
		    
		    //states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    states=0;
		    }}//compt devient = 2 fin du si (compt<1) definitvement
			compt=2;
		    //si le premier si (state) est valider et que compt et superieur a 2 cela veut dire que ce n'est pas le premier clique
		    	if(compt>=2 ){
		    		//b stocke la valeur saisie 
		    		b=Integer.parseInt(text.getText());
		    		
		    		//a stocke le calcule a + b
		    		c=c-b;
		    		

		    		
		    		//efface toute valeur saisi
		    		text.setText("");
		    		
		    		//compt devient egale a 1 meme raison questates avec un s
		    		compt=1;
		    	}
}
		    //boutonX
			//si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==14) {
		    	 
		    	 
		    	t=3;
		    	compt=0;
		    	//ce si fonctionnera uniquement pour le premier clique
		    	if(compt<1){
		    		 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		historique1.setText(historique1.getText()+"x");
		    		//a stock la valeur saisie
		    		d=Integer.parseInt(text.getText());
		    		//efface toute la saisie afficher 
		    	text.setText("");
		   
		    //states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    states=0;
		    }}//compt devient = 2 fin du si (compt<1) definitvement
			compt=2;
		    //si le premier si (state) est valider et que compt et superieur a 2 cela veut dire que ce n'est pas le premier clique
		    	if(compt>=2 ){
		    		//b stocke la valeur saisie 
		    		b=Integer.parseInt(text.getText());
		    		//a stocke le calcule a + b
		    		d=d*b;

		    		
		    		//efface toute valeur saisi
		    		text.setText("");
		    		
		    		//compt devient egale a 1 meme raison questates avec un s
		    		compt=1;
		    	}
}
		    //bouton/
			//si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==15) {
		    	 
		    	 
		    	t=4;
		    	compt=0;
		    	//ce si fonctionnera uniquement pour le premier clique
		    	if(compt<1){
		    		 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		historique1.setText(historique1.getText()+"/");
		    		//a stock la valeur saisie
		    		e=Integer.parseInt(text.getText());
		    		//efface toute la saisie afficher 
		    	text.setText("");
		  
		    //states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    states=0;
		    }}//compt devient = 2 fin du si (compt<1) definitvement
			compt=2;
		    //si le premier si (state) est valider et que compt et superieur a 2 cela veut dire que ce n'est pas le premier clique
		    	if(compt>=2 ){
		    		//b stocke la valeur saisie 
		    		b=Integer.parseInt(text.getText());
		    		//a stocke le calcule a + b
		    		e=e/b;

		    		
		    		//efface toute valeur saisi
		    		text.setText("");
		    		
		    		//compt devient egale a 1 meme raison questates avec un s
		    		compt=1;
		    	}
		    }
		    //bouton=
		    //si le resultat (la position de la souris) est =1 alors tu fais 
		    if(state==5) {
		    	
		    	 //cette partie ce repete a l'infi alors pour avoir 1 seul fois l'action 
		    	//faut que states avec un s soit egale a 1 au debut du si et a la fin egale a zero 
		    	if(states!=0){
		    		historique1.setText(historique1.getText()+"0");
		    		//stocke la saisie dans b
		    		b=Integer.parseInt(text.getText());
		    		System.out.println(t);
		    	if(t==1) {
		    	a=a+b;
		    	text.setText(""+a);
		    	historique1.setText(historique1.getText()+"="+a);}
		    	if(t==2) {
		    	c=c-b;
		    	
		    	text.setText(""+c);
		    	historique1.setText(historique1.getText()+"="+b);}
		    	if(t==3) {
		    	d=d*b;
		    	text.setText(""+d);
		    	historique1.setText(historique1.getText()+"="+d);}
		    	if(t==4) {
		    	e=e/b;
		    	text.setText(""+e);
		    	historique1.setText(historique1.getText()+"="+e);}

		  
		    
		    	//states avec un s est =a 0 donc fin du si et je suis passer une fois 
		    	states=0;
		    }}
		    	 if(state==16) {
			    	 
			    	 
		    			
				    	compt=0;
				    	//ce si fonctionnera uniquement pour le premier clique
				    	if(compt<1){
				    	
				    	if(states!=0){
				    		
				    		text.setText("");
				    		a=0;
				    		b=0;
				    		c=0;
				    		d=0;
				    		e=0;
				    	
				    states=0;
				    }}//compt devient = 2 fin du si (compt<1) definitvement
					
				    		
				    		//compt devient egale a 1 meme raison questates avec un s
				    		compt=1;
				    	}
		    }
		    
	}
		
