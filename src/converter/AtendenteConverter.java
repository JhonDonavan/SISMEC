package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Atendente;

@FacesConverter("atendenteConverter")
public class AtendenteConverter implements Converter{
	
	private static Map<String, Atendente> mapa = new HashMap<String, Atendente>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Atendente) {
			Atendente c = (Atendente) value;
			mapa.put(String.valueOf(c.getId()), c);
			return String.valueOf(c.getId());
		} else {
			return "";
		}
	}

}
