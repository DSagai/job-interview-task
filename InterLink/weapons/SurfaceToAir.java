package job.test.InterLink.weapons;

import job.test.InterLink.interfaces.Destroyable;
import job.test.InterLink.vehicle.Aircraft;


/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public class SurfaceToAir extends Missle
{
    public SurfaceToAir(String weaponType)
    {
        super(weaponType);
    }


    @Override
    public boolean fire(Destroyable target)
    {
        double distance = weaponHolder.getPosition().getDistance(target.getPosition());
        if (target instanceof Aircraft)
        {
            super.fire(target);
            double altitude = ((Aircraft) target).getAltitude();
            distance = Math.sqrt(distance * distance + altitude * altitude);

            if (distance < RANGE)
            {
                target.kill();
                return true;
            }
        }
        return false;
    }
}
