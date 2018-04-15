package app.wiper.mapper.interfaces;

import app.wiper.domain.core.Rate;

import java.util.List;
import java.util.Map;

public interface RateMapper
{
    List<Rate> getAllRates();
    Rate getRateById(Integer rateId);
    Rate getRateForServiceAndVehicleType(Map<String, Object> params);
    Integer upsertServiceRate(Map<String, Object> params);
}
