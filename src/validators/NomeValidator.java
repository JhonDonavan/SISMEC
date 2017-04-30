package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "nome-validador")
public class NomeValidator implements Validator {

	@Override
	public void validate(FacesContext contexto, UIComponent campo, Object objeto) throws ValidatorException {
		if (objeto instanceof String) {
			String valor = (String) objeto;
			if (valor.length() < 5)
				throw new ValidatorException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "O nome deve ter no mínimo 5 letras", null));

			for (char letra : valor.toCharArray()) {
				if (!(Character.isLetter(letra)) && !(Character.isSpaceChar(letra)))
					throw new ValidatorException(
							new FacesMessage(FacesMessage.SEVERITY_FATAL, "O nome deve ter apenas letras", null));

			}
		}
	}
}
