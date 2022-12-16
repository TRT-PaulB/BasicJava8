package com.rev.BasicJava8.j8misc;

import com.rev.BasicJava8.immutable.ImmutablePlay;
import com.rev.BasicJava8.interfaces.InterfacesPlay;
import com.rev.BasicJava8.interfaces.MyDefaultInterfaceIllustrator;
import com.rev.BasicJava8.methodrefs.MyMethodReferenceMachine;

public class Java8misc {

    public Java8misc() {
        initBasicJava8();
    }

    private void initBasicJava8() {
        System.out.println("\ninitiating BasicJava8....");

        // java 8 constructs
        new BasicStreamOps();
        new CopyByValue();
        new DateTimeApi();

        // map iterations
        new MapLooper();

        // interfaces
        new MyDefaultInterfaceIllustrator();
        new InterfacesPlay();

        new StringJoinerPlus();

        new ImmutablePlay();

        new ConcurrentModificationBlues();

        new MyMethodReferenceMachine();
    }

}


