package job.test.InterLink.vehicle;

import job.test.InterLink.Position;
import job.test.InterLink.interfaces.Combat;
import job.test.InterLink.interfaces.Destroyable;
import job.test.InterLink.weapons.FireArms;

/**
 * Created by Dmytro Sagai on 08.10.2016.
 */
public class Tank extends Vehicle implements Combat
{
    private final FireArms WEAPON;

    public Tank(String name,double armor, Position position, FireArms WEAPON)
    {
        super(name, armor, position);
        this.WEAPON = WEAPON;
    }

    @Override
    public boolean attack(Destroyable target)
    {
        if (!isAlive() || isEmpty()) return false;
        return WEAPON.fire(target);
    }
}
