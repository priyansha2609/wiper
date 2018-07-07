package app.wiper.mapper.interfaces;

import app.wiper.domain.type.ServiceSlot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceSlotMapper
{
    List<ServiceSlot> getAllServiceSlots();
    ServiceSlot getServiceSlotById(Integer slotId);
}
