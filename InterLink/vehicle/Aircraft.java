package job.test.InterLink.vehicle;

import job.test.InterLink.Position;
import job.test.InterLink.human.CrewMember;

import java.util.List;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public class Aircraft extends Vehicle
{
    private double altitude;

    public Aircraft(String name,Position position)
    {
        super(name, position);
        altitude = 0;
    }


    @Override
    public void move(Position newPosition)
    {
        if (!isAlive()) return;
        takeoff();
        super.move(newPosition);
        land();
    }

    @Override
    public void PutCrew(List<CrewMember> crew)
    {
        if (!isAlive()) return;
        if (getAltitude() > 0) throw new IllegalAccessError("Can not load in the air!");
        super.PutCrew(crew);
    }

    @Override
    public boolean kill()
    {
        land();
        return super.kill();
    }

    @Override
    public List<CrewMember> popCrew()
    {
        if (getAltitude() > 0) throw new IllegalAccessError("Can not unload in the air!");
        return super.popCrew();
    }

    private void takeoff(){
        altitude = 10000d;
    }

    private void land(){
        altitude = 0;
    }

    public double getAltitude()
    {
        return altitude;
    }
}
