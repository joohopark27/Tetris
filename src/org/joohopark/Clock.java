package org.joohopark;

public class Clock{
    
    private float lastUpdate,
                  elapsedTime;
    
    
    public Clock(){
        
        this.lastUpdate = 0;
        this.elapsedTime = 0;
        
    }
    
    public static final float getTime(){
        return (System.nanoTime() / 1000000);
    }
    
}
