package job.test.InterLink;

/**
 * Created by Dmytro Sagai on 07.10.2016.
 */
public class Position
{
    private double longitude;
    private double latitude;

    public Position(Position newPosition){
        setNewPosition(newPosition);
    }

    public Position(double longitude, double latitude)
    {
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public void setNewPosition(Position newPosition){
        this.longitude = newPosition.longitude;
        this.latitude = newPosition.latitude;
    }



    public double getDistance(Position that){
        double deltaLongitude = that.longitude - this.longitude;
        double deltaLatitude = that.latitude - this.latitude;
        return Math.sqrt(deltaLatitude * deltaLatitude + deltaLongitude * deltaLongitude);
    }
}
