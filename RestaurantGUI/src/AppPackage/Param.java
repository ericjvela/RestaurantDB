/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

/**
 *
 * @author itsch
 */

//If you update this class, also update RestaurantDisplay
public class Param {
    private String str;
    private float f;
    private double d;
    private int i;
    
    private int type;
    
    public static final int STRING = 0;
    public static final int FLOAT = 1;
    public static final int DOUBLE = 2;
    public static final int INT = 3;
    
    Param(String param)
    {
        type = STRING;
        str = param;
    }
    
    Param(float param)
    {
        type = FLOAT;
        f = param;
    }
    
    Param(double param)
    {
        type = DOUBLE;
        d = param;
    }
    
    Param(int param)
    {
        type = INT;
        i = param;
    }
    
    public int getType()
    {
        return type;
    }
    
    public String getString()
    {
        return str;
    }
    
    public float getFloat()
    {
        return f;
    }
    
    public double getDouble()
    {
        return d;
    }
    
    public int getInt()
    {
        return i;
    }
    
    
    
    
    
    
    
}
