package GameObjects;

import Game.GamePanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Monty Vanderlinde
 */
public class Obstacle extends MovingGameObject
{
    private Obstacle()
    {
        super(0, 0, 0, 0, 0, 0, null);
    }
    
    public Obstacle(int xPosition, int yPosition, Color color)
    {
        super(xPosition, yPosition, 50, 50, -4, 0, color);
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(super.getColor());
        g.fillRect(super.getXPosition(), super.getYPosition(), super.getWidth(), super.getHeight());
    }
    
    //only gets within 100 pixels of the edge before it goes back the other way
    public void isCollidingPrecise_UpdateVelocity(GamePanel game)
    {
        if(super.getXPosition() <= 100 || super.getXPosition() + super.getWidth() >= game.getWidth() - 100)
            super.setXVelocity(-1 * super.getXVelocity());
    }
    
    //I did not use these methods
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(super.getXPosition(), super.getYPosition(), super.getWidth(), super.getHeight());
    }
    
    @Override
    public void isHit(int hitsTaken){}
}
