package org.condominio.sj.backand.z.exception;

import org.condominio.sj.backand.z.utils.BaseBean;

public class ExceptionParamBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String param;

	private String message;

	public ExceptionParamBean() {
	}

	public ExceptionParamBean(String param, String message) {
		super();
		this.param = param;
		this.message = message;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
