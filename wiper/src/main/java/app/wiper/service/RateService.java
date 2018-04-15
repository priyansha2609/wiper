package app.wiper.service;

import app.wiper.domain.core.Rate;
import org.springframework.stereotype.Service;

@Service
public interface RateService
{
    Integer insertRate(Rate rate);
    Integer updateRate(Rate rate);
}
