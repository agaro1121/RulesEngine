package com.tfr.rulesEngine.rule.simple;

import com.tfr.rulesEngine.rule.RuleSet;

import java.util.Set;

/**
 *
 * Created by Erik on 6/14/2017.
 */
public class SimpleRuleSet<I,O> extends RuleSet<I,O> {

    public SimpleRuleSet(String name) {
        super(name);
    }

    public SimpleRuleSet(String name, Set<SimpleRule<I,O>> rules) {
        super(name, rules);
    }
}
