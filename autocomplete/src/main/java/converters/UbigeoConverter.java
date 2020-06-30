package converters;

import com.google.gson.Gson;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import models.Ubigeo;

@FacesConverter("CV_Ubigeo")
public class UbigeoConverter implements Converter {

    Gson gson = new Gson();
    
    @Override
    public Object getAsObject(FacesContext contex, UIComponent component, String value) {
        
        System.out.println("AsObject");
        System.out.println(value);
        
        if (value == null || value.length() == 0) {
            return null;
        }
        
        return gson.fromJson(value, Ubigeo.class);
    }

    @Override
    public String getAsString(FacesContext contex, UIComponent component, Object object) {
        
        System.out.println("AsString");
        System.out.println(object.toString());
        
        if (object == null) {
            return null;
        }

        if (object instanceof Ubigeo) {
            return gson.toJson(object); // Se manda en forma de Json 
        }
        
        return null;
    }

}
