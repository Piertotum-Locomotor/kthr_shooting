package gameobject.character.enemy;

import gameobject.character.Character;

abstract public class Enemy extends Character {
    int health;
    Double velocity;

    public Enemy(int x, int y, int size, String name, double bulletOffence, int bulletVelocityX, int bulletVelocityY) {
        super(x, y, size, name, bulletOffence, bulletVelocityX, bulletVelocityY);
    }
}

