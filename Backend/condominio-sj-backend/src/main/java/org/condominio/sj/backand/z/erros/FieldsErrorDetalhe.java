package org.condominio.sj.backand.z.erros;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldsErrorDetalhe {

	private List<String> fieldsErrorMessages;

	private  Map<String, String> mapOfFields = new HashMap<String, String>();

	public void AddField(String name, String value) {


		this.mapOfFields.put(name.toUpperCase(), value.toUpperCase());
	}

	public String getValue(String name) {
		String value = this.mapOfFields.get(name);

		return value;
	}

	public List<String> getFieldsErrorMessages() {
		return fieldsErrorMessages;
	}

	public void setFieldsErrorMessages(List<String> fieldsErrorMessages) {
		this.fieldsErrorMessages = fieldsErrorMessages;
	}

	public Map<String, String> getMapOfFields() {
		return mapOfFields;
	}

	public void setMapOfFields(Map<String, String> mapOfFields) {
		this.mapOfFields = mapOfFields;
	}

}
