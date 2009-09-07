package de.forsthaus.backend.service;

import java.util.List;

import de.forsthaus.backend.model.ChartData;

public interface ChartService {

	public List<ChartData> getChartDataForCustomer(long kunId);
}
