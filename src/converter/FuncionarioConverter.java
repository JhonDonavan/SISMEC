package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Funcionario;
import model.Montadora;

@FacesConverter("funcionarioConverter")
public class FuncionarioConverter implements Converter {

	private static Map<String, Funcionario> mapa = new HashMap<String, Funcionario>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Funcionario) {
			Funcionario f = (Funcionario) value;
			mapa.put(String.valueOf(f.getId()), f);
			return String.valueOf(f.getId());
		} else {
			return "";
		}
	}
}
