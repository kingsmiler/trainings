package com.blogspot.toomuchcoding.common.assertj;

import org.assertj.core.api.Assertions;

import com.blogspot.toomuchcoding.model.Person;

public class MyAssertions extends Assertions {

    public static PersonAssert assertThat(Person actual) {
        return new PersonAssert(actual);
    }

}
