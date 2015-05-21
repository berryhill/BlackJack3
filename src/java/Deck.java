
import java.util.*;

public class Deck
{
    private Card top;
    private Card bottom;
    private Card cursor;
    private int n;

    public Deck()
    {
        for( int k=0; k<4; k++ )
        {
            for( int j=1; j<=13; j++ )
            {
                if( n == 0 )
                {
                    Card card = new Card( k, j );
                    top = card;
                    if( n == 0 )n++;
                }
                else if( n == 1 )
                {
                    Card card = new Card( k, j );
                    cursor = top;
                    top = card;
                    top.next = cursor;
                    bottom = cursor;
                    n++;
                }
                else
                {
                    Card card = new Card( k, j );
                    cursor = top;
                    top = card;
                    top.next = cursor;
                    n++;
                }
                // System.out.println( top.getSuite() );
            }
        }
        cursor = top;
        // System.out.println( "Cursor = " + top.next.getSuite() );
    }

    public void shuffle()
    {
        cursor = top;
        if( n == 1 )
        {
            bottom.next = cursor;
            bottom = bottom.next;
            top = top.next;
            cursor.next = null;
            cursor = top;
            n = 52;
        }

        else
        {
            Random r = new Random();
            Card cardTemp;
            int temp;
            temp = r.nextInt( n );
            this.hop( temp );
            cardTemp = cursor.next;
            cursor.next = cursor.next.next;
            bottom.next = cardTemp;
            bottom = cardTemp;
            n--;
            cursor = top;
            this.shuffle();
        }
    }

    public Card deal()
    {
        Card card;
        card = top;
        top = top.next;
        cursor = top;
        n--;
        return card;
    }

    public Card hop( int i )
    {
        for( int k=0; k<i-1; k++ )
        {
            if( cursor.next.next == null )
            {
                 return cursor;
            }
            else
            {
                 cursor = cursor.next;
            }
        }
        return cursor;
    }

    public void add( Card card )
    {
        bottom.next = card;
        bottom = card;
        n++;
        cursor = top;
    }

    public void print()
    {
        cursor = top;
        System.out.println( "vvvvvvvvvvvv" );
        while( cursor.next != null )
        {
                   System.out.println( cursor.getSuite() + " " 
                                   + cursor.getFaceInt() );
                   cursor = cursor.next;
        }
        System.out.println( cursor.getSuite() + " " 
                                + cursor.getFaceInt() );
        cursor = top;
        System.out.println( "Number of cards is " + n );
        System.out.println( "^^^^^^^^^^^^" );
    }

    public void cardsLeft()
    {
        System.out.println( n );
    }

}
