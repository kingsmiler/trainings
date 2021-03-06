package com.blogspot.toomuchcoding.book.chapter1.common;

import com.blogspot.toomuchcoding.model.Person;

public class MeanTaxFactorCalculator {

    private final TaxService taxService;

    public MeanTaxFactorCalculator(TaxService taxService) {
        this.taxService = taxService;
    }

    public double calculateMeanTaxFactorFor(Person person) {
        double currentTaxFactor = taxService.getCurrentTaxFactorFor(person);
        double anotherTaxFactor = taxService.getCurrentTaxFactorFor(person);

        return (currentTaxFactor + anotherTaxFactor) / 2;
    }

}
