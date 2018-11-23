package edu.ky.cchs.degroff.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ky.cchs.degroff.util.TreeResourceUtil;

public class MusicSet
    {

    private String musicFile;
    private boolean isVirtual;
    private List<Instruction> instructions = new ArrayList<>();
    private static TreeResourceUtil util = new TreeResourceUtil();

    public MusicSet( String instructionFile ) throws IOException
        {
        // ----------------------------------------------------------------------
        // Use Scanner to read in the text file
        System.out.println( "Reading instructions [" + instructionFile + "]" );
        try ( InputStream resourceInputStream = util.getResource( instructionFile ) )
            {
            Scanner sc = new Scanner( resourceInputStream );
            // File file = new File( instructionFile );
            // Scanner sc = new Scanner( file );

            // ----------------------------------------------------------------------
            // The first line should be where the MP3 file is found
            musicFile = sc.nextLine().trim();

            // ----------------------------------------------------------------------
            // The first line should be where the MP3 file is found
            setVirtual( Boolean.parseBoolean( sc.nextLine() ) );

            // ----------------------------------------------------------------------
            // The rest of the lines are instructions to add
            while ( sc.hasNextLine() )
                {
                instructions.add( new Instruction( sc.nextLine().trim() ) );
                }
            }
        }

    public String getMusicFile()
        {
        return musicFile;
        }

    public List<Instruction> getInstructions()
        {
        return instructions;
        }

    public boolean isVirtual()
        {
        return isVirtual;
        }

    public void setVirtual( boolean isVirtual )
        {
        this.isVirtual = isVirtual;
        }

    }
