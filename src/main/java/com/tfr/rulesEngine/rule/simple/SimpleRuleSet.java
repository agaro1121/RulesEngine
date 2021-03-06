package com.tfr.rulesEngine.rule.simple;

import com.google.common.collect.Sets;
import com.tfr.rulesEngine.exception.RuleException;
import com.tfr.rulesEngine.rule.Rule;
import com.tfr.rulesEngine.rule.RuleSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * Created by Erik on 6/14/2017.
 */
public class SimpleRuleSet<I,O> implements RuleSet<I,O> {

    private final String name;
    private final Set<Rule<I,O>> rules;

    public SimpleRuleSet(String name) {
        this(name, Sets.newHashSet());
    }

    public SimpleRuleSet(String name, Set<Rule<I,O>> rules) {
        this.name = name;
        this.rules = Sets.newTreeSet(rules);
    }

    @Override
    public String getName() {
        return name;
    }

    public Set<Rule<I,O>> getRules() {
        return rules;
    }

    @Override
    public boolean add(Rule<I,O> rule) {
        if(rules.contains(rule)) {
            throw new RuleException("RuleSet already contains a rule named: " + rule.getName());
        }
        rules.add(rule);
        return true;
    }

    @Override
    public boolean contains(Rule<I,O> rule) {
        return rules.contains(rule);
    }

    @Override
    public boolean remove(Rule<I,O> rule) {
        return rules.remove(rule);
    }

    @Override
    public Iterator<Rule<I,O>> iterator() {
        return rules.iterator();
    }
}
