/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carwalkingcg;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * 
 *  
 * Curso : Engenharia Informática 
 * Data   : 12 - 11 - 2020
 * Objectivo : Criar o moviment3333
 */
public class CenarYMoviment extends JPanel implements Runnable {

    
    private Graphics2D graphics2D;
    private CarStructers carro = new CarStructers();
    private  pessoa pessoa = new  pessoa();
    private TexturePaint texture = null;
    private BufferedImage image_primer, imagem_da_textura  ;
   
    private int velX = 7, i = 0;
    private int cx, angle, Vx = 1;
    private Image image;
    private int cy; 
    private int sorry = 200; 
    private int cX = 50;
    private int cY = 250;
    private int Mangle;
    
    
      private  int points [] [] = {
         
        {0, 85}, {75, 75}, {100, 10}, {125, 75},
        {200, 85}, {150, 125}, {160, 190}, {100, 150},
        {40, 190}, {50, 125}, {0, 85}
    };

    
    
 

    public CenarYMoviment() {
   
        
        
         // image = Toolkit.getDefaultToolkit().getImage( "/home/yuri/NetBeansProjects/CarWalkingCG/src/carwalkingcg/homeW.jpg");
          image = new ImageIcon(this.getClass().getResource("homeW.jpg")).getImage();
          
          
        try {
            image_primer  = ImageIO.read(new File("pictures/textura.jpg"));
            
            
            imagem_da_textura = ImageIO.read(new File("pictures/37d81485d5.jpg"));
            
        } catch (IOException ex) {
            Logger.getLogger(CenarYMoviment.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(this).start();
       
    }
    
    
    
    
    
    public void paintComponent(Graphics g)
    {
        
        graphics2D = (Graphics2D) g.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.clearRect(0, 0, this.getWidth(), this.getHeight());
        
        //-- Desenhar a textura da tarefa de CG 
        
        graphics2D.setPaint(new TexturePaint(imagem_da_textura, new Rectangle(0,0,50,65)));
        graphics2D.fill(new Rectangle2D.Double(50,50,200,200));
        graphics2D.setFont(new Font("Serief",Font.BOLD,15));
        graphics2D.drawString("TexturePaint", 45, 45);
        graphics2D.setPaint(Color.black);
        
        // Carro
        
        graphics2D.draw(new Rectangle2D.Double(carro.getCoordX()+110,carro.getCoordY()+310,carro.getLargura_carro()+440, carro.getAltura_carro()+200));
        graphics2D.setPaint(Color.DARK_GRAY);
        graphics2D.fill(new Rectangle2D.Double(carro.getCoordX()+110,carro.getCoordY()+310,carro.getLargura_carro()+245, carro.getAltura_carro()+120));
        
        
        graphics2D.setFont(new Font("Serief",Font.BOLD,12));
        graphics2D.drawString("UCAN BUS (Yuri Domingos)",cx+290 , 490);
        
        //- Janela
        
        graphics2D.setPaint(Color.red);
        graphics2D.draw(new  Rectangle2D.Double(carro.getCoordX()+130,carro.getCoordY()+340,carro.getLargura_carro()+220,carro.getAltura_carro()+70));
           //- Janela
        graphics2D.setPaint(Color.white);
        graphics2D.fill(new  Rectangle2D.Double(carro.getCoordX()+133,carro.getCoordY()+343,carro.getLargura_carro()+214,carro.getAltura_carro()+65));
       
        
        // só implementei o gradientpaint nesta linha 
        
        graphics2D.setPaint(new GradientPaint(55, 20, Color.ORANGE, 3, 100,Color.WHITE, true));
        graphics2D.fill(new  Rectangle2D.Double(carro.getCoordX()+365,carro.getCoordY()+309,carro.getLargura_carro()+186,carro.getAltura_carro()+120));
       

      
      
      
      
      
      
        graphics2D.setPaint(Color.BLACK);
        graphics2D.translate(230, 30);
        graphics2D.fill(new Ellipse2D.Double(pessoa.getCoordX()+10,pessoa.getCoordY()+350,pessoa.getAltura()+25,pessoa.getAltura()+25));
        graphics2D.setPaint(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(1));
      
 
     
     
        
      
        
        AffineTransform at = AffineTransform.getTranslateInstance(Vx-65, 460);
        
        at.rotate(Math.toRadians(i),image.getWidth(this)/2, image.getHeight(this)/2);
      
         graphics2D.drawImage(image, at, this);
         graphics2D.translate(280, 0);
         graphics2D.drawImage(image, at, this);
         
        
      
       
       // centro do peneu 
       
      /* graphics2D.fill(new Ellipse2D.Double(cx+237,pessoa.getCoordY()+496,pessoa.getAltura()+15,pessoa.getAltura()+15));
       graphics2D.fill(new Ellipse2D.Double(cx-44,pessoa.getCoordY()+496,pessoa.getAltura()+15,pessoa.getAltura()+15));
       graphics2D.rotate(Math.toRadians(angle), carro.getCoordX()+50, carro.getCoordY()+565); 
       graphics2D.translate(carro.getCoordX()-5,carro.getCoordY()-92);
       graphics2D.fill(new Rectangle2D.Double(carro.getCoordX()+5,carro.getCoordY()+520,3,20)); */
  
       //---
       /*graphics2D.setPaint(Color.white);
             graphics2D.rotate(Math.toRadians(45));
      graphics2D.fill(new Rectangle2D.Double( sorry,140,100,50));*/
       
       
       
       
        GeneralPath star = new GeneralPath ();
        
        // 
        
          graphics2D.translate(-50, 310);
          
         //     
          
          star.moveTo (points [0] [0], points [0] [1]);

        for (int k = 1; k <points.length; k ++) {
            
            star.lineTo (points [k] [0], points [k] [1]);
        }
        
          graphics2D.setColor(Color.RED);
          
          // 
          
          graphics2D.fill(new Ellipse2D.Double(this.getWidth(), this.getHeight(), 200, 200));
          graphics2D.rotate(Math.toRadians( Mangle),cx-114,+cy+555);
         
         
           //ççç
          Shape circle = new Ellipse2D.Double(cx,cy,200,200);
          
          
      
        
        
       // g2d.fill (star); 
        
         
         Area Circle = new Area(new Ellipse2D.Double(0,10,230,230));
        
         Area star_figures = new Area(star);
        
        
         Circle.subtract(star_figures);
         
         
         texture = new TexturePaint(image_primer, new Rectangle(0,10,230,230));
         graphics2D.setPaint(texture);
         
         
        graphics2D.fill(Circle);
         
     
   
        
        graphics2D.setStroke(new BasicStroke(10f));
         
        
        graphics2D.setStroke(new BasicStroke(10f));graphics2D.setComposite(AlphaComposite.SrcOver.derive(0f));
        
        
        graphics2D.fill(star_figures);
        

    }
    
    public void updatePerson()
    {
        if (pessoa.getCoordX() < 0  ||  pessoa.getCoordX() >= carro.getCoordX()+100  )
        
            velX = -velX;
            pessoa.setCoordX(pessoa.getCoordX()+velX);
            
        
            
            
            
    }
    
    
    
    
    public void paroble()
    {
        if (  Mangle > 180   )
        {
            Mangle *=-1;
        } 
        
        
    }
    public void updatePP()
    {
        
        if ( cx < 140 || cx > 219   )
            
              velX = (-velX);
              cx +=velX;
            
    }

    public void updateX()
    {
        cx+=2;
    }

    
    
    public void update()
    {
        
        
        if ( carro.getCoordX()  <  500)
        {
                carro.setCoordX(carro.getCoordX()+2);
            
        }
    
    }

    
    
    @Override
    public void run() {
        
        while(true)
        {
            Mangle--;
            paroble();  
            
            cX-=5;
            i++; Vx+=2;
            sorry++;
            updateX();
            update();
            updatePerson();
            angle--;
            repaint();
            
            
            try {
                
                Thread.sleep(90);
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
    }
    
    
}
