package main.server.database;

import java.io.Serializable;

public abstract class AbstractData implements Serializable {

    public abstract Long getId();
    public abstract void setId(Long id);

    protected AbstractData(){
        setId(AbstractRepository.getId());
    }
}
