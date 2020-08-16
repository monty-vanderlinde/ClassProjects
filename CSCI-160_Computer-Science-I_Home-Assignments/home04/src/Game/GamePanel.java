package Game;

import Controller.KeyboardController;
import GameObjects.Ball;
import GameObjects.Brick;
import GameObjects.Obstacle;
import GameObjects.Paddle;
import GameObjects.PowerUp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author araderma & Monty Vanderlinde
 */
public class GamePanel extends JPanel
{
    // Required components. Do not remove!
    private Timer gameTimer; 
    private KeyboardController controller; 
    
    // Controls size of game window and framerate
    private final int gameWidth = 1280; 
    private final int gameHeight = 720; 
    private final int framesPerSecond = 60;
    
    //random number
    private final static Random RAND = new Random();
    
    //misc.
    private int score;
    private int livesLeft;
    private int multiplier;
    
    //0)fast ball  1)slow ball  2)wide paddle  3)narrow paddle  4)tough blocks  5)easy blocks
    //true if active
    private boolean[] powerUpState;
    
    //frame that PowerUp will terminate on
    private int[] powerUpFrameEnd;
    
    //current frame number
    private int frameNumber;
    
    //lists of items that have many multiples on screen
    private ArrayList<PowerUp> powerUpsList;
    private ArrayList<Brick> brickList;
    
    //Game objects
    private Ball ball;
    private Paddle paddle;
    private Obstacle obstacle;
    
    //checks for start and end
    private boolean hasStarted;
    private boolean hasWon;
    private boolean hasLost;
    private int startFrame;
    
    //pause
    private boolean isPaused1;
    private boolean isPaused2;
        
    public final void setupGame()
    {
        // Initialize field values here
        this.controller = new KeyboardController(); 
        this.powerUpsList = new ArrayList(0);
        this.brickList = new ArrayList(0);
        this.powerUpState = new boolean[6];
        this.powerUpFrameEnd = new int[6];
        this.score = 0;
        this.livesLeft = 8;
        this.multiplier = 2;
        this.frameNumber = 0;
        this.hasStarted = false;
        this.hasWon = false;
        this.hasLost = false;
        this.isPaused1 = false;
        this.isPaused2 = false;
        
        for(int i = 0; i < 21; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                switch((i + j) % 6)
                {
                    case 0:
                        this.brickList.add(new Brick(15 + (60 * i), 15 + (60 * j), Color.MAGENTA));
                        break;
                    case 1:
                        this.brickList.add(new Brick(15 + (60 * i), 15 + (60 * j), Color.BLUE));
                        break;
                    case 2:
                        this.brickList.add(new Brick(15 + (60 * i), 15 + (60 * j), Color.GREEN));
                        break;
                    case 3:
                        this.brickList.add(new Brick(15 + (60 * i), 15 + (60 * j), Color.YELLOW));
                        break;
                    case 4:
                        this.brickList.add(new Brick(15 + (60 * i), 15 + (60 * j), Color.ORANGE));
                        break;
                    case 5:
                        this.brickList.add(new Brick(15 + (60 * i), 15 + (60 * j), Color.RED));
                        break;
                    
                }
            }
        }
        this.brickList.trimToSize();
        
        addKeyListener(this.controller);
        
