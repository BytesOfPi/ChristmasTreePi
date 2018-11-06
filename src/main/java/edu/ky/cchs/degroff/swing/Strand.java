package edu.ky.cchs.degroff.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Strand
    {

    private final int DEFAULT_SIZE = 12;
    private int size = DEFAULT_SIZE;
    List<Light> strand = new ArrayList<>();
    Color clr;
    boolean isOn = false;

    public Strand( Color clr )
        {
        super();
        this.clr = clr;
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
    }
