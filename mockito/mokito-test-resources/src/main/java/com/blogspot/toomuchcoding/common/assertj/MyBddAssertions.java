package com.blogspot.toomuchcoding.common.assertj;

import org.assertj.core.api.BDDAssertions;

import com.blogspot.toomuchcoding.model.Person;

public class MyBddAssertions extends BDDAssertions {

    public static PersonAssert then(Person actual) {
        return new PersonAssert(actual);
    }

}
