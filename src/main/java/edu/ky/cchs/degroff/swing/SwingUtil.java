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
        Strand white1 = new Strand( Color.WHITE );
        Strand white2 = new Strand( Color.WHITE );
        Strand multi1 = new Strand( Color.BLACK );
        Strand multi2 = new Strand( Color.BLACK );

        int line = 40;
        ArrayList<Integer> evenSpace = new ArrayList<>();
        evenSpace.add( 240 );
        ArrayList<Integer> oddSpace = new ArrayList<>();
        oddSpace.addAll( Arrays.asList( new Integer[] { 230, 250 } ) );

        treeStrands.put( 1, white1 );
        treeStrands.put( 2, blue1 );
        treeStrands.put( 3, red1 );
        treeStrands.put( 4, green1 );
        treeStrands.put( 5, white2 );
        treeStrands.put( 6, blue2 );
        treeStrands.put( 7, red2 );
        treeStrands.put( 8, multi1 );

        treeStrands.get( 8 ).addLight( 100, 100 );
        treeStrands.get( 8 ).addLight( 90, 120 );
        treeStrands.get( 8 ).addLight( 110, 120 );
        treeStrands.get( 8 ).addLight( 80, 140 );
        treeStrands.get( 8 ).addLight( 100, 140 );
        treeStrands.get( 8 ).addLight( 120, 140 );

        addLine( treeStrands.get( 1 ), evenSpace, 40 );
        addLine( treeStrands.get( 1 ), oddSpace, 60 );
        addLine( treeStrands.get( 1 ), evenSpace, 80 );

        addLine( treeStrands.get( 2 ), oddSpace, 100 );
        addLine( treeStrands.get( 2 ), evenSpace, 120 );
        addLine( treeStrands.get( 2 ), oddSpace, 140 );

        addLine( treeStrands.get( 3 ), evenSpace, 160 );
        addLine( treeStrands.get( 3 ), oddSpace, 180 );
        addLine( treeStrands.get( 3 ), evenSpace, 200 );

        trimLine( evenSpace );
        addLine( treeStrands.get( 4 ), evenSpace, 220 );
        addLine( treeStrands.get( 4 ), oddSpace, 240 );
        addLine( treeStrands.get( 4 ), evenSpace, 260 );

        trimLine( oddSpace );
        trimLine( evenSpace );
        addLine( treeStrands.get( 5 ), oddSpace, 280 );
        addLine( treeStrands.get( 5 ), evenSpace, 300 );

        addLine( treeStrands.get( 6 ), oddSpace, 320 );
        addLine( treeStrands.get( 6 ), evenSpace, 340 );

        // trimLine( evenSpace );
        addLine( treeStrands.get( 7 ), oddSpace, 360 );
        addLine( treeStrands.get( 7 ), evenSpace, 380 );

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
