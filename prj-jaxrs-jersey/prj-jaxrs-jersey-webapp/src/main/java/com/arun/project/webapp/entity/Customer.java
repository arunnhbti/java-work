package com.arun.project.webapp.entity;

public class Customer implements Entity {
    @Override
    public EntityType getEntityType() {
        EntityType entityType = new EntityType();
        entityType.setEntityType("CUSTOMER");
        return entityType;
    }

    @Override
    public String getEntityData(){
        //TODO
        return "{\n" +
                "\t\"record\": {\n" +
                "\t\t\"id\": \"customerID\",\n" +
                "\t\t\"name\": \"Customer Name\",\n" +
                "\t\t\"address\": \"Customer Address\"\n" +
                "\t}\n" +
                "}";
    }

    @Override
    public String toString() {

        return getEntityData();
    }
}
