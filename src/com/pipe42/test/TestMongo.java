package com.pipe42.test;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TestMongo {

    public static void main(String[] args) {

        MongoClient mc = MongoClients.create();

        System.out.println(mc);

        MongoDatabase db = mc.getDatabase("test");

        System.out.println(db);

        MongoCollection<Document> mongoCollection = db.getCollection("testCollection");

        System.out.println("Amount of collections: " + mongoCollection.countDocuments());

    }

}
