package texture;

import color.Color;
import java.util.Objects;

/**
 * This class represents a texture with only one color
 * @author Christian Mehns
 */
public class SingleColorTexture implements Texture{

    /**
     * texture color
     */
    public final Color color;

    /**
     * Constructor
     * constructs a new texture with only one color
     * @param color texture color
     */
    public SingleColorTexture(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor(double u, double v) {
        return color;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SingleColorTexture other = (SingleColorTexture) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SingleColorTexture{" + "color=" + color + '}';
    }
}
