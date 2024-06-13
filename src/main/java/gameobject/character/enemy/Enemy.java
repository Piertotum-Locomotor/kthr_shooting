package gameobject.character.enemy;

import gameobject.character.Character;

import java.awt.*;

abstract public class Enemy extends Character {
    int health;
    Double velocity;

    public Enemy(int x, int y, int size, Color color, String name, double bulletOffence, int bulletVelocityX, int bulletVelocityY, int shootInterval) {
        super(x, y, size, color, name, bulletOffence, bulletVelocityX, bulletVelocityY, shootInterval);
    }
}