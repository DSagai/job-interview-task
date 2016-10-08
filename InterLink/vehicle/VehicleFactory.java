package job.test.InterLink.vehicle;

import job.test.InterLink.Position;
import job.test.InterLink.weapons.FireArms;
import job.test.InterLink.weapons.WeaponFactory;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public enum VehicleFactory
{
    LightTank,
    HeavyTank,
    ArmoredPersonnelCarrier,
    AntiAirVehicle,
    TransportAircraft;


    private static int counter = 0;
    private static final double LIGHT_TANK_ARMOR = 40d;
    private static final double HEAVY_TANK_ARMOR = 500d;
    private static final double APC_ARMOR = 20d;
    private static final double AAV_ARMOR = 10d;
    private static final Position FACTORY_DESTINATION = new Position(1, 1);


    public static Vehicle getVehicle(String vehicleName){
        VehicleFactory type = valueOf(vehicleName);
        String name = vehicleName + "#" + ++counter;
        Vehicle vehicle = null;
        switch (type){
            case LightTank:{
                FireArms weapon = WeaponFactory.getFireArms("MachineGun");
                return new Tank(name, LIGHT_TANK_ARMOR, FACTORY_DESTINATION, weapon);
            }
            case HeavyTank:{
                FireArms weapon = WeaponFactory.getFireArms("Cannon");
                return new Tank(name, HEAVY_TANK_ARMOR, FACTORY_DESTINATION, weapon);
            }
            case AntiAirVehicle:{
                return new AntiAirVehicle(name, AAV_ARMOR, FACTORY_DESTINATION);
            }
            case ArmoredPersonnelCarrier:{
                return new ArmoredPersonnelCarrier(name, APC_ARMOR, FACTORY_DESTINATION);
            }
            case TransportAircraft:{
                return new TransportAircraft(name, FACTORY_DESTINATION);
            }
        }

        return null;
    }

}
