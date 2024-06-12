package gameobject.character.enemy;

import gameobject.character.Character;

abstract public class Enemy extends Character {
    int health;
    Double velocity;

    //仮
    public Enemy(int x, int y, int size) {
        super(x, y, size);
    }
}

