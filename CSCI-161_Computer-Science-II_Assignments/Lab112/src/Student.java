
import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author Monty Vanderlinde
 * @version 22 November 2017
 * 
 * A class for encapsulating the idea of a student.
 * 
 */
public class Student
{
    //all the traits of the student
    private String fName;
    private String lName;
    private int id;
    private String standing;
    private double gpa;
    
    //the cumulative number of students that have been created
    private static int numberOfStudents = 0;
    
    //helps ensure that no IDs are duplicated
    private static final boolean[] IS_NUMBER_TAKEN = new boolean[10000000];
    
    //a string of chars for helping with random names
    private static final String ALPH = "abcdefghijklmnopqrstuvwxyz";
    
    //for creating random numbers
    private static final Random RAND = new Random();
    
    //for formatting the IDs
    private static final DecimalFormat DF1 = new DecimalFormat("0000000");
    
    //for formatting the GPAs
    private static final DecimalFormat DF2 = new DecimalFormat("#,##0.00");
    
    /**
     * Default Constructor:<BR>
     * Creates a new student with a random first name, last name, standing, GPA, and unique ID.
     */
    public Student()
    {
        this.setRandomFirstName();
        this.setRandomLastName();
        this.setRandomUniqueID();
        this.setRandomStanding();
        this.setRandomGPA();
        
        Student.numberOfStudents++;
    }
    
    /**
     * Private mutator method for setting a random first name.
     */
    private void setRandomFirstName()
    {
        //call the getRandomName method and specify false for a first name
        this.fName = this.getRandomName(false);
    }
    
    /**
     * Private mutator method for setting a random last name.
     */
    private void setRandomLastName()
    {
        //call the getRandomName method and specify true for a last name
        this.lName = this.getRandomName(true);
    }
    
    /**
     * Private mutator method for setting a random name.
     */
    private String getRandomName(boolean isLastName)
    {
        //random number between 0 and 5
        int num = Student.RAND.nextInt(6);
        
        if(isLastName)  //add 10 for random last name length of 10 to 15
            num += 10;
        else  //add 5 for random first name length of 5 to 10
            num += 5;
        
        //get random uppercase character from ALPH list
        String name = String.valueOf(Student.ALPH.charAt(Student.RAND.nextInt(Student.ALPH.length()))).toUpperCase();
        
        //for the rest of the characters
        for(int i = 1; i < num; i++)
        {
            //fill name with random lowercase letters from the ALPH list
            name += String.valueOf(Student.ALPH.charAt(Student.RAND.nextInt(Student.ALPH.length())));
        }
        
        //return the name
        return name;
    }
    
    /**
     * Private mutator method for setting a random, unique ID.
     */
    private void setRandomUniqueID()
    {
        //there are only 10,000,000 unique IDs, so the program may slow as it approaches this
        if(Student.numberOfStudents > 9000000)
            System.err.println("Creating more than 9,000,000 student IDs will severely slow the program.");
        
        do
        {
            //get a random ID number again if the last number was taken
            this.id = RAND.nextInt(10000000);
        }while(Student.IS_NUMBER_TAKEN[this.id]);
        
        //this number has now been taken
        Student.IS_NUMBER_TAKEN[this.id] = true;
    }
    
    /**
     * Private mutator method for setting a random standing, within the given percentages.
     */
    private void setRandomStanding()
    {
        //each number has a 10% chance
        int i = Student.RAND.nextInt(10) + 1;
        
        switch(i)
        {
            case 1:
            case 2:
            case 3:
            case 4:
                this.standing = "freshman";  //40%
                break;
            case 5:
            case 6:
            case 7:
                this.standing = "sophomore";  //30%
                break;
            case 8:
            case 9:
                this.standing = "junior";  //20%
                break;
            case 10:
                this.standing = "senior";  //10%
                break;
        }
    }
    
    /**
     * Private mutator method for setting a random GPA, within the given percentages.
     */
    private void setRandomGPA()
    {
        //each number has a 5% chance
        int i = Student.RAND.nextInt(20) + 1;
        
        switch(i)
        {
            case 1:
                this.gpa = this.randomDoubleUnder1();  //5%
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                this.gpa = 1.0 + this.randomDoubleUnder1();  //20%
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                this.gpa = 2.0 + this.randomDoubleUnder1();  //50%
                break;
            case 16:
            case 17:
            case 18:
            case 19:
                this.gpa = 3.0 + this.randomDoubleUnder1();  //20%
                break;
            case 20:
                this.gpa = 4.00;  //5%
                break;
        }
    }
    
    /**
     * Private mutator method for returning a random double between 0.00 and 0.99.
     */
    private double randomDoubleUnder1()
    {
        return ((double) Student.RAND.nextInt(100)) / 100.0;
    }
    
    /**
     * Accessor method for accessing the student's first name.
     * @return The student's first name.
     */
    public String getFirstName()
    {
        return this.fName;
    }
    
    /**
     * Accessor method for accessing the student's last name.
     * @return The student's last name.
     */
    public String getLastName()
    {
        return this.lName;
    }
    
    /**
     * Accessor method for accessing the student's ID.
     * @return The student's ID.
     */
    public int getID()
    {
        return this.id;
    }
    
    /**
     * Accessor method for accessing the student's standing.
     * @return The student's standing.
     */
    public String getStanding()
    {
        return this.standing;
    }
    
    /**
     * Accessor method for accessing the student's GPA.
     * @return The student's GPA.
     */
    public double getGPA()
    {
        return this.gpa;
    }
    
    /**
     * toString method for converting the student object into a string.
     * @return A string representation of the student object.
     */
    @Override
    public String toString()
    {
        String s = this.getClass().getName() + ":  {";
        s += "Name:  " + this.getFirstName() + " " + this.getLastName() + ", ";
        s += "ID:  " + Student.DF1.format(this.getID()) + ", ";
        s += "Standing:  " + this.getStanding() + ", ";
        s += "GPA:  " + Student.DF2.format(this.getGPA()) + "}";
        return s;
    }
    
    /**
     * equals method for determining the equality of two student objects.
     * @param o The object to compare against.
     * @return The equality of <B>this</B> object and <B>o</B>.
     */
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Student))
            return false;
        
        Student s = (Student) o;
        
        //first name, last names, IDs, standings, and GPAs must all be equal
        return (this.getFirstName().equals(s.getFirstName())) && (this.getLastName().equals(s.getLastName())) && (this.getID() == s.getID()) && (this.getStanding().equals(s.getStanding())) && (Math.abs(this.getGPA() - s.getGPA()) < 0.0001);
    }
}