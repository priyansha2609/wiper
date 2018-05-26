package app.wiper.service.gateway;

import app.wiper.domain.core.Payment;
import org.springframework.stereotype.Service;

@Service
public interface GatewayManager
{
    public void makePayment(final Payment payment);
}
