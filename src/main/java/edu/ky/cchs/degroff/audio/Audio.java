package edu.ky.cchs.degroff.audio;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//import javax.media.Format;
//import javax.media.Manager;
//import javax.media.MediaLocator;
//import javax.media.Player;
//import javax.media.PlugInManager;
//import javax.media.format.AudioFormat;

import edu.ky.cchs.degroff.util.TreeResourceUtil;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio
    {
    private static Player player = null;
    // // "data/audioFiles/abc.mp3"
    // public static void playMP3( String mp3Location )
    // {
    // Format input1 = new AudioFormat( AudioFormat.MPEGLAYER3 );
    // Format input2 = new AudioFormat( AudioFormat.MPEG );
    // Format output = new AudioFormat( AudioFormat.LINEAR );
    // PlugInManager.addPlugIn( "com.sun.media.codec.audio.mp3.JavaDecoder", new
    // Format[] { input1, input2 },
    // new Format[] { output }, PlugInManager.CODEC );
    // try
    // {
    // Player player = Manager.createPlayer( new MediaLocator( new File( mp3Location
    // ).toURI().toURL() ) );
    // player.start();
    // }
    // catch ( Exception ex )
    // {
    // ex.printStackTrace();
    // }
    // }
    private static TreeResourceUtil util = new TreeResourceUtil();

    public static void playMP3New( String mp3Location )
        {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool( 1 );

        executor.submit( () -> {
        try
            {
            player = new Player( util.getResource( mp3Location ) );
            player.play();
            }
        catch ( JavaLayerException | IOException ex )
            {
            ex.printStackTrace();
            }
        } );
        executor.shutdown();
        }

    public static int getTime()
        {
        if ( player != null ) { return player.getPosition(); }
        System.out.println( "1" );
        return 0;
        }
    }
