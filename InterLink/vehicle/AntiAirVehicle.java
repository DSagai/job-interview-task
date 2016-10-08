package job.test.InterLink.vehicle;

import job.test.InterLink.Position;
import job.test.InterLink.interfaces.Combat;
import job.test.InterLink.interfaces.Destroyable;
import job.test.InterLink.weapons.Missle;
import job.test.InterLink.weapons.SurfaceToAir;
import job.test.InterLink.weapons.WeaponFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Sagai on 08.10.2016.
 */
public class AntiAirVehicle extends Vehicle implements Combat
{
    private final int MAX__MISSLE_COUNT = 4;
    private final List<SurfaceToAir> MISSLES = new ArrayList<>();

    public AntiAirVehicle(String name, double armor, Position position)
    {
        super(name, armor, position);
        reloadMissles();
    }


    @Override
    public boolean attack(Destroyable target)
    {
        if (MISSLES.isEmpty() || !isAlive()) return false;
        Missle missle = MISSLES.remove(MISSLES.size() - 1);
        missle.fire(target);
        return false;
    }

    public void reloadMissles(){
        for (int i = MISSLES.size(); i < MAX__MISSLE_COUNT; i++){
            SurfaceToAir surfaceToAir = (SurfaceToAir)WeaponFactory.getMissle("SurfaceToAir");
            surfaceToAir.setWeaponHolder(this);
            MISSLES.add(surfaceToAir);
        }
    }
}
