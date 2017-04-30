package validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "salario-validator")
public class SalarioValidador implements Validator {

	public void validate(FacesContext contexto, UIComponent campo, Object objeto) throws ValidatorException {
		
	}
}
