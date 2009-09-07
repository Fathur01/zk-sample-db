package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.ChartData;

public interface ChartDataDAO {

	public List<ChartData> getChartDataForCustomer(long kunId);

}
