package org.condominio.sj.backand.relatorio;

import javax.sql.DataSource;

import org.condominio.sj.backand.z.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Controller
public class Relatorio {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ApplicationContext appContext;


	@RequestMapping(path = ServicePath.JASPER_PATH )
	public ModelAndView generatePdfReport(){

		final JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:relatorio.jrxml");
		view.setJdbcDataSource(dataSource);
		view.setApplicationContext(appContext);
		/*
		Properties props = new Properties();
		props.setProperty("Access-Control-Allow-Origin", "*");
		view.setHeaders(props); */
		return new ModelAndView(view);

	}

}
