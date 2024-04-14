package com.example.exerfirebase01.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FruitController {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;
    private String id;



    public FruitController() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return firebaseDatabase;
    }

    public DatabaseReference getReference() {
        return reference;
    }

    public Fruit listFruits(String name, String color){
        Fruit fruit=new Fruit(id, name,color);
        String id= reference.push().getKey();
        reference.child("fruitList").child(id).setValue(fruit);
        return fruit;
    }

    public Fruit createFruit(String name, String color){
        try{
            Fruit fruit=new Fruit(id, name,color);
            String id= reference.push().getKey();
            reference.child("fruitList").child(id).setValue(fruit);
            return fruit;

        }
        catch (Exception ex){
            return null;
        }
    }
}
