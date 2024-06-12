abstract public class Enemy extends Character {
    int health;
    Double velocity;

    //仮
    public Enemy(int x, int y, int size) {
        super(x, y, size);
    }
    
    String getName(){
        return super.name;
    }
    double getBulletOffence(){
        return super.bulletOffence;
    }
    double getBulletVelocity(){
        return super.bulletVelocity;
    }
    void setName(String name){
        super.name = name;
    }
    void setBulletOffence(Double bulletOffence){
        super.bulletOffence = bulletOffence;
    }
    void setBulletVelocity(Double bulletVelocity){
        super.bulletVelocity = bulletVelocity;
    }
}

