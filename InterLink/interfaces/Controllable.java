package job.test.InterLink.interfaces;

import job.test.InterLink.human.CrewMember;

import java.util.List;


/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public interface Controllable
{
    void PutCrew(List<CrewMember> crew);

    List<CrewMember> popCrew();

    boolean hasCrew();

}
