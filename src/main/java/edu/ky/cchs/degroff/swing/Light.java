package edu.ky.cchs.degroff.swing;

import java.awt.Color;
import java.awt.Graphics;

public class Light
    {

    private int xPos = 0;
    private int yPos = 0;
    private final int DEFAULT_SIZE = 12;
    private int size = DEFAULT_SIZE;
    Color clr;

    public Light( Color clr, int xPos, int yPos )
        {
        this.clr = clr;
        this.xPos = xPos;
        this.yPos = yPos;

        }

    public Light( Color clr, int xPos, int yPos, int size )
        {
        this.clr = clr;
        this.xPos = xPos;
        this.yPos = yPos;
        this.size = size;
        }

    public void draw( Graphics g, boolean isOn )
        {
        g.setColor( isOn ? clr : Color.LIGHT_GRAY );
        g.fillOval( xPos, yPos, size, size );
        }

    }