package com.onatarslan.springcore.workspace;


import org.springframework.beans.factory.annotation.Value;

public class OwnClassBeanExample {

    private final WorkspaceRegistry registry; // bu bean oldugu icin sorun yok
    private final WorkspaceService service; // bu da bean burada da sorun yok
    private final String prefix;


    public OwnClassBeanExample(WorkspaceRegistry registry, WorkspaceService service, String prefix) {
        this.registry = registry;
        this.service = service;
        this.prefix = prefix; // buradaki prefix Bean olmadigi icin OwnClassBeanExample component olamaz
    }

}
