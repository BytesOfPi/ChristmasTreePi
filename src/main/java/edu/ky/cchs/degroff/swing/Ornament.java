package edu.ky.cchs.degroff.swing;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ornament
    {

    private int xPos = 0;
    private int yPos = 0;
    private int width = 0;
    private int height = 0;
    private final int SIZE = 12;
    Color clr;

    public Ornament()
        { // create default object

        Random r = new Random();

        xPos = r.nextInt( 250 );
        yPos = r.nextInt( 250 );

        width = r.nextInt( 250 );
        height = r.nextInt( 250 );

        clr = Color.yellow;

        }

    public Ornament( int xPos, int yPos, Color clr )
        {

        this.xPos = xPos;
        this.yPos = yPos;
        this.clr = clr;

        }

    public void drasw( Graphics g )
        {

        g.setColor( clr );

        g.fillOval( xPos, yPos, SIZE, SIZE );

        }

    }