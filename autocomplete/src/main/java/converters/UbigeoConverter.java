package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("CV_Ubigeo")
public class UbigeoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext contex, UIComponent component, String value) {
        
        System.out.println("AsObject");
        System.out.println(value);
        
        return value;
    }

    @Override
    public String getAsString(FacesContext contex, UIComponent component, Object object) {
        
        System.out.println("AsString");
        System.out.println(object.toString());
        
        return object.toString();
    }

}
