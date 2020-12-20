/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carwalkingcg;

/**
 *
 * @author yuri
 */
public class CarStructers {
    
    private int coordX,coordY, largura_carro,altura_carro;
    private int speedX, speedY;

    
    
    public CarStructers() {
        
        this.setCoordX(10);
        this.setCoordY(10);
        this.setLargura_carro(10);
        this.setAltura_carro(10);
    }

    
    
    
    
    public CarStructers(int coordX, int coordY, int largura_carro, int altura_carro, int speedX, int speedY) {
       
        this.coordX = coordX;
        this.coordY = coordY;
        this.largura_carro = largura_carro;
        this.altura_carro = altura_carro;
        this.speedX = speedX;
        this.speedY = speedY;
    }
    
    

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public int getLargura_carro() {
        return largura_carro;
    }

    public void setLargura_carro(int largura_carro) {
        this.largura_carro = largura_carro;
    }

    public int getAltura_carro() {
        return altura_carro;
    }

    public void setAltura_carro(int altura_carro) {
        this.altura_carro = altura_carro;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
    
    
    
    
    
}
