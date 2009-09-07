package de.forsthaus.backend.service.impl;

import java.util.List;

import de.forsthaus.backend.dao.ChartDataDAO;
import de.forsthaus.backend.model.ChartData;
import de.forsthaus.backend.service.ChartService;

public class ChartServiceImpl implements ChartService {

	private ChartDataDAO chartDataDAO;

	public void setChartDataDAO(ChartDataDAO chartDataDAO) {
		this.chartDataDAO = chartDataDAO;
	}

	public ChartDataDAO getChartDataDAO() {
		return chartDataDAO;
	}

	@Override
	public List<ChartData> getChartDataForCustomer(long kunId) {
		return getChartDataDAO().getChartDataForCustomer(kunId);
	}
}
