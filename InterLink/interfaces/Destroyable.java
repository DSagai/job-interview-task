package job.test.InterLink.interfaces;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public interface Destroyable extends Locationable, Named
{
    boolean kill();
    double getArmor();
    boolean isAlive();
}
