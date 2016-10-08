package job.test.InterLink.vehicle;

import job.test.InterLink.Position;
import job.test.InterLink.human.Trooper;
import job.test.InterLink.interfaces.Transport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Sagai on 08.10.2016.
 */
public class ArmoredPersonnelCarrier extends Vehicle implements Transport
{
    private final List<Trooper> TROOPERS = new ArrayList<>();

    public ArmoredPersonnelCarrier(String name, double armor, Position position)
    {
        super(name, armor, position);
    }

    @Override
    public void putTroopers(List<Trooper> troopers)
    {
        if (!isAlive()) return;

        TROOPERS.addAll(troopers);
    }

    @Override
    public List<Trooper> popTroopers()
    {
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
}
