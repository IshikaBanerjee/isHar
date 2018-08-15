package com.ishar.ecomm.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.ArrayList;

@Model(adaptables= Resource.class)
public class NavigationHelperModel {
    @Inject
    private String[] navbuttons;
    @Inject
    ResourceResolver resourceResolver;
    @Inject
    private ArrayList<Page> pages;

    //ResourceResolver resourceResolver=resourceResolverFactory.getAdministrativeResourceResolver();
    PageManager pageManager=resourceResolver.adaptTo(PageManager.class);

    public ArrayList<Page> getPages()
    {
        for(String navbutton:navbuttons)
        {
            Page navPage=pageManager.getPage(navbutton);
            pages.add(navPage);
        }
        return pages;
    }
    public String[] getNavbuttons()
    {
        return navbuttons;
    }
}
