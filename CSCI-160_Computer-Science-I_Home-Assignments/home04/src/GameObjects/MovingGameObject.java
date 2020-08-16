package GameObjects;

import Interfaces.Moveable;
import java.awt.Color;

/**
 *
 * @author Monty Vanderlinde
 */
public abstract class MovingGameObject extends GameObject implements Moveable
{
    private int xVelocity;
    private int yVelocity;
    
    public MovingGameObject(int xPosition, int yPosition, int width, int height, int xVelocity, int yVelocity, Color color)
    {
        super(xPosition, yPosition, width, height, color);
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }
    
    public int getXVelocity()
    {
        return xVelocity;
    }
    
    public int getYVelocity()
    {
        return yVelocity;
    }
    
    public void setXVelocity(int xVelocity)
    {
        this.xVelocity = xVelocity;
    }
    
    public void setYVelocity(int yVelocity)
    {
        this.yVelocity = yVelocity;
    }
    
    @Override
    public void move()
    {
        super.setXPosition(super.getXPosition() + xVelocity);
        super.setYPosition(super.getYPosition() + yVelocity);
    }
}
