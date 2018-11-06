package edu.ky.cchs.degroff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class TryMe
    {

    public static void runThis()
        {

        GpioController gpio = GpioFactory.getInstance();

        Scanner scan = new Scanner( System.in );

        List<Pin> pinMap = Arrays.asList( new Pin[] { RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_07,
                RaspiPin.GPIO_15, RaspiPin.GPIO_16, RaspiPin.GPIO_00, RaspiPin.GPIO_01, RaspiPin.GPIO_02 } );
        List<GpioPinDigitalOutput> newPinMap = new ArrayList<>();
        // for ( Pin p : RaspiPin.allPins() )
        for ( Pin p : pinMap )
            {
            newPinMap.add( createPin( gpio, p, p.getName() ) );
            }

        try
            {
            for ( GpioPinDigitalOutput p : newPinMap )
                {
                System.out.println( p.getName() );
                p.setState( PinState.HIGH );
                scan.nextLine();
                // p.setState( PinState.LOW );
                }
            }
        // catch ( InterruptedException e )
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        finally
            {
            gpio.shutdown();
            }

        }

    private static GpioPinDigitalOutput createPin( GpioController gpio, Pin pin, String name )
        {
        // provision gpio pin and turn off
        final GpioPinDigitalOutput gpioPDO = gpio.provisionDigitalOutputPin( pin, name, PinState.LOW );

        // set shutdown state for this pin
        gpioPDO.setShutdownOptions( true, PinState.LOW );

        return gpioPDO;
        }
    }
