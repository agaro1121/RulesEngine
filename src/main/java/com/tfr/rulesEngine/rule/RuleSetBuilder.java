package com.tfr.rulesEngine.rule;

import com.google.common.collect.Sets;
import com.tfr.rulesEngine.exception.DuplicateRuleException;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * Created by Erik on 6/25/2017.
 */
public abstract class RuleSetBuilder<I,O> extends RuleSet<I,O> {

    public <R extends Rule<I, O>> RuleSetBuilder(String name, Set<R> rules) {
        super(name, rules);
    }

    public <R extends Rule<I,O>> RuleSetBuilder<I,O>addRule(R rule) {
        boolean addedSuccessfully = add(rule);
        if(!addedSuccessfully) {
            throw new DuplicateRuleException(rule);
        }
        return this;
    }

    public abstract RuleSet<I,O> build();

}
