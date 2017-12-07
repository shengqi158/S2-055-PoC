package org.demo.rest.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Order {
    public String id;
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_ARRAY)
    public Object clientName;
    public int amount;
    
    public Order() {}
    
    public Order(String id, Object clientName, int amount) {
        super();
        this.id = id;
        this.clientName = clientName;
        this.amount = amount;
    }
   // @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include= JsonTypeInfo.As.WRAPPER_ARRAY)
  /*  @JsonSubTypes(
            @JsonSubTypes.Type(name="dog",value=Dog.class),
            @JsonSubTypes.Type(name="cat",value=Cat.class),
    )*/
/*    static class Animal { // All animals have names, for our demo purposes...
        public String name;
        protected Animal() { }
    }*/

/*    static class Dog extends Animal {
        public double barkVolume; // in decibels
        public Dog() { }
    }

    static class Cat extends Animal {
        boolean likesCream;
        public int lives;
        public Cat() { }
    }*/


    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Object getClientName() {
        return clientName;
    }
    public void setClientName(Object clientName) {
        this.clientName = clientName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Order rhs = (Order) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.clientName, rhs.clientName)
                .append(this.amount, rhs.amount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(clientName)
                .append(amount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("clientName", clientName)
                .append("amount", amount)
                .toString();
    }
}
