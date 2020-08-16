package GameObjects;

import Game.GamePanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Monty Vanderlinde
 */
public class Ball extends MovingGameObject
{
    private int speed;
    
    private Ball()
    {
        super(0, 0, 0, 0, 0, 0, null);
    }
    
    public Ball(int xPosition, int yPosition, int diameter, Color color)
    {
        super(xPosition, yPosition, diameter, diameter, 7, -7, color);
        this.speed = 7;
    }
    
    //increase or decrease the speed, but maintain the direction (+ or -)
    public void updateSpeed(int newSpeed)
    {
        super.setXVelocity((super.getXVelocity() / this.speed) * newSpeed);
        super.setYVelocity((super.getYVelocity() / this.speed) * newSpeed);
        this.speed = newSpeed;
    }
    
    //ball must remain a circle, so both height and width are updated at the same time
    @Override
    public void setWidth(int diameter)
    {
        super.setWidth(diameter);
        super.setHeight(diameter);
    }
    
    //ball must remain a circle, so both height and width are updated at the same time
    @Override
    public void setHeight(int diameter)
    {
        super.setWidth(diameter);
        super.setHeight(diameter);
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(super.getColor());
        g.fillOval(super.getXPosition(), super.getYPosition(), super.getWidth(), super.getHeight());
    }
    
