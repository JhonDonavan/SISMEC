package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Peca;

@FacesConverter("pecaConverter")
public class PecaConverter implements Converter {

	private static Map<String, Peca> mapa = new HashMap<String, Peca>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Peca) {
			Peca m = (Peca) value;
			mapa.put(String.valueOf(m.getId()), m);
			return String.valueOf(m.getId());
		} else {
			return "";
		}
	}
}
