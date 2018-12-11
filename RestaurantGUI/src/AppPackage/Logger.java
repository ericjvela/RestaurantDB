/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author itsch
 */
public class Logger {
    
    public static void append(String input)
    {
        String filename = "Log.txt";
        
        
        try
        {
           
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.append('\n');
            writer.append(input);

            writer.close();
        }
        catch (IOException e)
        {
            try
            {
        
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(input);

            writer.close();   
        
            }
            catch(IOException f)
            {
                System.out.println("Error: could not be logged");
            }
        }
    }

    static void append(Exception e) {
        append(e.toString());
    }
    
    
    
    
    
    
}
