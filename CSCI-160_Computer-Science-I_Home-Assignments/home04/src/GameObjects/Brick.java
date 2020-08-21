package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Monty Vanderlinde
 */
public class Brick extends GameObject
{
    private int hitsLeft;
    
    private Brick()
    {
        super(0, 0, 0, 0, null);
    }
    
    public Brick(int xPosition, int yPosition, Color color)
    {
        super(xPosition, yPosition, 50, 50, color);
        //will take 2 hits out by default.  PowerUps will temporarily change the number of hits that it takes.
        this.hitsLeft = 4;
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(super.getColor());
        g.fillRect(super.getXPosition(), super.getYPosition(), super.getWidth(), super.getHeight());
        
        //draws black squares in the brick to indicate how much damage it has taken.
        g.setColor(Color.BLACK);
        switch(this.hitsLeft)
        {
            case 4:
                break;
            case 0:
                g.fillRect(super.getXPosition() + 10, super.getYPosition() + 30, 10, 10);
            case 1:
                g.fillRect(super.getXPosition() + 30, super.getYPosition() + 10, 10, 10);
            case 2:
                g.fillRect(super.getXPosition() + 30, super.getYPosition() + 30, 10, 10);
            case 3:
                g.fillRect(super.getXPosition() + 10, super.getYPosition() + 10, 10, 10);
                break;
        }
    }
    
    //updates how many hits it has taken/has left
    @Override
    public void isHit(int hitsTaken)
    {
        this.hitsLeft -= hitsTaken;
    }
    
    public int getHitsLeft()
    {
        return this.hitsLeft;
    }
    
    //I did not use this method
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(super.getXPosition(), super.getYPosition(), super.getWidth(), super.getHeight());
    }
}
