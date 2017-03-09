package converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.ModeloVeiculo;

@FacesConverter("modeloVeiculoConverter")
public class ModeloVeiculoConverter implements Converter {

	private static Map<String, ModeloVeiculo> mapa = new HashMap<String, ModeloVeiculo>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapa.get(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof ModeloVeiculo) {
			ModeloVeiculo mv = (ModeloVeiculo) value;
			mapa.put(String.valueOf(mv.getId()), mv);
			return String.valueOf(mv.getId());
		} else {
			return "";
		}
	}
}
