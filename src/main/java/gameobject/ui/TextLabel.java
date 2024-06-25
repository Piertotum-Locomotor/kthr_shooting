package gameobject.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gameobject.GameObject;

public class TextLabel extends GameObject {
    private String str;
    private int fontStyle;
    private double leftOffset;

    public TextLabel(String str, int x, int y, int size, double velocityX, double velocityY, Color color, int fontStyle, double leftOffset) {
        super(x, y, size, velocityX, velocityY, color);
        setStr(str);
        setFontStyle(fontStyle);
        setLeftOffset(leftOffset);
    }

    public String getStr() {
        return str;
    }

    public int getFontStyle() {
        return fontStyle;
    }

    public double getLeftOffset() {
        return leftOffset;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    public void setLeftOffset(double leftOffset) {
        this.leftOffset = leftOffset;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());

        Font f = new Font(g.getFont().getName(), getFontStyle(), getSize());
        g.setFont(f);

        int strwidth = g.getFontMetrics(f).stringWidth(getStr()); //文字のx方向の長さ

        g.drawString(getStr(), getCoordinateX() - (int)(strwidth * leftOffset), getCoordinateY());
    }

    @Override
    public void task() {
        
    }
    
}
