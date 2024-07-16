package dev.lofiz.clientbase.module.render;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {

    private float x, y;
    private int width, height;

    public Position(float x, float y) {
        setPosition(x, y);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
