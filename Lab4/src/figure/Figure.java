package figure;

import java.io.Serializable;

/**This class "Figure" is parent for all shapes.
 */
public abstract class Figure implements Serializable {
    /** Calculating perimeter of shape
     *
     * @return perimeter of a shape
     */
    public abstract double getPerimeter();
    /** Calculating area of shape
     *
     * @return are of a shape
     */
    public abstract double getArea();
    /** Calculating parameters for cutting shape from shape
     *
     * @return double value parameter of shape
     */
    public abstract double getMinSize();

    @Override
    public String toString() {
        return "Figure";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return getClass() == o.getClass();
    }

}
