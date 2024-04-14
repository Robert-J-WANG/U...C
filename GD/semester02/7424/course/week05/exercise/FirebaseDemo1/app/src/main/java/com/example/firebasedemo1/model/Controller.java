package com.example.firebasedemo1.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Controller {

        private FirebaseDatabase firebaseDatabase;
        private DatabaseReference reference;
    private String id;

    public Controller() {
            firebaseDatabase = FirebaseDatabase.getInstance("https://fir-demo1-d26f8-default-rtdb.firebaseio.com");
            reference = firebaseDatabase.getReference();
        }

        public DatabaseReference getReference() {
            return reference;
        }

        /**
         * Returns a user object after it had been added to the database.
         *
         * @param firstName new user firstname
         * @param lastName  new user lastname
         * @param email     new user email     *
         * @return user object that has been added to database
         */


        public User createUser(String firstName, String lastName, String email) {
            try {
                String id = reference.push().getKey();
                User user = new User(id, firstName, lastName, email);
                reference.child("users").child(id).setValue(user);
                return user;
            } catch (Exception ex) {
                return null;
            }

        }

        public boolean updateUser(String id,String firstName, String lastName, String email){
            try {
                User updatedUser=new User(id,firstName,lastName,email);
                reference.child("users").child(id).setValue(updatedUser);
                return true;
            }
            catch (Exception ex){
                return false;
            }
        }

        public boolean deleteUser(String userID){
            try{
                reference.child("users").child(userID).removeValue();
                return true;
            }catch(Exception ex){
                return false;
            }
        }

    }

