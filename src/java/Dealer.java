
public class Dealer
{
    private Card[] hand = new Card[ 13 ];
    private int handScore;
    private int n;

    public Dealer()
    {
        n = 0;
    }

    public Card show( int i )
    {
        return hand[ i ];
    }

    public void add( Card c )
    {
        hand[ n ] = c;
        n = n+1;
    }

    // Scope this out, can you return multiple cards with one method call
    // Will is call the method again in the other half ( deck.add )
    // the for loop might need to be in the BlackJack.java where deck.add 
    // is to be called
    public void returnCards()
    {
        Card temp = new Card();
        for( int k=0; k<n; k++ )
        {
            cardBack( k );
        }
    }

    public Card cardBack( int i )
    {
        Card temp = new Card();
        temp = hand[ i ];
        hand[ i ] = null;
        n--;
        return temp;
    }

    public int handScore()
    {
        int score = 0;

        for( int k=0; k<n; k++ )
        {
            score = score + hand[ k ].getFaceValue();
        }
        return score;
    }

    public int handAmount()
    {
        return n;
}

}
