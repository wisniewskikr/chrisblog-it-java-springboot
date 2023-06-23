package com.rosariob.crud.neo4j.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Getter @Setter @AllArgsConstructor @ToString
@RelationshipProperties
public class Roles{

    @RelationshipId
    private Long id;

    @TargetNode
    private Person person;

    @Property("roles")
    private List<String> roles;
}
