package io.github.charlie.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: TODO
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }

        return null;
    }
}
