package edu.ky.cchs.degroff.swing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SwingUtil
    {

    public static Map<Integer, Strand> initStrands()
        {
        Map<Integer, Strand> treeStrands = new HashMap<>();

        Strand green1 = new Strand( Color.GREEN );
        Strand green2 = new Strand( Color.GREEN );
        Strand blue1 = new Strand( Color.BLUE );
        Strand blue2 = new Strand( Color.BLUE );
        Strand red1 = new Strand( Color.RED );
        Strand red2 = new Strand( Color.RED );
        Strand multi1 = new Strand( Color.GREEN );
        Strand multi2 = new Strand( Color.GREEN );

        int line = 40;
        ArrayList<Integer> evenSpace = new ArrayList<>();
        evenSpace.add( 240 );
        ArrayList<Integer> oddSpace = new ArrayList<>();
        oddSpace.addAll( Arrays.asList( new Integer[] { 230, 250 } ) );

        treeStrands.put( 1, green1 );
        treeStrands.put( 2, blue1 );
        treeStrands.put( 3, red1 );
        treeStrands.put( 4, green2 );
        treeStrands.put( 5, blue2 );
        treeStrands.put( 6, red2 );
        treeStrands.put( 7, multi1 );
        treeStrands.put( 8, multi2 );

        addLine( green1, evenSpace, 40 );
        addLine( green1, oddSpace, 60 );
        addLine( green1, evenSpace, 80 );

        addLine( blue1, oddSpace, 100 );
        addLine( blue1, evenSpace, 120 );
        addLine( blue1, oddSpace, 140 );

        addLine( red1, evenSpace, 160 );
        addLine( red1, oddSpace, 180 );
        addLine( red1, evenSpace, 200 );

        trimLine( evenSpace );
        addLine( green2, evenSpace, 220 );
        addLine( green2, oddSpace, 240 );
        addLine( green2, evenSpace, 260 );

        trimLine( oddSpace );
        trimLine( evenSpace );
        addLine( blue2, oddSpace, 280 );
        addLine( blue2, evenSpace, 300 );
        addLine( blue2, oddSpace, 320 );

        // trimLine( evenSpace );
        addLine( red2, evenSpace, 340 );
        addLine( red2, oddSpace, 360 );
        addLine( red2, evenSpace, 380 );

        return treeStrands;
        }

    public static void trimLine( ArrayList<Integer> xPosVals )
        {
        xPosVals.remove( 0 );
        xPosVals.remove( xPosVals.size() - 1 );
        }

    public static void addLine( Strand strand, ArrayList<Integer> xPosVals, int yPos )
        {
        // -----------------------------------------------------------------------------------
        // Add lights to the line
        for ( Integer xPos : xPosVals )
            {
            strand.addLight( xPos.intValue(), yPos );
            }
        // -----------------------------------------------------------------------------------
        // For the next strand add 1 to the beginning and end spaced 20 px apart
        xPosVals.add( 0, Integer.valueOf( xPosVals.get( 0 ).intValue() - 20 ) );
        xPosVals.add( Integer.valueOf( xPosVals.get( xPosVals.size() - 1 ).intValue() + 20 ) );
        }

    }
