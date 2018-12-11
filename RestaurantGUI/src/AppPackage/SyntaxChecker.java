/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;


import java.util.regex.Pattern;


/**
 *
 * @author itsch
 */
public class SyntaxChecker {
    
    
    public static boolean isValidPhone(String input)
    {
        
        if (input.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$"))
        {
            return true;
        }
        
        
        return false;
    }
    
    public static boolean isValidAlpha(String input)
    {
        
     if (input.matches("^[a-zA-Z]+$"))
        {
            return true;
        }
        
        
        return false;   
    }
    
    public static boolean isValidZip(String input)
    {
        
     if (input.matches("^[0-9]{5}(?:-[0-9]{4})?$"))
        {
            return true;
        }
        
        
        return false;   
    }
    
    
    
    
}
