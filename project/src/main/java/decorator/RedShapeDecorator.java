package decorator;

import factory.Shape;

/**
 * Created by licheng on 12/8/17.
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape shape){
        System.out.println("Border Color: Red");
    }
}