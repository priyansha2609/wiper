package app.wiper.domain.type;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class ServiceSlot
{
    Integer slotId;
    Time startTime;
    Time endTime;
    Boolean isActive;
    Integer orderId;

    @Override
    public String toString()
    {
        return startTime.toString() + "-" + endTime.toString();
    }
}
