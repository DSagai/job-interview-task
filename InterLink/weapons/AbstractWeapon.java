package job.test.InterLink.weapons;

import job.test.InterLink.interfaces.Combat;
import job.test.InterLink.interfaces.Destroyable;


import java.util.ResourceBundle;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public abstract class AbstractWeapon
{
    protected final double RANGE;
    protected final double PENETRATION;
    protected Combat weaponHolder;
    protected final String RESOURCE_PATH = "job.test.InterLink.weapons.resources.";
    protected final String WEAPON_TYPE;


    public AbstractWeapon(String weaponType)
    {
        WEAPON_TYPE = weaponType;
        ResourceBundle resPenetration = ResourceBundle.getBundle(RESOURCE_PATH+ "penetration");
        ResourceBundle resRange = ResourceBundle.getBundle(RESOURCE_PATH+ "range");
        if (!resPenetration.containsKey(WEAPON_TYPE) || resRange.containsKey(WEAPON_TYPE)) {
            throw new IllegalArgumentException(String.format("No data available for class [%s]",WEAPON_TYPE));
        }
        try
        {
            this.PENETRATION = Double.parseDouble(resPenetration.getString(WEAPON_TYPE));
            this.RANGE = Double.parseDouble(resRange.getString(WEAPON_TYPE));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(String.format("Illegal data for class [%s]", WEAPON_TYPE));
        }
    }

    public void setWeaponHolder(Combat weaponHolder)
    {
        this.weaponHolder = weaponHolder;
    }



    public boolean fire(Destroyable target){
        if (weaponHolder == null) return false;
        System.out.println(weaponHolder.getName() + " is shooting at " + target.getName());
        return true;
    };
}
