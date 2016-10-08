package job.test.InterLink.interfaces;

import job.test.InterLink.human.Trooper;

import java.util.List;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public interface Transport
{
    void putTroopers(List<Trooper> troopers);

    List<Trooper> popTroopers();

    boolean hasTroopers();
}
