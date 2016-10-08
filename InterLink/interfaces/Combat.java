package job.test.InterLink.interfaces;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public interface Combat extends Locationable, Named
{
    boolean attack(Destroyable target);
}
