package com.company.IdeaProjects.FawryService.Models;
import com.company.IdeaProjects.FawryService.Services.Iform;
import com.company.IdeaProjects.FawryService.Services.Ihandler;

public class servicesType {
    private String name;
    private int id;
    private Iform iform;
    private Ihandler ihandler;
    private static int ID=1;

    public servicesType(String name,Iform iform,Ihandler ihandler) {
        this.name = name;
        this.iform = iform;
        this.ihandler = ihandler;
        id=ID;
        ID++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Iform getIform() {
        return iform;
    }

    public Ihandler getIhandler() {
        return ihandler;
    }
}
