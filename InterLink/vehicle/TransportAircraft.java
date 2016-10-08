package job.test.InterLink.vehicle;

import job.test.InterLink.Position;
import job.test.InterLink.human.Trooper;
import job.test.InterLink.interfaces.Transport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public class TransportAircraft extends Aircraft implements Transport
{
    private final List<Trooper> TROOPERS = new ArrayList<>();

    public TransportAircraft(String name, Position position)
    {
        super(name, position);
    }

    @Override
    public void putTroopers(List<Trooper> troopers)
    {
        if (getAltitude() > 0) throw new IllegalAccessError("Can not load in the air!");
        this.TROOPERS.addAll(troopers);
    }

    @Override
    public List<Trooper> popTroopers()
    {
        if (getAltitude() > 0) throw new IllegalAccessError("Can not unload in the air!");
        List<Trooper> result = new ArrayList<>();
        for (int i = TROOPERS.size() - 1; i >= 0; i--){
            Trooper trooper = TROOPERS.remove(i);
            trooper.getPosition().setNewPosition(getPosition());
            result.add(trooper);
        }
        return result;
    }

    @Override
    public boolean hasTroopers()
    {
        return !TROOPERS.isEmpty();
    }

    @Override
    public boolean kill()
    {
        for (Trooper trooper : TROOPERS){
            trooper.kill();
        }
        return super.kill();
    }
}
