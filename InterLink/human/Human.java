package job.test.InterLink.human;

import job.test.InterLink.Position;
import job.test.InterLink.interfaces.Destroyable;
import job.test.InterLink.interfaces.Moveable;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public class Human implements Moveable, Destroyable
{

    private final double armor;

    private String name;
    private int age;
    private int weight;
    private int height;
    private boolean alive = true;
    private final Position POSITION;

    public Human(String name, int age, int weight, int height, Position position)
    {

        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.armor = 0;
        this.POSITION = new Position(position);
    }

    public Human(String name, int age, int weight, int height, Position position, double armor)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.POSITION = new Position(position);
        this.armor = armor;
    }

    @Override
    public boolean kill()
    {
        if(isAlive())
        {
            alive = false;
            System.out.println(name + " was killed");
            return true;
        }
        else
            return false;
    }

    @Override
    public double getArmor()
    {
        return armor;
    }

    @Override
    public void move(Position newPosition)
    {
        if (!isAlive()) return;
        POSITION.setNewPosition(newPosition);
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean isAlive()
    {
        return alive;
    }

    public Position getPosition()
    {
        return POSITION;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

}
