package com.ishar.ecomm.core.models;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Optional;

import javax.inject.Inject;


@Model(adaptables= Resource.class)
public class CaraousalHelperModel {
    @Inject @Optional
    private String[] images;
    public String[] getImages()
    {
        return images;
    }
}
