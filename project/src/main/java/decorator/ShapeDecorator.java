package decorator;

import factory.Shape;

/**
 * Created by licheng on 12/8/17.
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape decoratedShape) {
        this.shape = decoratedShape;
    }

    public void draw() {
        shape.draw();
    }
}
