package GameObjects;

import Game.GamePanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Monty Vanderlinde
 */
public class PowerUp extends MovingGameObject
{
    private final static Random RAND = new Random();
    private final static char[] SYMBOL_LIST = new char[]{'F', 'S', 'W', 'N', 'T', 'E', 'L'};
    private int charIndex;
    
    private PowerUp()
    {
        super(0, 0, 0, 0, 0, 0, null);
    }
    
    public PowerUp(int xPosition, int yPosition)
    {
        super(xPosition, yPosition, 50, 50, 0, 2, Color.PINK);
        //powerup is chosen at random
        this.charIndex = PowerUp.RAND.nextInt(7);
    }
    
    public int getPowerUpIndex()
    {
        return this.charIndex;
    }
    
    //powerups that make the game more difficult are red letters
    //powerups that make the game less difficult are green letters
    @Override
    public void draw(Graphics g)
    {
        g.setColor(super.getColor());
        g.fillRect(super.getXPosition(), super.getYPosition(), super.getWidth(), super.getHeight());
        switch(this.charIndex)
        {
            case 0:
                g.setColor(Color.RED);
                break;
            case 1:
                g.setColor(Color.GREEN);
                break;
            case 2:
                g.setColor(Color.GREEN);
                break;
            case 3:
                g.setColor(Color.RED);
                break;
            case 4:
                g.setColor(Color.RED);
                break;
            case 5:
                g.setColor(Color.GREEN);
                break;
            case 6:
                g.setColor(Color.WHITE);
                break;
        }
        
        //changing size and font
        g.setFont(new Font("Times New Roman", Font.BOLD, 50));
        //letters are centered in the powerup block
        g.drawString(String.valueOf(PowerUp.SYMBOL_LIST[this.charIndex]), super.getXPosition() + ((50 - g.getFontMetrics().charWidth(PowerUp.SYMBOL_LIST[this.charIndex])) / 2), super.getYPosition() + super.getHeight() - 8);
    }
    
    //is it behind the info-bar at the bottom of the screen
    public boolean isCollidingPrecise_Wall(GamePanel game)
    {
        return super.getYPosition() >= (game.getHeight() - 100);
    }
    
    //is it contacting the paddle at all
    public boolean isCollidingPrecise_Paddle(Paddle paddle)
    {
        return ((super.getYPosition() + super.getHeight() >= paddle.getYPosition()) && (super.getYPosition() <= paddle.getYPosition() + paddle.getHeight())) && ((super.getXPosition() + super.getWidth() >= paddle.getXPosition()) && (super.getXPosition() <= paddle.getXPosition() + paddle.getWidth()));
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
