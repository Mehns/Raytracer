
package sampling;

import mathlibrary.Point2;

/**
 *
 * @author Lena
 */
public class SamplingPattern {

    /**
     * Array for pattern
     */
    public final Point2[][] points;
    
    /**
     * Constructs a new pattern
     * @param x width of pattern
     * @param y height of pattern
     */
    public SamplingPattern(int x, int y) {
 
        points = new Point2[x][y];
        double x2 = 1.0/(x-1.0);
        double y2 = 1.0/(x-1.0);
        
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                points[i][j] = new Point2(x2,y2);
                x2++;
            }
            x2 = 1.0/(x-1.0);
            y2++;
        }
    }
    
}
