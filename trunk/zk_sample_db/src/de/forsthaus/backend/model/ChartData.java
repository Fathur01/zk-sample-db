package de.forsthaus.backend.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * This class have no correspondant table in the database.<br>
 * It's used for creating the charts data.<br>
 * 
 * @author sge
 * 
 */
public class ChartData implements java.io.Serializable {

	private static final long serialVersionUID = 8929169549733728994L;

	private long chartKunId;
	private Date chartKunInvoiceDate;
	private BigDecimal chartKunInvoiceAmount = new BigDecimal(0.00);

	public ChartData() {
	}

	public ChartData(long chartKunId, Date chartKunInvoiceDate, BigDecimal chartKunInvoiceAmount) {
		this.chartKunId = chartKunId;
		this.chartKunInvoiceDate = chartKunInvoiceDate;
		this.chartKunInvoiceAmount = chartKunInvoiceAmount;
	}

	public long getChartKunId() {
		return this.chartKunId;
	}

	public void setChartKunId(long chartKunId) {
		this.chartKunId = chartKunId;
	}

	public Date getChartKunInvoiceDate() {
		return this.chartKunInvoiceDate;
	}

	public void setChartKunInvoiceDate(Date chartKunInvoiceDate) {
		this.chartKunInvoiceDate = chartKunInvoiceDate;
	}

	public BigDecimal getChartKunInvoiceAmount() {
		return this.chartKunInvoiceAmount;
	}

	public void setChartKunInvoiceAmount(BigDecimal chartKunInvoiceAmount) {
		this.chartKunInvoiceAmount = chartKunInvoiceAmount;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getChartKunId()).hashCode();
	}

	public boolean equals(ChartData chartData) {
		return getChartKunId() == chartData.getChartKunId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof ChartData) {
			ChartData chartData = (ChartData) obj;
			return equals(chartData);
		}

		return false;
	}

}
