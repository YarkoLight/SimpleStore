package com.SimpleStore.editors;

import com.SimpleStore.Entity.Brand;

import java.beans.PropertyEditorSupport;

/**
 * Created by HOME on 27.08.2017.
 */
public class BrandEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        Brand brand = new Brand();

        brand.setId(Integer.parseInt(text));

        setValue(brand);

    }
}
