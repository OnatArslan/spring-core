package com.onatarslan.springcore.idgen;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("uuid") // componenta isim verdik bunu constructorda @Qualifier ile isimlendirebiliriz
public class UuidIdGenerator implements TaskIdGenerator{

    @Override
    public String nextId() {
        return UUID.randomUUID().toString();
    }

}
