package com.github.sharifulin.entity;

import java.util.Objects;

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
        return "{ firstName: \""+this.firstName+"\", lastName: \""+this.lastName+"\" }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
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
