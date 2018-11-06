package edu.ky.cchs.degroff.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicSet
    {

    private String musicFile;
    private boolean isVirtual;
    private List<Instruction> instructions = new ArrayList<>();

    public MusicSet( String instructionFile ) throws FileNotFoundException
        {
        // ----------------------------------------------------------------------
        // Use Scanner to read in the text file
        File file = new File( instructionFile );
        Scanner sc = new Scanner( file );

        // ----------------------------------------------------------------------
        // The first line should be where the MP3 file is found
        musicFile = sc.nextLine();

        // ----------------------------------------------------------------------
        // The first line should be where the MP3 file is found
        setVirtual( Boolean.parseBoolean( sc.nextLine() ) );

        // ----------------------------------------------------------------------
        // The rest of the lines are instructions to add
        while ( sc.hasNextLine() )
            {
            instructions.add( new Instruction( sc.nextLine() ) );
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
