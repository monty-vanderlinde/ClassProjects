package GameObjects;

import Interfaces.Drawable;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Monty Vanderlinde
 */
public abstract class GameObject implements Drawable
{
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private Color color;
    
    public GameObject()
    {
        xPosition = 0;
        yPosition = 0;
        color = Color.BLACK;
    }
    
    public GameObject(int xPosition, int yPosition, int width, int height, Color color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    public int getXPosition()
    {
        return this.xPosition;
    }
    
    public int getYPosition()
    {
        return this.yPosition;
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public Color getColor()
    {
        return new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    }
    
    public void setXPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }
    
    public void setYPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public void setColor(Color color)
    {
        this.color = new Color(color.getRed(), color.getGreen(), color.getBlue());
    }
    
    //only used for brick class, but needs to be called on a GameObject reference
    public abstract void isHit(int hitsTaken);
    
    //I did not use these methods.  They were only implemented because it was the instructions
    public boolean isColliding(GameObject other)
    {
        return getBounds().intersects(other.getBounds());
    }
    
    public abstract Rectangle getBounds();
}
