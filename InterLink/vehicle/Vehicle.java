package job.test.InterLink.vehicle;

import job.test.InterLink.Position;
import job.test.InterLink.human.CrewMember;
import job.test.InterLink.interfaces.Controllable;
import job.test.InterLink.interfaces.Destroyable;
import job.test.InterLink.interfaces.Moveable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public abstract class Vehicle implements Moveable, Controllable, Destroyable
{
    private final double ARMOR;
    private final List<CrewMember> CREW = new ArrayList<>();
    private final Position POSITION;
    private boolean alive = true;
    private String name;

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    public Vehicle(String name, double armor, Position position)
    {
        this.name = name;
        this.ARMOR = armor;
        this.POSITION = new Position(position);
    }

    public Vehicle(String name, Position position)
    {
        this.name = name;
        final double DEFAULT_ARMOR = 2;
        this.ARMOR = DEFAULT_ARMOR;
        this.POSITION = new Position(position);
    }

    @Override
    public Position getPosition()
    {
        return POSITION;
    }

    @Override
    public void PutCrew(List<CrewMember> crew)
    {
        if (!isAlive()) return;
        CREW.addAll(crew);
    }

    @Override
    public List<CrewMember> popCrew()
    {
        List<CrewMember> members = new ArrayList<>();
        for (int i = CREW.size() - 1; i >=0; i--){
            CrewMember crewMember = CREW.remove(i);
            crewMember.getPosition().setNewPosition(getPosition());
            members.add(crewMember);
        }
        return members;
    }

    @Override
    public boolean hasCrew()
    {
        return !CREW.isEmpty();
    }

    @Override
    public boolean kill()
    {
        for (CrewMember member : CREW){
            member.kill();
        }
        alive = false;
        System.out.println(name + " was killed");
        return true;
    }

    @Override
    public boolean isAlive()
    {
        return alive;
    }

    public double getArmor()
    {
        return ARMOR;
    }

    @Override
    public void move(Position newPosition)
    {
        if (!isAlive() || CREW.isEmpty()) return;
        POSITION.setNewPosition(newPosition);
    }

    boolean isEmpty(){
        return CREW.isEmpty();
    }
}

