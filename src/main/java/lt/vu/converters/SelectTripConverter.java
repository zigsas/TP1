package lt.vu.converters;

import lt.vu.entities.Vehicle;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;
import java.util.function.Predicate;

@FacesConverter(value = "SelectTripConverter")
public class SelectTripConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
        Object object = null;
        if (!(value == null || value.isEmpty())) {
            object = this.getSelectedItemAsEntity(comp, value);
        }
        return object;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
        String s = "";
        if (value != null) {
            s = ((Vehicle) value).getId().toString();
        }
        return s;
    }

    private Vehicle getSelectedItemAsEntity(UIComponent component, String value) {
        Vehicle item = null;

        List<Vehicle> selectItems;
        for (UIComponent uiComponent : component.getChildren()) {
            if (uiComponent instanceof UISelectItems) {
                Integer itemId = Integer.valueOf(value);
                selectItems = (List<Vehicle>) ((UISelectItems) uiComponent).getValue();

                if (itemId != null && selectItems != null && !selectItems.isEmpty()) {
                    Predicate<Vehicle> predicate = i -> i.getId().equals(itemId);
                    item = selectItems.stream().filter(predicate).findFirst().orElse(null);
                }
            }
        }

        return item;
    }
}