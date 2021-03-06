/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinema.converter;

import br.com.cinema.modelo.Classificacao;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "ClassificacaoConverter")
public class ClassificacaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        if (value != null
                && !"".equals(value)) {

            Classificacao entity = (Classificacao) value;

            // adiciona item como atributo do componente
            this.addAttribute(component, entity);

            Integer id = entity.getId();
            if (id != null) {
                return String.valueOf(id);
            }

            return "";
        }

        return (String) value;
    }

    protected void addAttribute(UIComponent component, Classificacao o) {
        String key = o.getId() == null ? "" : o.getId().toString();
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}
