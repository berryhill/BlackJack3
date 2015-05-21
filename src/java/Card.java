
public class Card
{
    public Card next;
    public String suite;
    public int faceValue;
    private int suiteInt;
    private int faceInt;


    public Card( int suiteI, int faceI )
    {
        // System.out.println( suiteI + " " + faceI );
        faceInt = faceI;

        if( faceI > 10 )
        {
            faceValue = 10;
        }
        else if( faceI == 1 )
        {
            faceValue = 11;
        }
        else
        {
            faceValue = faceI;
        }

        if( suiteI == 0 )
        {
            suite = "Diamonds";
        }
        else if( suiteI == 1 )
        {
            suite = "Hearts";
        }
        else if( suiteI == 2 )
        {
            suite = "Spades";
        }
        else // suiteI == 3
        {
            suite = "Clubs";
        }
        suiteInt = suiteI;
    }

    public Card()
    {
    }

    public int getFaceInt()
    {
        return faceInt;
    }

    public int getFaceValue()
    {
        return faceValue;
    }

    public String getSuite()
    {
        return suite;
    }

}
