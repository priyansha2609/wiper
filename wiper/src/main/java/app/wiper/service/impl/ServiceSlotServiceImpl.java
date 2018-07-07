package app.wiper.service.impl;

import app.wiper.domain.type.ServiceSlot;
import app.wiper.mapper.interfaces.ServiceSlotMapper;
import app.wiper.service.ServiceSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSlotServiceImpl implements ServiceSlotService
{
    @Autowired
    private ServiceSlotMapper serviceSlotMapper;

    @Override
    public List<ServiceSlot> getAllServiceSlots()
    {
        return serviceSlotMapper.getAllServiceSlots();
    }

    @Override
    public ServiceSlot getServiceSlotById(Integer slotId)
    {
        return serviceSlotMapper.getServiceSlotById(slotId);
    }
}
