package dev.lofiz.clientbase.module.render;

public interface IRender {

    void render(Position position);

    default void renderDummy(Position position) {
        render(position);
    }
}
