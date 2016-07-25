package com.blogspot.toomuchcoding.book.chapter1._2_MockitoAnnotationsJunit.hamcrest;

import com.blogspot.toomuchcoding.book.chapter1.common.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter1.common.TaxService;
import com.blogspot.toomuchcoding.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

public class MeanTaxFactorCalculatorTest {

    static final double TAX_FACTOR = 10;

    @Mock
    TaxService taxService;

    @InjectMocks
    MeanTaxFactorCalculator systemUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_calculate_mean_tax_factor() {
        // given
        given(taxService.getCurrentTaxFactorFor(any(Person.class))).willReturn(TAX_FACTOR);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        assertThat(meanTaxFactor, equalTo(TAX_FACTOR));
    }

}
