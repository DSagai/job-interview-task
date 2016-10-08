package job.test.InterLink.weapons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Sagai on 08.10.2016.
 */
public enum WeaponFactory
{
    Rifle(true, false),
    Gun(true, false),
    AutoRifle(true, false),
    MachineGun(false, false),
    Howitzer(false, false),
    Cannon(false, false),
    AirToAir(false, true),
    AirToSurface(false, true),
    SurfaceToAir(false, true);

    private final boolean IS_LIGHT_WEAPON;
    private final boolean IS_MISSLE;

    private WeaponFactory(boolean isLightWeapon, boolean isMissle){
        IS_LIGHT_WEAPON = isLightWeapon;
        IS_MISSLE = isMissle;
    }

    public static FireArms getFireArms(boolean isLight){
        List<WeaponFactory> list = new ArrayList<>();
        for (WeaponFactory item : values()){
            if (item.IS_LIGHT_WEAPON == isLight){
                list.add(item);
            }
        }
        int i = (int)(Math.random() * (list.size() - 1));
        return new FireArms(list.get(i).name());
    }

    public static FireArms getFireArms(String weaponName){
        WeaponFactory weaponType = valueOf(weaponName);
        if (weaponType.IS_MISSLE) throw new IllegalArgumentException(weaponName + " is not a fire arms, it's a missle!");
        return new FireArms(weaponType.name());
    }

    public static Missle getMissle(String missleName){
        WeaponFactory weaponType = valueOf(missleName);
        if (!weaponType.IS_MISSLE) throw new IllegalArgumentException(missleName + " is not a missle, it's a fire arms!");
        switch (weaponType){
            case AirToAir: return new AirToAir(weaponType.name());
            case SurfaceToAir: return new SurfaceToAir(weaponType.name());
            case AirToSurface: return new AirToSurface(weaponType.name());
        }
        return null;
    }

}
