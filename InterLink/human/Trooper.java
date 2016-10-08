package job.test.InterLink.human;

import job.test.InterLink.Position;
import job.test.InterLink.interfaces.Combat;
import job.test.InterLink.interfaces.Destroyable;
import job.test.InterLink.weapons.FireArms;


/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public class Trooper extends Human implements Combat
{
    private static final double BULLETPROOF_VEST = 5d;
    private FireArms weapon;


    public Trooper(String name, int age, int weight, int height, Position position)
    {
        super(name, age, weight, height, position, BULLETPROOF_VEST);
    }

    @Override
    public boolean attack(Destroyable target)
    {
        if (!isAlive()) return false;
        if (weapon == null) return false;
        return weapon.fire(target);
    }

    public void setWeapon(FireArms weapon){
        if (!isAlive()) return;
        this.weapon = weapon;
        weapon.setWeaponHolder(this);
    }

    public FireArms dropWeapon(){
        FireArms result = weapon;
        weapon = null;
        return result;
    }
}
