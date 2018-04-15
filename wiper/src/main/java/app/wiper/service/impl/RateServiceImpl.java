package app.wiper.service.impl;

import app.wiper.domain.core.Rate;
import app.wiper.mapper.interfaces.RateMapper;
import app.wiper.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RateServiceImpl implements RateService
{
    @Autowired
    private RateMapper rateMapper;

    private Integer upsertRate(Rate rate)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("rate", rate);
        rateMapper.upsertServiceRate(params);
        return (Integer) params.get("rateId");
    }

    @Override
    public Integer insertRate(Rate rate)
    {
        return upsertRate(rate);
    }

    @Override
    public Integer updateRate(Rate rate)
    {
        return upsertRate(rate);
    }
}
