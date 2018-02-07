package com.SimpleStore.editors;




import com.SimpleStore.Entity.Country;

import java.beans.PropertyEditorSupport;

public class CountryEditor extends PropertyEditorSupport{

    @Override
    public void setAsText(String idCountryFromJSP) throws IllegalArgumentException {

        Country country = new Country();
        country.setId(Integer.valueOf(idCountryFromJSP));

        setValue(country);

    }


}
