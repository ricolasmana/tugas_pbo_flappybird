import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class score extends Actor
{
    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int score;//membuat variabel skor
    public score(){
        score = 0;//membuat nilai awal 0
    }
    public void act()
    {
        World myWorld = getWorld();
        myWorld.showText(String.valueOf(score), 300, 100);//penempatan skor
    }
    //skor akan bertambah sesuai dengan bambu yang dilewati
    public static void add(int num){
        score += num;
    }
}