        this.ball = new Ball((this.gameWidth / 2) - 25, this.gameHeight - 175, 50, Color.WHITE);
        this.paddle = new Paddle((this.gameWidth / 2) - 100, this.gameHeight - 125, this.controller, Color.LIGHT_GRAY);
        this.obstacle = new Obstacle((this.gameWidth / 2) - 25, this.gameHeight - 435, Color.DARK_GRAY);
    }
    
    public void updateScore()
    {
        this.score += this.multiplier;
    }
    
    public int getLivesLeft()
    {
        return this.livesLeft;
    }
    
    public void subtractLife()
    {
        this.livesLeft--;
    }
    
    private void addLife()
    {
        if(this.livesLeft < 9)
            this.livesLeft++;
    }
    
    public boolean getPowerUpState(int index)
    {
        return this.powerUpState[index];
    }
    
    public void setPowerUpState_UpdateMultiplier(int index, boolean state)
    {
        if(index > 6 || index < 0)
            System.err.println("setPowerUpState index out of bounds");
        
        if(index == 6)
            addLife();
        else if(state)
        {
            switch(index)
            {
                case 0:
                    this.powerUpState[0] = true;
                    this.powerUpState[1] = false;
                    this.powerUpFrameEnd[index] = this.frameNumber + 300;
                    break;
                case 1:
                    this.powerUpState[1] = true;
                    this.powerUpState[0] = false;
                    this.powerUpFrameEnd[index] = this.frameNumber + 300;
                    break;
                case 2:
                    this.powerUpState[2] = true;
                    this.powerUpState[3] = false;
                    this.powerUpFrameEnd[index] = this.frameNumber + 300;
                    break;
                case 3:
                    this.powerUpState[3] = true;
                    this.powerUpState[2] = false;
                    this.powerUpFrameEnd[index] = this.frameNumber + 300;
                    break;
                case 4:
                    this.powerUpState[4] = true;
                    this.powerUpState[5] = false;
                    this.powerUpFrameEnd[index] = this.frameNumber + 300;
                    break;
                case 5:
                    this.powerUpState[5] = true;
                    this.powerUpState[4] = false;
                    this.powerUpFrameEnd[index] = this.frameNumber + 300;
                    break;
            }
        }
        else
        {
            this.powerUpState[index] = false;
        }
        
        this.multiplier = 2;
        if(this.powerUpState[0])
            this.multiplier++;
        if(this.powerUpState[1])
            this.multiplier--;
        if(this.powerUpState[2])
            this.multiplier--;
        if(this.powerUpState[3])
            this.multiplier++;
    }
    
    @Override
    public void paint(Graphics g)
    {
        //paint over old frame
        super.paint(g);
        
        //only paint home screen if have not started game
        if(!hasStarted)
        {
            //white background for home screen
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.gameWidth, this.gameHeight);
            
            //game title
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g.drawString("Block Breaker", (this.gameWidth - g.getFontMetrics().stringWidth("Block Breaker")) / 2, 125);
            
            //headers
            g.setFont(new Font("Times New Roman", Font.BOLD, 50));
            g.drawRect(25, 150, (this.gameWidth / 2) - 35, 235);
            g.drawRect((this.gameWidth / 2) + 10, 150, (this.gameWidth / 2) - 35, 235);
            g.drawRect(25, 410, this.gameWidth - 50, 235);
            g.drawString("Controls", 30, 200);
            g.drawString("Power-Ups", (this.gameWidth / 2) + 15, 200);
            g.drawString("Score and Multiplier", (this.gameWidth - g.getFontMetrics().stringWidth("Score and Multiplier")) / 2, 465);
            
            //rest of the text
            g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
            g.drawString("Left: A or Left Arrow Key", 30, 255);
            g.drawString("Right: D or Right Arrow Key", 30, 310);
            g.drawString("Pause: P", 30, 365);
            g.drawString("L: Add Life", (this.gameWidth * 3 / 4) + 10, 200);
            g.drawString("F: Fast", (this.gameWidth * 3 / 4) + 10, 255);
            g.drawString("S: Slow", (this.gameWidth / 2) + 30, 255);
            g.drawString("W: Wide", (this.gameWidth * 3 / 4) + 10, 310);
            g.drawString("N: Narrow", (this.gameWidth / 2) + 30, 310);
            g.drawString("T: Tough", (this.gameWidth * 3 / 4) + 10, 365);
            g.drawString("E: Easy", (this.gameWidth / 2) + 30, 365);
            g.drawString("Right: D or Right Arrow Key", 30, 310);
            g.drawString("The score is increased whenever a brick is hit.  The multiplier", 30, 520);
            g.drawString("is 2 by default, but F and N increase it by one each, while ", 30, 575);
            g.drawString("S and W decrease it by one each.  Break all the bricks to win!", 30, 630);
            
            //press space to begin
            g.drawString("Press Space to Begin", (this.gameWidth - g.getFontMetrics().stringWidth("Press Space to Begin")) / 2, 695);
            return;
        }
        
        //3,2,1 countdown
        if(this.startFrame > this.frameNumber - 240)
        {
            String t = "";
            switch((this.frameNumber - this.startFrame) / 60)
            {
                case 0:
                    break;
                case 1:
                    t = "3";
                    break;
                case 2:
                    t = "2";
                    break;
                case 3:
                    t = "1";
                    break;
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g.drawString(t, (this.gameWidth - g.getFontMetrics().stringWidth(t)) / 2, 465);
        }
        
        // Draw Bricks
        for(int i = 0; i < this.brickList.size(); i++)
        {
            this.brickList.get(i).draw(g);
        }
        
        // Draw Ball
        this.ball.draw(g);
        
        // Draw Obstacle
        this.obstacle.draw(g);
        
        // Draw PowerUps
        for(int i = 0; i < this.powerUpsList.size(); i++)
        {
            this.powerUpsList.get(i).draw(g);
        }
        
        // Draw Paddle
        this.paddle.draw(g);
        
        //bottom pannel
        g.setColor(Color.WHITE);
        g.fillRect(0, this.gameHeight - 100, this.gameWidth, 100);
        g.setFont(new Font("Times New Roman", Font.BOLD, 50));
        
        //lives left
        g.setColor(Color.YELLOW);
        g.fillRect(10, this.gameHeight - 79, 280, 58);
        g.setColor(Color.BLACK);
        g.drawString("Lives Left: " + this.livesLeft, 15, this.gameHeight - 33);
        
        //score
        g.setColor(Color.YELLOW);
        g.fillRect(295, this.gameHeight - 79, 235, 58);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + this.score, 300, this.gameHeight - 33);
        
        //multiplier
        g.setColor(Color.YELLOW);
        g.fillRect(535, this.gameHeight - 79, 285, 58);
        g.setColor(Color.BLACK);
        g.drawString("Multiplier: " + this.multiplier, 540, this.gameHeight - 33);
        
        String s;
        
        //speed
        if(this.powerUpState[0])
        {
            s = "Fast";
            g.setColor(Color.RED);
        }
        else if(this.powerUpState[1])
        {
            s = "Slow";
            g.setColor(Color.GREEN);
        }
        else
        {
            s = "";
            g.setColor(Color.LIGHT_GRAY);
        }
        g.fillRect(825, this.gameHeight - 79, 110, 58);
        g.setColor(Color.BLACK);
        g.drawString(s, 825 + ((110 - g.getFontMetrics().stringWidth(s)) / 2), this.gameHeight - 33);
        
        //width
        if(this.powerUpState[2])
        {
            s = "Wide";
            g.setColor(Color.GREEN);
        }
        else if(this.powerUpState[3])
        {
            s = "Narrow";
            g.setColor(Color.RED);
        }
        else
        {
            s = "";
            g.setColor(Color.LIGHT_GRAY);
        }
        g.fillRect(940, this.gameHeight - 79, 175, 58);
        g.setColor(Color.BLACK);
        g.drawString(s, 940 + ((175 - g.getFontMetrics().stringWidth(s)) / 2), this.gameHeight - 33);
        
        //toughness
        if(this.powerUpState[4])
        {
            s = "Tough";
            g.setColor(Color.RED);
        }
        else if(this.powerUpState[5])
        {
            s = "Easy";
            g.setColor(Color.GREEN);
        }
        else
        {
            s = "";
            g.setColor(Color.LIGHT_GRAY);
        }
        g.fillRect(1120, this.gameHeight - 79, 150, 58);
        g.setColor(Color.BLACK);
        g.drawString(s, 1120 + ((150 - g.getFontMetrics().stringWidth(s)) / 2), this.gameHeight - 33);
        
        g.setColor(Color.WHITE);
        
        //display "You Won!"
        if(hasWon)
        {
            g.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g.drawString("You Won!", (this.gameWidth - g.getFontMetrics().stringWidth("You Won!")) / 2, 465);
        }
        
        //display "Game Over!"
        if(hasLost)
        {
            g.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g.drawString("Game Over!", (this.gameWidth - g.getFontMetrics().stringWidth("Game Over!")) / 2, 465);
        }
        
        if(hasWon || hasLost)
        {
            g.setFont(new Font("Times New Roman", Font.BOLD, 50));
            g.drawString("Press Space to Exit", (this.gameWidth - g.getFontMetrics().stringWidth("Press Space to Exit")) / 2, 515);
        }
    }
    
    public void updateGameState()
    {
        //increase frame number
        this.frameNumber++;
        
        //do not update anything if on the home screen
        if(!hasStarted)
        {
            if(this.controller.getKeyStatus(32))
            {
                this.hasStarted = true;
                this.startFrame = this.frameNumber;
            }
            
            return;
        }
        
        //wait 4 seconds before updating game after start
        if(this.startFrame > this.frameNumber - 240)
            return;
        
        //pause the game
        if(this.isPaused1 || this.controller.getKeyStatus(80))
        {
            if(!this.isPaused2 && this.controller.getKeyStatus(80))
            {
                this.isPaused1 = true;
                return;
            }
            if(this.isPaused1 && !this.controller.getKeyStatus(80))
            {
                this.isPaused2 = true;
                return;
            }
            if(this.isPaused2 && this.controller.getKeyStatus(80))
            {
                this.isPaused1 = false;
                return;
            }
        }
        if(this.isPaused2)
        {
            this.isPaused2 = false;
        }
        
        //terminate game if won or lost and press space
        if((hasWon || hasLost) && this.controller.getKeyStatus(32))
            System.exit(0);
        
        //check if game is won
        if(this.brickList.isEmpty())
        {
            this.hasWon = true;
            return;
        }
        
        //check if game is lost
        if(this.ball.getYPosition() > this.gameHeight - 100)
        {
            this.hasLost = true;
            return;
        }
        
        //check for powerups hitting bottom wall
        for(int i = 0; i < this.powerUpsList.size(); i++)
        {
            if(this.powerUpsList.get(i).isCollidingPrecise_Wall(this))
            {
                this.powerUpsList.remove(this.powerUpsList.get(i));
                this.powerUpsList.trimToSize();
            }
        }
        
        //check for powerups hitting paddle and set up powerup if they did
        for(int i = 0; i < this.powerUpsList.size(); i++)
        {
            if(this.powerUpsList.get(i).isCollidingPrecise_Paddle(this.paddle))
            {
                this.setPowerUpState_UpdateMultiplier(this.powerUpsList.get(i).getPowerUpIndex(), true);
                switch(this.powerUpsList.get(i).getPowerUpIndex())
                {
                    case 0:
                        this.ball.setXVelocity(this.ball.getXVelocity() / Math.abs(this.ball.getXVelocity()) * 9);
                        this.ball.setYVelocity(this.ball.getYVelocity() / Math.abs(this.ball.getYVelocity()) * 9);
                        break;
                    case 1:
                        this.ball.setXVelocity(this.ball.getXVelocity() / Math.abs(this.ball.getXVelocity()) * 5);
                        this.ball.setYVelocity(this.ball.getYVelocity() / Math.abs(this.ball.getYVelocity()) * 5);
                        break;
                    case 2:
                        this.paddle.changePaddleSize(this, 300);
                        break;
                    case 3:
                        this.paddle.changePaddleSize(this, 100);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
                this.powerUpsList.remove(this.powerUpsList.get(i));
                this.powerUpsList.trimToSize();
            }
        }
        
        //check for expired powerups and remove them
        for(int i = 0; i < 6; i++)
        {
            if(this.powerUpState[i])
            {
                if(this.powerUpFrameEnd[i] <= this.frameNumber)
                {
                    switch(i)
                    {
                        case 0:
                            this.ball.setXVelocity(this.ball.getXVelocity() / Math.abs(this.ball.getXVelocity()) * 7);
                            this.ball.setYVelocity(this.ball.getYVelocity() / Math.abs(this.ball.getYVelocity()) * 7);
                            break;
                        case 1:
                            this.ball.setXVelocity(this.ball.getXVelocity() / Math.abs(this.ball.getXVelocity()) * 7);
                            this.ball.setYVelocity(this.ball.getYVelocity() / Math.abs(this.ball.getYVelocity()) * 7);
                            break;
                        case 2:
                            this.paddle.changePaddleSize(this, 200);
                            break;
                        case 3:
                            this.paddle.changePaddleSize(this, 200);
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                    }
                    this.setPowerUpState_UpdateMultiplier(i, false);
                }
            }
        }
        
        //check for ball collisions with wall and update velocity
        this.ball.isCollidingPrecise_Walls_UpdateVelocity(this);
        
        //check for ball collisions with paddle and update velocity
        this.ball.isCollidingPrecise_GameObjects_UpdateVelocity(this.paddle, this, this.frameNumber);
        
        //check for ball collisions with obsacle and update velocity
        this.ball.isCollidingPrecise_GameObjects_UpdateVelocity(this.obstacle, this, this.frameNumber);
        
        //check for ball collisions with bricks, update velocity, remove broken bricks, and chance to add new powerup
        for(int i = 0; i < this.brickList.size(); i++)
        {
            boolean flag = this.ball.isCollidingPrecise_GameObjects_UpdateVelocity(this.brickList.get(i), this, this.frameNumber);
            if((this.brickList.get(i)).getHitsLeft() <= 0)
            {
                if(GamePanel.RAND.nextInt(3) == 0)
                {
                    this.powerUpsList.ensureCapacity(this.powerUpsList.size() + 1);
                    this.powerUpsList.add(new PowerUp((this.brickList.get(i)).getXPosition(), (this.brickList.get(i)).getYPosition()));
                }
                this.brickList.remove((this.brickList.get(i)));
                this.brickList.trimToSize();
            }
            if(flag)
            {
                break;
            }
        }
        
        //check for collisions with obstacle and wall
        this.obstacle.isCollidingPrecise_UpdateVelocity(this);
        
        //move game objects
        this.paddle.move(this);
        this.obstacle.move();
        this.ball.move();
        for(int i = 0; i < this.powerUpsList.size(); i++)
        {
            this.powerUpsList.get(i).move();
        }
        
    }
   
    /**
     * Constructor method for GamePanel class.
     * It is not necessary for you to modify this code at all
     */
    public GamePanel()
    {
        // Set the size of the Panel
        this.setSize(this.gameWidth, this.gameHeight);
        this.setPreferredSize(new Dimension(this.gameWidth, this.gameHeight));
        
        this.setBackground(Color.BLACK);
        
        // Call setupGame to initialize fields
        this.setupGame(); 
        
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    /**
     * Method to start the Timer that drives the animation for the game.
     * It is not necessary for you to modify this code unless you need to in 
     *  order to add some functionality. 
     */
    public void start()
    {
        // Set up a new Timer to repeat every 20 milliseconds (50 FPS)
        this.gameTimer = new Timer(1000 / this.framesPerSecond, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                updateGameState();
                repaint();  
            }
        });
        
        this.gameTimer.setRepeats(true);
        this.gameTimer.start();
    }

    
    
}
