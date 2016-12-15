package code;

import code.Helpers.Rectangle;

public class RectangleIntersection {
    public Rectangle getOverlap(Rectangle r1, Rectangle r2) {
        Rectangle xSect = intersectX(r1, r2);
        Rectangle ySect = intersectY(r1, r2);

        if (xSect == null && ySect == null) {
            return new Rectangle(0, 0, 0, 0);   // No intersection
        }

        return new Rectangle(xSect.leftX, ySect.bottomY, xSect.width, ySect.height);
    }

    private Rectangle intersectX(Rectangle r1, Rectangle r2) {
        int overlap = 0;
        Rectangle intersect = null;

        if (r1.leftX <= r2.leftX && (r1.leftX + r1.width) > r2.leftX) {  // r2 is right of r1
            int r1end = r1.leftX + r1.width;    // End X coord of r1
            int r2end = r2.leftX + r2.width;    // End X coord of r2

            if (r2end >= r1end) {
                // r2 extends past r1
                overlap = Math.abs(r1end - r2.leftX);
            } else {
                // r2 is encapsulated by r1 on the X axis
                overlap = Math.abs(r2end - r2.leftX);

            }
            intersect = new Rectangle(r2.leftX, 0, overlap, 0);
        } else if (r2.leftX <= r1.leftX && (r2.leftX + r2.width) > r1.leftX) { //r2 is left of r1
            int r1end = r1.leftX + r1.width;    // End X coord of r1
            int r2end = r2.leftX + r2.width;    // End X coord of r2

            if (r1end >= r2end) {
                // r1 extends past r2
                overlap = Math.abs(r2end - r1.leftX);
            } else {
                // r1 is encapsulated by r2 on the X axis
                overlap = Math.abs(r1end - r1.leftX);

            }
            intersect = new Rectangle(r1.leftX, 0, overlap, 0);
        }

        return intersect;
    }

    private Rectangle intersectY(Rectangle r1, Rectangle r2) {
        int overlap = 0;
        Rectangle intersect = null;

        if (r1.bottomY <= r2.bottomY && (r1.bottomY + r1.height) > r2.bottomY) {  // r2 is above r1
            int r1end = r1.bottomY + r1.height;    // End X coord of r1
            int r2end = r2.bottomY + r2.height;    // End X coord of r2

            if (r2end >= r1end) {
                // r2 extends past r1
                overlap = Math.abs(r1end - r2.bottomY);
            } else {
                // r2 is encapsulated by r1 on the Y axis
                overlap = Math.abs(r2end - r2.bottomY);

            }
            intersect = new Rectangle(r2.bottomY, 0, overlap, 0);
        } else if (r2.bottomY <= r1.bottomY && (r2.bottomY + r2.height) > r1.bottomY) {  //r2 is below r1
            int r1end = r1.bottomY + r1.height;    // End X coord of r1
            int r2end = r2.bottomY + r2.height;    // End X coord of r2

            if (r1end >= r2end) {
                // r1 extends past r2
                overlap = Math.abs(r2end - r1.bottomY);
            } else {
                // r1 is encapsulated by r2 on the Y axis
                overlap = Math.abs(r1end - r1.bottomY);

            }
            intersect = new Rectangle(r1.bottomY, 0, 0, overlap);
        }

        return intersect;
    }
}
