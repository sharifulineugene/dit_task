package com.github.sharifulin.entity;

public class Person {
    private String firstName;
    private String lastName;

    public Person(){}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "{firstName = "+this.firstName+"; lastName = "+this.lastName+"}";
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private PersonBuilder() {}
        public PersonBuilder fistName(String firstname) {
            this.firstName = firstname;
            return this;
        }
        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Person build() {
            return new Person(firstName,lastName);
        }


    }
}
