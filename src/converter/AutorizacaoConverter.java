package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Autorizacao;

@FacesConverter("autorizacaoConverter")
public class AutorizacaoConverter implements Converter{
	
	private static Map<String, Autorizacao> mapa = new HashMap<String, Autorizacao>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Autorizacao) {
			Autorizacao a = (Autorizacao) value;
			mapa.put(String.valueOf(a.getId()), a);
			return String.valueOf(a.getId());
		} else {
			return "";
		}
	}

}
