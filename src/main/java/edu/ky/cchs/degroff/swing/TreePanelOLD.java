package edu.ky.cchs.degroff.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TreePanelOLD extends JPanel implements MouseListener, ActionListener
    {
    int MID_X = 250;
    int TOP_Y = 100;
    Color clr = Color.YELLOW;
    Color Magenta = Color.magenta;
    Color White = Color.white;
    Polygon tree;
    JButton magenta, white, on, off;
    // Tree coordinates
    int[] xArr = { MID_X, MID_X + 50, MID_X + 25, MID_X + 100, MID_X + 75, MID_X + 150, MID_X - 150, MID_X - 75,
            MID_X - 100, MID_X - 25, MID_X - 50 };
    int[] yArr = { TOP_Y, TOP_Y + 50, TOP_Y + 50, TOP_Y + 100, TOP_Y + 100, TOP_Y + 150, TOP_Y + 150, TOP_Y + 100,
            TOP_Y + 100, TOP_Y + 50, TOP_Y + 50 };;
    ArrayList<Ornament> ornList;
    boolean blink = false;
    Timer timer;
    int DELAY = 500; // in milliseconds

    public TreePanelOLD()
        {

        ornList = new ArrayList<Ornament>();
        tree = new Polygon( xArr, yArr, yArr.length );
        addMouseListener( this );

        setPreferredSize( new Dimension( 500, 400 ) ); // create program frame
        setOpaque( true );
        setBackground( Color.GRAY );

        magenta = new JButton( "Magenta" ); // button to change color to magenta
        magenta.setBackground( Color.MAGENTA );
        magenta.setOpaque( true );
        magenta.addMouseListener( this );
        add( magenta );

        white = new JButton( "white" ); // button to change color to white
        white.setBackground( Color.WHITE );
        white.setOpaque( true );
        white.addMouseListener( this );
        add( white );

        on = new JButton( "On" ); // Creates ON button for light show
        on.setBackground( Color.GREEN );
        on.setOpaque( true );
        on.addActionListener( this );
        add( on );

        off = new JButton( "Off" ); // Creates OFF button for light show
        off.setBackground( Color.PINK );
        off.setOpaque( true );
        off.addActionListener( this );
        add( off );

        timer = new Timer( DELAY, this ); // Creates timmer

        }

    @Override
    public void paintComponent( Graphics g )
        {

        super.paintComponent( g );

        g.setColor( Color.green );
        g.fillPolygon( tree ); // draw tree
        g.setColor( Color.orange );
        g.fillRect( MID_X - 20, TOP_Y + 150, 50, 50 ); // trunk

        g.drawString( "Count: " + ornList.size(), 5, 15 ); // Count number of ornaments

        if ( blink == false )
            {
            for ( Ornament orn : ornList )
                {
                orn.drasw( g );

                }
            }
        }

    @Override
    public void actionPerformed( ActionEvent e )
        {

        if ( e.getSource().equals( on ) )
            {
            timer.start();
            }

        if ( e.getSource().equals( off ) )
            {
            timer.stop();
            blink = false;
            repaint();
            }

        if ( e.getSource().equals( timer ) )
            {
            if ( blink == true ) blink = false;
            else blink = true;
            repaint();
            }
        }

    @Override
    public void mouseClicked( MouseEvent event )
        {

        Ornament thing = new Ornament( event.getX(), event.getY(), clr );
        if ( tree.contains( event.getPoint() ) )
            {

            ornList.add( thing );
            }
        repaint();

        if ( event.getSource().equals( magenta ) )
            {

            clr = Magenta;
            }
        repaint();

        if ( event.getSource().equals( white ) )
            {

            clr = White;
            }
        repaint();
        }

    @Override
    public void mouseEntered( MouseEvent e )
        {
        // TODO Auto-generated method stub

        }

    @Override
    public void mouseExited( MouseEvent e )
        {
        // TODO Auto-generated method stub

        }

    @Override
    public void mousePressed( MouseEvent e )
        {
        // TODO Auto-generated method stub

        }

    @Override
    public void mouseReleased( MouseEvent e )
        {
        // TODO Auto-generated method stub

        }

    }
