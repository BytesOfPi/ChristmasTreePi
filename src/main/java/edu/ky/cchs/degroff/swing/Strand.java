package edu.ky.cchs.degroff.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strand
    {
    private static List<Color> randColor = Arrays
            .asList( new Color[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED, Color.YELLOW } );

    private final int DEFAULT_SIZE = 12;
    private int size = DEFAULT_SIZE;
    private List<Light> strand = new ArrayList<>();
    private Color clr;
    private boolean isOn = false;

    public Strand( Color clr )
        {
        super();
        this.clr = (clr.equals( Color.BLACK )) ? randomColor() : clr;
        }

    public void addLight( int xPos, int yPos )
        {
        strand.add( new Light( clr, xPos, yPos ) );
        }

    public void setIsOn( boolean isOn )
        {
        this.isOn = isOn;
        }

    public void draw( Graphics g )
        {
        strand.stream().forEach( light -> light.draw( g, isOn ) );
        }

    private Color randomColor()
        {
        int iRand = (int) (Math.random() * randColor.size());
        return randColor.get( iRand );
        }

    }
