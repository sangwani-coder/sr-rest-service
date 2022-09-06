package tech.zyambo.srapi;

import java.time.LocalDate;
import java.util.UUID;

public class Recipe {
    private String message;
    private final UUID id;
    private final LocalDate createdAt;
    private LocalDate editedAt;


    public Recipe(){
        this.id = UUID.randomUUID();
        this.createdAt = LocalDate.now();
        this.editedAt = LocalDate.now();
    }

    public UUID getId(){
        return id;
    }

    public void addMsg(String msg){
        if (msg == null) {
            this.message = "ok";
        }
        this.message = msg;
    }

    public LocalDate getcreatedAt(){
        return createdAt;
    }

    public LocalDate geteditedAt(){
        return editedAt;
    }

}