    //Yes, it is really that big.  No, I'm not sorry.
    //if "GameObject other" is null or a powerup, then do nothing (though it shouldn't be)
    //checks to see if ball is hitting the "other" object on the sides or corners and changes the ball's velocity accordingly
    //bounces off of "other's" walls like normal.  bounces radially outward from "other" if corner is hit
    //also changes position of the ball so that it is not inside of the object
    //returns true if it has collided with a corner
    //causes bugs if it hits two corners at once, so I check if it is true and do not let it bounce off of any more corners for that frame
    public boolean isCollidingPrecise_GameObjects_UpdateVelocity(GameObject other, GamePanel game, int frameNumber)
    {
        //null check
        if(other == null)
            return false;
        
        //does not interact with PowerUps
        if(other instanceof PowerUp)
            return false;
        
        //distance from center of rectangle to center of ball in y direction
        int distanceY = (other.getYPosition() + (other.getHeight() / 2)) - (super.getYPosition() + (super.getHeight() / 2));
        
        //is the ball within the bounds of the rectangle's height
        if(Math.abs(distanceY) <= ((other.getHeight() / 2) + (super.getHeight() / 2)))
        {
            //distance from center of rectangle to center of ball in x direction
            int distanceX = (other.getXPosition() + (other.getWidth() / 2)) - (super.getXPosition() + (super.getWidth() / 2));
            
            //is the ball within the bounds of the rectangle's width
            if(Math.abs(distanceX) <= ((other.getWidth() / 2) + (super.getWidth() / 2)))
            {
                //the ball is touching the top or the bottom side
                if(Math.abs(distanceX) <= (other.getWidth() / 2))
                {
                    if(super.getYPosition() > other.getYPosition())
                    {
                        super.setYPosition(other.getYPosition() + super.getHeight() + 1);
                    }
                    else
                    {
                        super.setYPosition(other.getYPosition() - super.getHeight() - 1);
                    }
                    
                    //change vertical direction
                    super.setYVelocity(super.getYVelocity() * -1);
                    
                    if(other instanceof Paddle)
                    {
                        //ball will bounce to the left if it hits the left side of the paddle and vice versa
                        if((super.getXPosition() + (super.getWidth() / 2) >= other.getXPosition() + (other.getWidth() / 2) && super.getXVelocity() < 0) || (super.getXPosition() + (super.getWidth() / 2) < other.getXPosition() + (other.getWidth() / 2) && super.getXVelocity() > 0))
                        {
                            super.setXVelocity(super.getXVelocity() * -1);
                        }
                    }
                    else
                    {
                        if(other instanceof Brick)
                        {
                            if(game.getPowerUpState(4))
                            {
                                other.isHit(1);
                            }
                            else if(game.getPowerUpState(5))
                            {
                                other.isHit(4);
                            }
                            else
                            {
                                other.isHit(2);
                            }
                            
                            game.updateScore();
                        }
                    }
                    
                    return false;
                }
                
                //the ball is touching the left or right side
                if(Math.abs(distanceY) <= (other.getHeight() / 2))
                {
                    if(super.getXPosition() > other.getXPosition())
                    {
                        super.setXPosition(other.getXPosition() + super.getWidth()+ 1);
                    }
                    else
                    {
                        super.setXPosition(other.getXPosition() - super.getWidth()- 1);
                    }
                    
                    if(other instanceof Paddle)
                    {
                        //if hits side of paddle, then ball is deflected horizontally
                        if((distanceX > 0 && super.getXVelocity() > 0) || (distanceX < 0 && super.getXVelocity() < 0))
                        {
                            super.setXVelocity(super.getXVelocity() * -1);
                        }
                    }
                    else
                    {
                        super.setXVelocity(super.getXVelocity() * -1);
                        if(other instanceof Brick)
                        {
                            if(game.getPowerUpState(4))
                            {
                                other.isHit(1);
                            }
                            else if(game.getPowerUpState(5))
                            {
                                other.isHit(4);
                            }
                            else
                            {
                                other.isHit(2);
                            }
                            
                            game.updateScore();
                        }
                    }
                    
                    return false;
                }
                
                //the ball is touching one of the corners
                if((((Math.abs(distanceX) - (other.getWidth() / 2)) * (Math.abs(distanceX) - (other.getWidth() / 2))) + ((Math.abs(distanceY) - (other.getHeight() / 2)) * (Math.abs(distanceY) - (other.getHeight() / 2)))) <= ((super.getWidth() / 2) * (super.getWidth() / 2)))
                {
                    super.setXPosition(super.getXPosition() + (-1 * super.getXVelocity()));
                    super.setYPosition(super.getYPosition() + (-1 * super.getYVelocity()));
                    
                    if(distanceX > 0)
                    {
                        if(distanceY > 0)//top left corner
                        {
                            super.setXVelocity(-1 * Math.abs(super.getXVelocity()));
                            super.setYVelocity(-1 * Math.abs(super.getXVelocity()));
                        }
                        else//bottom left corner
                        {
                            super.setXVelocity(-1 * Math.abs(super.getXVelocity()));
                            super.setYVelocity(Math.abs(super.getXVelocity()));
                        }
                    }
                    else
                    {
                        if(distanceY > 0)//top right corner
                        {
                            super.setXVelocity(Math.abs(super.getXVelocity()));
                            super.setYVelocity(-1 * Math.abs(super.getXVelocity()));
                        }
                        else//bottom right corner
                        {
                            super.setXVelocity(Math.abs(super.getXVelocity()));
                            super.setYVelocity(Math.abs(super.getXVelocity()));
                        }
                    }
                    
                    if(other instanceof Brick)
                    {
                        if(game.getPowerUpState(4))
                        {
                            other.isHit(1);
                        }
                        else if(game.getPowerUpState(5))
                        {
                            other.isHit(4);
                        }
                        else
                        {
                            other.isHit(2);
                        }
                        
                        game.updateScore();
                    }
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    //if it hits a wall, it will change the velocity and move the ball out of the wall
    public void isCollidingPrecise_Walls_UpdateVelocity(GamePanel game)
    {
        if(super.getXPosition() <= 0)//left wall
        {
            super.setXVelocity(-1 * super.getXVelocity());
            super.setXPosition(1);
        }
        
        if(super.getXPosition() + super.getWidth() >= game.getWidth())//right wall
        {
            super.setXVelocity(-1 * super.getXVelocity());
            super.setXPosition(game.getWidth() - super.getWidth() - 1);
        }
        
        if(super.getYPosition() <= 0)//top wall
        {
            super.setYVelocity(-1 * super.getYVelocity());
            super.setYPosition(1);
        }
        
        if(super.getYPosition() + super.getHeight() >= (game.getHeight() - 100))//bottom wall
        {
            if(game.getLivesLeft() != 0)
            {
                super.setYVelocity(-1 * super.getYVelocity());
                super.setYPosition((game.getHeight() - 100) - super.getHeight() - 1);
                game.subtractLife();
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
}
