
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
        int x2 = x/(-2);
        int y2 = y/(-2);
        
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                points[i][j] = new Point2(x2,y2);
                x2++;
            }
            x2 = x/(-2);
            y2++;
        }
    }
    
}
