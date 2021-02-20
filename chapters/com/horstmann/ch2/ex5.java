package com.horstmann.ch2;

public class ex5 {
    /**
     * Describes point in 2D coordinates
     */
    public static class Point {
        /**
         * x-coordinate
         */
        private double x;

        /**
         * y-coordinate
         */
        private double y;

        /**
         * Creates point in the coordinates beginning
         */
        public Point() {
            this.x = 0;
            this.y = 0;
        }

        /**
         * Creates point with the specified coordinates
         * @param x user-defined x-coordinate
         * @param y user-defined y-coordinate
         */
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Provides x-coordinate of a point
         * @return x-coordinate
         */
        public double getX() {
            return this.x;
        }

        /**
         * Provides y-coordinate of a point
         * @return y-coordinate
         */
        public double getY() {
            return this.y;
        }

        /**
         * Moves point along specified coordinates
         * @param x x-value to move on
         * @param y y-value to move on
         * @return translated point
         */
        public Point translate(double x, double y) {
            return new Point(this.x + x, this.y + y);
        }

        /**
         * Scales point coordinates
         * @param scale scale to transform the coordinates
         * @return point with scaled coordinates
         */
        public Point scale(double scale) {
            return new Point(this.x * scale, this.y * scale);
        }
    }

    public static void main(String[] args) {
        Point point = new Point(3,4).translate(1, 3).scale(0.5);
        System.out.printf("x = %.1f, y = %.1f\n", point.getX(), point.getY());
    }
}
