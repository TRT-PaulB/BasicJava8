package com.rev.BasicJava8.immutable;

import com.rev.BasicJava8.j8misc.MutableAge;

public class ImmutablePlay {

    public ImmutablePlay() {
        // use the cloned age in the ImmutableMe constructor to stop post creation modification of the passed in object
        MutableAge mutableAge = new MutableAge(27);
        int ageBefore = mutableAge.getAge();
        ImmutableMe changeMeContructorNot = new ImmutableMe("Paul", mutableAge);
        mutableAge.setAge(47);
        System.out.println("Age was " + ageBefore + ", but happily still unchanged: " + changeMeContructorNot.getAge().getAge());

        // use the cloned age in the ImmutableMe.getAge() method to stop modifying age via the set method
        ImmutableMe changeMeNot = new ImmutableMe("Paul", new MutableAge(24));
        int ageWas = changeMeNot.getAge().getAge();
        changeMeNot.getAge().setAge(47);
        System.out.println("Age was " + ageWas + ", but happily still unchanged: " + changeMeNot.getAge().getAge());
    }

}
