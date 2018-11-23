package edu.ky.cchs.degroff.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.ky.cchs.degroff.ITree;
import edu.ky.cchs.degroff.util.TreeResourceUtil;

public class TreeVirtual extends JPanel implements ITree, ActionListener
    {
    private static final long serialVersionUID = 1L;
    private BufferedImage imgTree;
    private JButton bStart;
    Map<Integer, Strand> strands = new HashMap<>();
    private long startTime;
    List<String> timeCapture = new ArrayList<>();
    private static TreeResourceUtil util = new TreeResourceUtil();

    private final String LABEL_VERSE1 = "Verse 1";
    private final String LABEL_VERSE2 = "Verse 2";
    private final String LABEL_BRIDGE = "Bridge";
    private final String LABEL_DUMP = "Time Cap Dump";

    public TreeVirtual()
        {
        construct( System.currentTimeMillis() );
        }

    public TreeVirtual( long startTIme )
        {
        construct( startTIme );
        }

    public void construct( long startTime )
        {
        try
            {
            this.startTime = startTime;
            // -----------------------------------------------------------------------------------
            // Add Start Button
            // imgTree = ImageIO.read( new File( "src/main/resources/Tree.jpg" ) );
            try ( InputStream is = util.getResource( "Tree.jpg" ) )
                {
                imgTree = ImageIO.read( is );
                }

            // -----------------------------------------------------------------------------------
            // Initialize Strands
            strands = SwingUtil.initStrands();

            // -----------------------------------------------------------------------------------
            // Add Time Capture Buttons
            bStart = new JButton( LABEL_VERSE1 ); // button to capture verse 2
            bStart.setBackground( Color.decode( "#66FF33" ) );
            bStart.setOpaque( true );
            bStart.addActionListener( this );
            add( bStart );

            bStart = new JButton( LABEL_VERSE2 ); // button to capture verse 2
            bStart.setBackground( Color.decode( "#DF7401" ) );
            bStart.setOpaque( true );
            bStart.addActionListener( this );
            add( bStart );

            bStart = new JButton( LABEL_BRIDGE ); // Button to capture Bridge
            bStart.setBackground( Color.decode( "#F1C40F" ) );
            bStart.setOpaque( true );
            bStart.addActionListener( this );
            add( bStart );

            // -----------------------------------------------------------------------------------
            // Add Time Capture Dump Button
            bStart = new JButton( LABEL_DUMP ); // button to change color to magenta
            bStart.setBackground( Color.decode( "#FE2E64" ) );
            bStart.setOpaque( true );
            bStart.addActionListener( this );
            add( bStart );
            }
        catch ( IOException ex )
            {
            ex.printStackTrace();
            }
        }

    @Override
    public void init()
        {
        // -----------------------------------------------------------------------------------
        // Show Swing app
        JFrame frame = new JFrame( "Christmas Tree" );
        frame.getContentPane().setPreferredSize( new Dimension( 500, 500 ) );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // -----------------------------------------------------------------------------------
        // Add virtual tree to the frame and display.
        frame.getContentPane().add( this );
        frame.pack();
        frame.setVisible( true );
        }

    @Override
    protected void paintComponent( Graphics g )
        {
        super.paintComponent( g );
        g.drawImage( imgTree, 0, 0, this ); // see javadoc for more info on the parameters

        strands.entrySet().stream().forEach( entity -> entity.getValue().draw( g ) );
        }

    @Override
    public void actionPerformed( ActionEvent actEvent )
        {
        try
            {
            // -----------------------------------------------------------------------------------
            // When a button is pressed, kick off the right function
            String action = actEvent.getActionCommand();
            switch ( action )
                {
                case LABEL_VERSE1:
                    addTimeCapture( " [VERSE 01]" );
                break;
                case LABEL_VERSE2:
                    addTimeCapture( " [VERSE 02]" );
                break;
                case LABEL_BRIDGE:
                    addTimeCapture( " [BRIDGE]" );
                break;
                case LABEL_DUMP:
                    dumpTimeCap();
                }
            }
        catch ( IOException e )
            {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        }

    private void dumpTimeCap() throws IOException
        {
        // -----------------------------------------------------------------------------------
        // Output the time capture to a file for modification
        Path path = Paths.get( "timeDump.out" );
        Files.write( path, timeCapture, StandardCharsets.UTF_8 );
        }

    private void addTimeCapture( String label )
        {
        // -----------------------------------------------------------------------------------
        // Calculate the current time compared to the song
        long timecap = System.currentTimeMillis() - startTime;
        timeCapture.add( timecap + ":XXX:XXX:" + label );
        }

    @Override
    public void turnStrandOn( int channel )
        {
        // -----------------------------------------------------------------------------------
        // Tell this particular strand to turn on
        strands.get( channel ).setIsOn( true );
        }

    @Override
    public void turnStrandOff( int channel )
        {
        // -----------------------------------------------------------------------------------
        // Tell this particular strand to turn off
        strands.get( channel ).setIsOn( false );
        }

    @Override
    public void refresh()
        {
        // -----------------------------------------------------------------------------------
        // Tell swing to repaint the tree
        repaint();
        }

    @Override
    public void shutdown()
        {
        // TODO Auto-generated method stub

        }

    }
