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
    private String title;
    private String category;
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
            // Grab the next line. If it has a colon in it, it's an old instruction
            // otherwise, it is newer and has the Title and Category in it
            String check = sc.nextLine().trim();
            if ( check.contains( ":" ) || check.contains( "\t" ) )
                {
                setTitle( instructionFile );
                setCategory( "Miscellaneous" );
                instructions.add( new Instruction( check ) );
                }
            else
                {
                setTitle( check );
                setCategory( sc.nextLine().trim() );
                }

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

    public String getTitle()
        {
        return title;
        }

    public void setTitle( String title )
        {
        this.title = title;
        }

    public String getCategory()
        {
        return category;
        }

    public void setCategory( String category )
        {
        this.category = category;
        }

    }
