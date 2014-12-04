package material;

import color.Color;
import geometry.Hit;
import world.World;
/**
 *
 * @author Christian Mehns <s55689@beuth-hichschule.de>
 */
public abstract class Material {
    public abstract Color colorFor(final Hit hit, final World world);
}
