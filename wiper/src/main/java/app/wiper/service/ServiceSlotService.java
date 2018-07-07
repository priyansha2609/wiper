package app.wiper.service;

import app.wiper.domain.type.ServiceSlot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceSlotService
{
    List<ServiceSlot> getAllServiceSlots();
    ServiceSlot getServiceSlotById(Integer slotId);
}
