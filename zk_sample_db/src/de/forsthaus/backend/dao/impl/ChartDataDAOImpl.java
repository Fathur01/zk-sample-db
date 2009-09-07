package de.forsthaus.backend.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.forsthaus.backend.dao.ChartDataDAO;
import de.forsthaus.backend.model.ChartData;

public class ChartDataDAOImpl extends BasisfNextidviewImpl<ChartData> implements ChartDataDAO {

	@Override
	public List<ChartData> getChartDataForCustomer(long kunId) {

		List<ChartData> result = new ArrayList<ChartData>();

		if (kunId == 20) {
			result.add(new ChartData(new Long(kunId), new Date(2009, 1, 2), new BigDecimal(120.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 2, 2), new BigDecimal(450.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 3, 15), new BigDecimal(820.10)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 4, 20), new BigDecimal(654.00)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 5, 2), new BigDecimal(120.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 6, 2), new BigDecimal(520.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 7, 2), new BigDecimal(320.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 8, 3), new BigDecimal(20.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 9, 6), new BigDecimal(480.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 10, 2), new BigDecimal(520.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 11, 13), new BigDecimal(620.70)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 12, 2), new BigDecimal(1220.90)));
		} else if (kunId == 21) {
			result.add(new ChartData(new Long(kunId), new Date(2009, 1, 12), new BigDecimal(320.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 2, 6), new BigDecimal(450.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 3, 25), new BigDecimal(620.10)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 4, 25), new BigDecimal(154.00)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 5, 14), new BigDecimal(320.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 6, 19), new BigDecimal(620.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 7, 17), new BigDecimal(920.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 8, 22), new BigDecimal(120.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 9, 28), new BigDecimal(680.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 10, 12), new BigDecimal(580.30)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 11, 8), new BigDecimal(820.70)));
			result.add(new ChartData(new Long(kunId), new Date(2009, 12, 14), new BigDecimal(220.90)));
		}

		return result;

	}
}
