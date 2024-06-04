package com.anurag.fifa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {
    private String name;
    private int points;
    private int wins;
    private int losses;
    private int ties;
    private String category;

    //@Override
    public int getPoints(){
        return (3 * wins) + ties;
    }
}
