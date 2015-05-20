
// import javax.swing.*;
// import javax.swing.event.*;
// import java.awt.*;
import java.awt.event.*;

// import java.util.*;
// import java.io.*;

public class BlackJack extends Basic
{
    public static void main( String[] args )
    {
        System.out.println( "RUNING" );
        BlackJack bj = new BlackJack( "BlackJack", 0, 0, 250, 250 );
    }

    public BlackJack bj;
    public Deck d;
    public Player p;
    public Dealer dl;
    public String state;

    public BlackJack( String title, int ulx, int uly, int pw, int ph )
    {
        super( title, ulx, uly, pw, ph );

        d = new Deck();
        p = new Player();
        dl = new Dealer();
        state = "start";

        super.start();
    }

    public void dealerDeal()
    {
        d.shuffle();
        p.add( d.deal() );
        dl.add( d.deal() );
        p.add( d.deal() );
        dl.add( d.deal() );

        System.out.println( "Player's Hand: " + p.show( 0 ).getFaceInt() 
                                + " " + p.show( 0 ).getSuite() 
                                + " | " + p.show( 1 ).getFaceInt()
                                + " " + p.show( 1 ).getSuite()  );

        System.out.println( "Dealer's Hand: " + "X XXXXXXX"
                                + " | " +dl.show( 1 ).getFaceInt()
                                + " " +dl.show( 1 ).getSuite()  );
    }

    public void cardsBack()
    {
        for( int k=dl.handAmount()-1; k>=0; k-- )
        {
            d.add( dl.cardBack( k ) );
        }
        for( int k=p.handAmount()-1; k>=0; k-- )
        {
            d.add( p.cardBack( k ) );
        }
    }

    public boolean compareHands( Player player, Dealer dealer )
    {
        if( dealer.handScore() >= player.handScore() )
        {
            System.out.println( "Dealer Score = " + dl.handScore() );
            System.out.println( "Player Score = " + p.handScore() );
            return true;
        }
        else
        {
            System.out.println( "Dealer Score = " + dl.handScore() );
            System.out.println( "Player Score = " + p.handScore() );
            return false;
        }
    }

    public void dealerPlay()
    {
        if( dl.handScore() > 21 )
        {
            state = "win";
            checkState();
            return;
        }
        else if( dl.handScore() > 16 )
        {
            state = "show";
            checkState();
            return;
        }
        else
        {
            dl.add( d.deal() );
            System.out.println( "New Dealer Card = " 
                            + dl.show( dl.handAmount()-1 ) ); 
            dealerPlay();
        }
    }

    public void checkState()
    {
        if( state.equals( "start" ) )
        {
               // d.print();
            dealerDeal();
            state = "playerTurn";
            checkState();
        }

        else if( state.equals( "playerTurn" ) )
        {
            System.out.println( "Player Score = " + p.handScore() );
            System.out.println( "Player numCards = " + p.handAmount() );
            if( p.handScore() > 21 )
            {
                state = "lose";
                checkState();
            }
        }

        else if( state.equals( "dealerTurn" ) )
        {
            dealerPlay();
        }

        else if( state.equals( "show" ) )
        {
            if( !compareHands( p, dl ) )
            {
                state = "win";
                checkState();
            }
            else
            {
                state = "lose";
                checkState();
            }
        }

        else if( state.equals( "win" ) )
        {
            System.out.println( "WINNER!" );
            cardsBack();
            state = "sit";
            checkState();
        }
        else if( state.equals( "lose" ) )
        {
            System.out.println( "LOSER!" );
            cardsBack();
            state = "sit";
            checkState();
        }
        else // sit
        {
           System.out.println( "Would you like to play again?" );
        }
    }

    public void keyPressed( KeyEvent e )
    {
        int code = e.getKeyCode();

        if( code == KeyEvent.VK_C ) // C for CHECKSTATE 
        {
            checkState();
        }

        else if( code == KeyEvent.VK_H ) // H for HIT
        {
            p.add( d.deal() );
            System.out.println( "Player's New Card= " 
                            + p.show( p.handAmount()-1 ) );
            int code = e.getKeyCode();System.out.println( "Player's Hand Score = " 
                                   + p.handScore() );
            checkState();
        }

        else if( code == KeyEvent.VK_A ) // A for STAY
        {
            state = "dealerTurn";
            checkState();
        }

        else if( code == KeyEvent.VK_S ) // S for Shuffle
        {
            d.shuffle();
        }

        else if( code == KeyEvent.VK_P ) // P for PRINT
        {
            d.print();
        }
        else if( code == KeyEvent.VK_Y ) // Y for YES
        {
            state = "start";
            checkState();
        }    
    }

}