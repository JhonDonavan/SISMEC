package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.OrdemDeServico;

@FacesConverter("ordemDeServicoConverter")
public class OrdemDeServicoConverter implements Converter {

	private static Map<String, OrdemDeServico> mapa = new HashMap<String, OrdemDeServico>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof OrdemDeServico) {
			OrdemDeServico m = (OrdemDeServico) value;
			mapa.put(String.valueOf(m.getId()), m);
			return String.valueOf(m.getId());
		} else {
			return "";
		}
	}
}
