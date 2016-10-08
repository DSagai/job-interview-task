package job.test.InterLink.weapons;

import job.test.InterLink.interfaces.Destroyable;
import job.test.InterLink.vehicle.Aircraft;

/**
 * Created by Dmytro Sagai on 08.10.2016.
 */
public class AirToSurface extends Missle
{
    public AirToSurface(String weaponType)
    {
        super(weaponType);
    }

    @Override
    public boolean fire(Destroyable target)
    {
        double distance = weaponHolder.getPosition().getDistance(target.getPosition());
        if (!(target instanceof Aircraft))
        {
            super.fire(target);

            if (distance < RANGE)
            {
                target.kill();
                return true;
            }
        }
        return false;
    }
}
