package com.tfr.rulesEngine.rule;

import com.google.common.collect.Sets;
import com.tfr.rulesEngine.exception.DuplicateRuleException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * Created by Erik on 6/14/2017.
 */
//TODO R extends Rule<I,O>
public abstract class RuleSet<I,O> extends TreeSet<Rule<I,O>> {

    private String name;

    public RuleSet(String name) {
        this.name = name;
    }

    public <R extends Rule<I,O>> RuleSet(String name, Set<R> rules) {
        this.name = name;
        addAll(rules);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean add(Rule<I,O> rule) {
        boolean addedSuccessfully = super.add(rule);
        if(!addedSuccessfully) {
            throw new DuplicateRuleException(rule);
        }
        return addedSuccessfully;
    }
}
