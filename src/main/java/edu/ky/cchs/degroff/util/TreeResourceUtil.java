package edu.ky.cchs.degroff.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class TreeResourceUtil
    {

    // private static List<String> filePaths = Arrays.asList( new String[] { "./",
    // "./**/instructions/", "./**/music/",
    // "/media/pi/**/instructions/", "/media/pi/**/music/" } );
    // private static List<String> claspathPaths = Arrays.asList( new String[] {
    // "**/instructions/", "**/music/" } );

    private static List<String> instructPaths = Arrays
            .asList( new String[] { "classpath*:", "classpath*:**/instructions/", "file:", "file:./**/instructions/",
                    "file:f:/**/instructions/**/", "file:/media/pi/**/instructions/" } );
    private static List<String> musicPaths = Arrays
            .asList( new String[] { "classpath*:**/music/", "file:", "file:./src/main/resources/music",
                    "file:./**/music/", "file:f:/**/music/**/", "file:/media/pi/**/music/" } );

    private static List<String> allPaths = new ArrayList<>();
    static
        {
        allPaths.addAll( instructPaths );
        allPaths.addAll( musicPaths );
        }

    public InputStream getResource( String val ) throws IOException
        {
        ClassLoader cl = this.getClass().getClassLoader();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver( cl );
        System.out.println( "Attempting to get resource [" + val + "]" );

        // -----------------------------------------------------------
        // Loop through the given paths looking for the file and
        // return InputStream if found.
        Optional<Resource[]> resources = allPaths.stream()
                // -----------------------------------------------------------
                // Map path to resolver
                .map( path -> {
                try
                    {
                    return resolver.getResources( path + val );
                    }
                catch ( IOException e )
                    {
                    // It's bad practice to catch and eat errors like this, but since this is
                    // quick and dirty and I'm not making it robust yet...
                    System.out.println( e );
                    }
                return null;
                } )
                // -----------------------------------------------------------
                // Filter out null results
                .filter( Objects::nonNull )
                // -----------------------------------------------------------
                // Filter length results
                .filter( list -> list.length > 0 )
                // -----------------------------------------------------------
                // Filter length results
                .filter( list -> list[0].exists() ).findAny();

        // -----------------------------------------------------------
        // Return resource
        if ( resources.isPresent() ) return resources.get()[0].getInputStream();

        // -----------------------------------------------------------
        // If nothing found, return null
        return null;

        }

    }
