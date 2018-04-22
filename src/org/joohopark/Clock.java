package org.joohopark;

public class Clock{
    
    private int ticks,
                frames;
    private long lastUpdate,
                  elapsedTime,
                  lastTimer;
    private double delta;
    private final double nsPerTick = 1000000000D / 60D;
    
    public Clock(){
        
        this.ticks = 0;
        this.frames = 0;
        this.lastUpdate = 0l;
        this.elapsedTime = 0l;
        this.lastTimer = System.currentTimeMillis();
        this.delta = 0D;
        
    }
    
    public boolean timer(){
      
      long now = System.nanoTime();
      delta += (lastUpdate - now) / nsPerTick;
      lastUpdate = now;
      boolean shouldRender = false;
      
      while(delta > 0){
        ticks++;
        tick();
        delta--;
        shouldRender = true;
      }
      
      
      if (System.currentTimeMillis() - lastTimer > 1000){
        System.out.println("frames: "+ frames + ", ticks: "+ ticks);
        lastTimer += 1000;
        frames = 0;
        ticks = 0;
      }

      return shouldRender;
    }
    
    private void tick(){}
    
    public static final float getTime(){
        return (System.nanoTime() / 1000000);
    }
    
}
