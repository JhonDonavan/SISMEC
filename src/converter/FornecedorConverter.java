package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Fornecedor;

@FacesConverter("fornecedorConverter")
public class FornecedorConverter implements Converter{
	
	private static Map<String, Fornecedor> mapa = new HashMap<String, Fornecedor>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Fornecedor) {
			Fornecedor c = (Fornecedor) value;
			mapa.put(String.valueOf(c.getId()), c);
			return String.valueOf(c.getId());
		} else {
			return "";
		}
	}

}
