package edu.ky.cchs.degroff.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TreeUtil
    {

    public static InputStream getResource( String val ) throws IOException
        {
        System.out.println( "Attempting to get resource [" + val + "]" );
        Resource resource = new ClassPathResource( val );
        if ( resource.exists() ) { return resource.getInputStream(); }
        File initialFile = new File( val );
        return new FileInputStream( initialFile );

        }

    }
