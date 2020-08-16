package GameObjects;

import Controller.KeyboardController;
import Game.GamePanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Monty Vanderlinde
 */
public class Paddle extends ControlledGameObject
{
    private int maxSpeed;
    
    private Paddle()
    {
        super(0, 0, 0, 0, null, null);
    }
    
    public Paddle(int xPostion, int yPosition, KeyboardController controller, Color color)
    {
        super(xPostion, yPosition, 200, 10, color, controller);
        //default speed is 8
        this.maxSpeed = 8;
    }
    
    public void setMaxSpeed(int maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(super.getColor());
        g.fillRect(super.getXPosition(), super.getYPosition(), super.getWidth(), super.getHeight());
    }
    
    //change size of paddle if Wide or Narrow powerups are active
    public void changePaddleSize(GamePanel game, int newWidth)
    {
        //no need to perform so many calculations if the width is already correct
        if(super.getWidth() == newWidth)
            return;
        
        int middleOfPaddleX = super.getXPosition() + (super.getWidth() / 2);
        
        //resizing paddle and keeping it centered
        if(middleOfPaddleX <= 150)//if near the left edge, check to see if widening the paddle would put it over the edge of the map
        {
            if(super.getXPosition() >= (newWidth - super.getWidth()) / 2)
            {
                super.setXPosition(middleOfPaddleX - (newWidth / 2));
                super.setWidth(newWidth);
            }
            else
            {
                super.setXPosition(0);
                super.setWidth(newWidth);
            }
        }
        else if(middleOfPaddleX >= (game.getWidth() - 150))//if near the right edge, check to see if widening the paddle would put it over the edge of the map
        {
            if((super.getXPosition() + super.getWidth()) <= (game.getWidth() - ((newWidth - super.getWidth()) / 2)))
            {
                super.setXPosition(middleOfPaddleX - (newWidth / 2));
                super.setWidth(newWidth);
            }
            else
            {
                super.setXPosition(game.getWidth() - newWidth);
                super.setWidth(newWidth);
            }
        }
        else//no need to check position.  Just resize paddle
        {
            super.setXPosition(middleOfPaddleX - (newWidth / 2));
            super.setWidth(newWidth);
        }
    }
    
    //move paddle if keys are pressed
    public void move(GamePanel useThisOne)
    {
        if(((super.getControllerKeyStatus(37) || super.getControllerKeyStatus(65))) && ((super.getControllerKeyStatus(39) || super.getControllerKeyStatus(68))))
        {
            //do nothing if both a left and right key are pressed sumultaneously
        }
        else if((super.getControllerKeyStatus(37) || super.getControllerKeyStatus(65)))//move left if A or left arrow key are pressed
        {
            if(super.getXPosition() >= this.maxSpeed)
            {
                super.setXPosition(super.getXPosition() - this.maxSpeed);
            }
            else
            {
                super.setXPosition(0);
            }
        }
        else if(super.getControllerKeyStatus(39) || super.getControllerKeyStatus(68))//move right if D or right arrow key are pressed
        {
            if(super.getXPosition() + super.getWidth() <= useThisOne.getWidth() - this.maxSpeed)
            {
                super.setXPosition(super.getXPosition() + this.maxSpeed);
            }
            else
            {
                super.setXPosition(useThisOne.getWidth() - super.getWidth());
            }
        }
    }
    
    //I did not use these methods
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(super.getXPosition(), super.getYPosition(), super.getWidth(), super.getHeight());
    }
    
    @Override
    public void isHit(int hitsTaken){}
    
    @Override
    public void move(){}
}
