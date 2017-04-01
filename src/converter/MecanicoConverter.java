package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Mecanico;

@FacesConverter("atendenteConverter")
public class MecanicoConverter implements Converter{
	
	private static Map<String, Mecanico> mapa = new HashMap<String, Mecanico>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Mecanico) {
			Mecanico c = (Mecanico) value;
			mapa.put(String.valueOf(c.getId()), c);
			return String.valueOf(c.getId());
		} else {
			return "";
		}
	}

}
