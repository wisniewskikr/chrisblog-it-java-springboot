package com.rosariob.crud.neo4j.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Person")
@Getter @Setter @AllArgsConstructor @ToString
public class Person {

    @Id @GeneratedValue
    private Long id;

    @Property("name")
    private String name;

    @Property("born")
    private String born;
}
