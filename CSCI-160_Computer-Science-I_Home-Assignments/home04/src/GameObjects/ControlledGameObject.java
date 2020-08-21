package GameObjects;

import Controller.KeyboardController;
import Interfaces.Moveable;
import java.awt.Color;

/**
 *
 * @author Monty Vanderlinde
 */
public abstract class ControlledGameObject extends GameObject implements Moveable
{
    private KeyboardController control;
    
    public ControlledGameObject(int xPosition, int yPosition, int width, int height, Color color, KeyboardController control)
    {
        super(xPosition, yPosition, width, height, color);
        this.control = control;
    }
    
    //method to maintain encapsulation
    public boolean getControllerKeyStatus(int key)
    {
        return this.control.getKeyStatus(key);
    }
}
