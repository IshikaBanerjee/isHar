package com.ishar.ecomm.core.models;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import javax.inject.Inject;


@Model(adaptables= Resource.class)
public class CaraousalHelperModel {
    @Inject
    private String[] images;
    public String[] getImages()
    {
        return images;
    }
}
