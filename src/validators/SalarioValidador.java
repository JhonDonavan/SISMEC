package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "salario-validator")
public class SalarioValidador implements Validator {

	public void validate(FacesContext contexto, UIComponent campo, Object objeto) throws ValidatorException {
		if (objeto instanceof Double) {
			Double valor = (Double) objeto;
			if (valor <= 0)
				throw new ValidatorException(
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "O Salário deve ser maior que 0.00", null));
		}
	}
}
