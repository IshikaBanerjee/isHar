package com.ishar.ecomm.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
//import com.ishar.ecomm.core.servlets.PathToPageService;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.Session;
import java.util.ArrayList;


@Model(adaptables= Resource.class)
public class NavigationHelperModel {
    private static final Logger log = LoggerFactory.getLogger(NavigationHelperModel.class);
    @Inject @Optional
    private String[] navbuttons;
    @Inject @Optional
    private Page[] pages;

    @Inject
    private ResourceResolverFactory resourceResolverFactory;
//    @Inject
//    PathToPageService pathToPageService;

    ResourceResolver resourceResolver = null;
    PageManager pageManager;
    private Session session;

    public Page[] getPages()
    {
//        Map<String, Object> param = new HashMap<String, Object>();
//        param.put(ResourceResolverFactory.SUBSERVICE, "datawrite");
        int count=navbuttons.length;
        ArrayList pagearray=new ArrayList<Page>();
        try {
            resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
            session = resourceResolver.adaptTo(Session.class);
            Node root = session.getRootNode();
            for (String navbutton:navbuttons)
            {
//                Node content = root.getNode(navbutton);
//                Page page=content   //pageManager.getPage(content.getPath());
                Page page=resourceResolver.getResource(navbutton).adaptTo(Page.class);
                String name=page.getTitle();
                log.error("Page is:"+name);
                System.out.print(page.getTitle());
                pagearray.add(page);

            }

            pages= (Page[]) pagearray.toArray(new Page[pagearray.size()]);

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return pages;
    }
    public String[] getNavbuttons()
    {
        return navbuttons;
    }
}