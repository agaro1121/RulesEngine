package com.tfr.rulesEngine.rule.simple;

import com.google.common.collect.Sets;
import com.tfr.rulesEngine.exception.RuleException;
import com.tfr.rulesEngine.rule.Rule;
import com.tfr.rulesEngine.rule.RuleSet;
import com.tfr.rulesEngine.rule.RuleSetBuilder;

import java.util.Set;

/**
 *
 * Created by Erik on 6/25/2017.
 */
public class SimpleRuleSetBuilder<I,O> implements RuleSetBuilder<I,O> {

    private String name;
    private Set<Rule<I,O>> rules;

    public SimpleRuleSetBuilder(String name) {
        this.name = name;
        this.rules = Sets.newHashSet();
    }

    public RuleSet<I,O> build() {
        return new SimpleRuleSet<>(name, rules);
    }

    public SimpleRuleSetBuilder<I,O> addRule(Rule<I,O> rule) {
        if(rules.contains(rule)) {
            throw new RuleException("Set already contains a rule with name " + rule.getName());
        }
        rules.add(rule);
        return this;
    }

}
