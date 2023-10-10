import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class flappybird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flappybird extends Actor
{
    private double g = 1;
    private int y = 300;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacross = false;
    private boolean hasaddscore = false;
    public flappybird(){
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }
    /**
     * Act - do whatever the flappybird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        // Jika tekan spasi, koordinat y akan berkurang dan terbang ke atas
        if(spacePressed()){
            g = -2;
        }
        g += 0.1;//Nilai g meningkat 0,1 setiap saat
        y += g;//Nilai y tidak akan berubah dengan kecepatan konstan
        setLocation(getX(), (int)(y));
        //jika menabrak bambu maka flappybird mati
        if(isTouchBambu()){
            isalive = false;
        }
        if(isAtEdge()){
            Greenfoot.playSound("peng.mp3");
            isalive = false;
        }
        //jika jatuh atau menabrak bambu maka flappybird hilang
        if(!isalive){
            getWorld().addObject(new gameover(), 300, 200);
            getWorld().removeObject(this);
        }
        //penambahan skor setelah melewati bambu dan pemberian suara
        if(!hasaddscore && isacross && isalive){
            Greenfoot.playSound("score.mp3");
            score.add(1);
        }
        hasaddscore = isacross;
    }
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("space")){
            if(!haspressed){//pemberian suara
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            haspressed = true;
        }else{
            haspressed = false;
        }
        return pressed;
    }
    //pemberian suara ketika menabrak pipa dan jatuh
    public boolean isTouchBambu(){
        isacross = false;
        for(bambu Bambu : getWorld().getObjects(bambu.class)){
            if(Math.abs(Bambu.getX() - getX()) < 69){
                if(Math.abs(Bambu.getY() + 30 - getY()) > 37){
                Greenfoot.playSound("peng.mp3");
                isalive = false;
                }
                isacross = true;
            }
        }
        return !isalive;
    }
}
