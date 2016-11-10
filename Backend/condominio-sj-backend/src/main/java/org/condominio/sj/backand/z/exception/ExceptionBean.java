package org.condominio.sj.backand.z.exception;

import org.condominio.sj.backand.z.utils.BaseBean;

public class ExceptionBean extends BaseBean {

	private static final long serialVersionUID = 201707120434L;

	private String message;

	private Integer serverCode;

	private ExceptionParamBean[] params;

	public ExceptionBean() {
	}

	public ExceptionBean(ExceptionConstants exceptionConstants) {
		this.message = exceptionConstants.getMessage();
		this.serverCode = exceptionConstants.getServerCode();
	}

	public ExceptionBean(GenericException exception) {
		this.message = exception.getMessage();
		this.serverCode = exception.getServerCode();
		this.params = exception.getParams();
	}

	public ExceptionBean(String message, Integer serverCode, ExceptionParamBean[] params) {
		this.message = message;
		this.serverCode = serverCode;
		this.params = params;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getServerCode() {
		return serverCode;
	}

	public void setServerCode(Integer serverCode) {
		this.serverCode = serverCode;
	}

	public ExceptionParamBean[] getParams() {
		return params;
	}

	public void setParams(ExceptionParamBean[] params) {
		this.params = params;
	}

}
