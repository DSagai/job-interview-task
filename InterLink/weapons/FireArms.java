package job.test.InterLink.weapons;

import job.test.InterLink.interfaces.Destroyable;
import job.test.InterLink.vehicle.Aircraft;

import java.util.ResourceBundle;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public class FireArms extends AbstractWeapon
{
    private final int MAX_AMMO_COUNT;
    private final int RAPIDITY_OF_FIRE;

    private int ammoCount;

    public FireArms(String weaponType)
    {
        super(weaponType);
        ResourceBundle resMaxAmmoCount = ResourceBundle.getBundle(RESOURCE_PATH+ "max_ammo_count");
        ResourceBundle resRapydityOfFire = ResourceBundle.getBundle(RESOURCE_PATH+ "rapidity_of_fire");

        if (!resMaxAmmoCount.containsKey(WEAPON_TYPE) || resRapydityOfFire.containsKey(WEAPON_TYPE)) {
            throw new IllegalArgumentException(String.format("No data available for class [%s]",WEAPON_TYPE));
        }
        try
        {
            this.MAX_AMMO_COUNT = Integer.parseInt(resMaxAmmoCount.getString(WEAPON_TYPE));
            this.RAPIDITY_OF_FIRE = Integer.parseInt(resRapydityOfFire.getString(WEAPON_TYPE));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(String.format("Illegal data for class [%s]", WEAPON_TYPE));
        }
        reload();
    }

    public boolean isEmpty(){
        return ammoCount == 0;
    }

    public void reload(){
        ammoCount = MAX_AMMO_COUNT;
    }

    protected double penetrationDistanceModifier(double distance){
        double endPenetration = PENETRATION / 2.0;
        return PENETRATION + (PENETRATION - endPenetration)*(RANGE - distance) / RANGE;
    }

    @Override
    public boolean fire(Destroyable target)
    {
        if (isEmpty()) return false;
        if (target instanceof Aircraft) return false;
        super.fire(target);

        int ammoFired = RAPIDITY_OF_FIRE > ammoCount ? ammoCount : RAPIDITY_OF_FIRE;
        ammoCount -= ammoFired;

        double distance = weaponHolder.getPosition().getDistance(target.getPosition());
        if (distance > RANGE) return false;

        if (target.getArmor() < penetrationDistanceModifier(distance)){
            target.kill();
            return true;
        }

        return false;
    }
}
