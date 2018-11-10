package edu.ky.cchs.degroff;

import java.io.IOException;
import java.util.List;

import edu.ky.cchs.degroff.audio.Audio;
import edu.ky.cchs.degroff.model.Instruction;
import edu.ky.cchs.degroff.model.MusicSet;
import edu.ky.cchs.degroff.pi.TreePi;
import edu.ky.cchs.degroff.swing.TreeVirtual;

public class ChristmasTreeRunner
    {

    private ChristmasTreeRunner()
        {
        // TODO Auto-generated constructor stub
        }

    public static void main( String[] args ) throws InterruptedException, IOException
        {
        // ----------------------------------------------------------------------
        // Set up the first music set instructions
        String inFile = "instructions/JingleBells.txt";
        // String inFile = "instructions/bing.txt";
        if ( args.length > 0 )
            {
            System.out.println( args[0] );
            inFile = args[0];
            }
        MusicSet set = new MusicSet( inFile );

        // ----------------------------------------------------------------------
        // Pull off the first instruction
        int iCnt = 0;
        List<Instruction> instructions = set.getInstructions();
        Instruction nextInstruct = instructions.get( iCnt++ );
        Long nextTime = nextInstruct.getTime();

        // ----------------------------------------------------------------------
        // Start playing the right file
        System.out.println( "Reading music [" + set.getMusicFile() + "]" );
        Audio.playMP3New( set.getMusicFile() );

        // ----------------------------------------------------------------------
        // Start the timer
        long startTime = System.currentTimeMillis();
        // ----------------------------------------------------------------------
        // Start the tree
        ITree tree = set.isVirtual() ? new TreeVirtual( startTime ) : new TreePi();
        tree.init();

        try
            {
            // ----------------------------------------------------------------------
            // Continue to loop while there are instructions
            while ( iCnt <= instructions.size() )
                {
                // ----------------------------------------------------------------------
                // if the next instruction is now or passed...
                if ( nextTime <= System.currentTimeMillis() - startTime )
                    {
                    Long holdTime = nextTime;
                    // ----------------------------------------------------------------------
                    // Execute instructions
                    nextInstruct.setTree( tree );
                    // ----------------------------------------------------------------------
                    // Get Next Instruction
                    nextInstruct = instructions.get( iCnt++ );
                    nextTime = nextInstruct.getTime();
                    }

                }
            }
        finally
            {
            System.out.println( "SHUTDOWN" );
            tree.shutdown();
            System.exit( 0 );
            }

        }

    }
