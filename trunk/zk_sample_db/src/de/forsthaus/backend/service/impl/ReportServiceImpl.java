/**
 * 
 */
package de.forsthaus.backend.service.impl;

import de.forsthaus.backend.service.ReportService;

/**
 * @author bj
 * 
 */
public class ReportServiceImpl implements ReportService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.daibutsu.backend.service.ReportService#printAuftragsPositionen(de.
	 * daibutsu.backend.model.Auftrag, java.util.HashMap)
	 */
//	@Override
//	public void printAuftragsPositionen(Auftrag auftrag, HashMap repParams) {
//
//		try {
//
//			InputStream inputStream = getClass().getResourceAsStream("/de/daibutsu/reports/AuftragDetailsPojo_Report.jrxml");
//
//			/* Liste mit Daten füllen */
//			List<Auftragposition> result = getAuftragService().getAuftragsPositionenByAuftrag(auftrag);
//
//			/* DataSource mit der Liste erstellen */
//			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(result);
//
//			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, repParams, datasource);
//			JasperViewer.viewReport(jasperPrint, false);
//		} catch (JRException ex) {
//			String connectMsg = "JasperReports: Could not create the report " + ex.getMessage() + " " + ex.getLocalizedMessage();
//			System.out.println(connectMsg);
//		} catch (Exception ex) {
//			String connectMsg = "Could not create the report " + ex.getMessage() + " " + ex.getLocalizedMessage();
//			System.out.println(connectMsg);
//		}
//
//	}

}
