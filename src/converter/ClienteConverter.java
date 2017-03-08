package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Cliente;
import model.Montadora;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {

	private static Map<String, Cliente> mapa = new HashMap<String, Cliente>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Cliente) {
			Cliente c = (Cliente) value;
			mapa.put(String.valueOf(c.getId()), c);
			return String.valueOf(c.getId());
		} else {
			return "";
		}
	}
}
