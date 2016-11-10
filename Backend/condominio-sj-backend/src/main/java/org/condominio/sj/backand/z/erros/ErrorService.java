package org.condominio.sj.backand.z.erros;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@Transactional
public class ErrorService implements ErrorServiceInterface {
	private List<ObjectError> erros;
	private List<String> mensagens;

	@Override
	public boolean addErrors(FieldsErrorDetalhe fieldsErrorDetalhe, Errors errors) {

		if (errors.hasErrors()) {
			erros = errors.getAllErrors();
			mensagens = new ArrayList<String>();

			for (ObjectError objectError : erros) {

				// String fieldName= errors instanceof FieldError ?
				// ((FieldError)erros).getField() : null;

				// mensagens +=
				// ((FieldError)objectError).getField()+"-"+objectError.getDefaultMessage()+"\n";
				mensagens.add(String.format(" %s : %s", ((FieldError) objectError).getField(),
						objectError.getDefaultMessage()));
				//redirectAttributes.addFlashAttribute(((FieldError) objectError).getField().toUpperCase(), "error");
				fieldsErrorDetalhe.AddField(((FieldError) objectError).getField().toUpperCase(), "error");
			}
			fieldsErrorDetalhe.setFieldsErrorMessages(mensagens);

			//redirectAttributes.addFlashAttribute("statusError", "unsuccess");
			//redirectAttributes.addFlashAttribute("message", mensagens);

			return true;
		}
		return false;
	}

	@Override
	public boolean addErrorsView(RedirectAttributes redirectAttributes, Errors errors) {

		if (errors.hasErrors()) {
			erros = errors.getAllErrors();
			mensagens = new ArrayList<String>();

			for (ObjectError objectError : erros) {

				// String fieldName= errors instanceof FieldError ?
				// ((FieldError)erros).getField() : null;

				// mensagens +=
				// ((FieldError)objectError).getField()+"-"+objectError.getDefaultMessage()+"\n";
				mensagens.add(String.format(" %s : %s", ((FieldError) objectError).getField(),
						objectError.getDefaultMessage()));
				redirectAttributes.addFlashAttribute(((FieldError) objectError).getField().toUpperCase(), "error");

			}
			redirectAttributes.addFlashAttribute("statusError", "unsuccess");
			redirectAttributes.addFlashAttribute("message", mensagens);

			return true;
		}
		return false;
	}

	@Override
	public boolean entityEmpty(String acao, String name, List<?> entidade, Model model,
			RedirectAttributes redirectAttributes) {
		if (!entidade.isEmpty()) {
			model.addAttribute(name, entidade);
			return false;
		} else {

			redirectAttributes.addFlashAttribute("statusError", "unsuccess");
			redirectAttributes.addFlashAttribute("message", " Não exitem cadastrados " + name + "  para "
					+ "realizar o Cadastro de " + acao + ". Cadastre " + name);

		}
		return true;
	}

	@Override
	public boolean entityEmpty(String msg1, String msg2, String acao, String name, List<?> entidade, Model model,
			RedirectAttributes redirectAttributes) {
		if (!entidade.isEmpty()) {
			model.addAttribute(name, entidade);
			return false;
		} else {

			redirectAttributes.addFlashAttribute("statusError", "unsuccess");
			redirectAttributes.addFlashAttribute("message", " Não exitem cadastrados " + name + " " + msg2 + "  para "
					+ "realizar o Cadastro de " + acao + ". " + msg1 + " " + name);

		}
		return true;
	}

	@Override
	public boolean entityEmptyOrNull(String fieldName, List<?> entidade, Model model,
			RedirectAttributes redirectAttributes) {

		if (entidade != null) {

			return false;
		} else {

			redirectAttributes.addFlashAttribute(fieldName, "error");
			redirectAttributes.addFlashAttribute("statusError", "unsuccess");
			redirectAttributes.addFlashAttribute("message",
					fieldName.toLowerCase().substring(2, 12) + "- Não pode estar em branco");

		}
		return true;
	}

	@Override
	public boolean addErrorsViewModel(RedirectAttributes redirectAttributes, Errors errors, Model model) {
		if (errors.hasErrors()) {
			erros = errors.getAllErrors();
			mensagens = new ArrayList<String>();

			for (ObjectError objectError : erros) {

				// String fieldName= errors instanceof FieldError ?
				// ((FieldError)erros).getField() : null;

				// mensagens +=
				// ((FieldError)objectError).getField()+"-"+objectError.getDefaultMessage()+"\n";
				mensagens.add(String.format(" %s : %s", ((FieldError) objectError).getField(),
						objectError.getDefaultMessage()));
				model.addAttribute(((FieldError) objectError).getField().toUpperCase(), "error");

			}
			model.addAttribute("statusError", "unsuccess");
			model.addAttribute("message", mensagens);

			return true;
		}
		return false;
	}

}
