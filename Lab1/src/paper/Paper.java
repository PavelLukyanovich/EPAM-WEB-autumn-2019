package paper;
/** Marker interface for paper shapes.
 *
 * <p>
 *     It have enum "Colors" and one inner class "Painting"
 * </p>
 * */
public interface Paper {
    /**For the color of shapes use enum Colors.
     *
     * @see java.lang.Enum
     */
    enum Colors {
        RED,
        GREY,
        BLACK,
        }
        Colors getColor();

        void setColors(Colors color);

        Painting getPainted();

       class Painting {
           /**@value null
            */
        private Colors color;
           /** This method checks color of shape.
            *
            * @return color
            */
        Colors getColorPainted(){
            return color;
        }
           /** This method checks is "color" = null. If "color" isn't null - paints shape.
            *
            * @param color color of shape
            */
        public void setColorPainted(Colors color){
            if (this.color == null)
                this.color = color;
        }
        @Override
          public String toString(){
            return "Color " + color;
        }

    }
}
