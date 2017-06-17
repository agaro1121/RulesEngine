package com.tfr.rulesEngine.evaluate;

import com.tfr.rulesEngine.rule.Rule;
import com.tfr.rulesEngine.rule.RuleSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Erik Hage on 6/16/2017.
 */
public class MultiMatchEvaluator<I,O,R extends Rule<I,O>> {

    private final RuleSet<R> ruleSet;

    public MultiMatchEvaluator(RuleSet<R> ruleSet) {
        this.ruleSet = ruleSet;
    }

    public List<O> evaluate(I input) {
        List<O> output = new ArrayList<>();
        for(Rule<I,O> rule : ruleSet) {
            if(rule.getPredicate().test(input)) {
                output.add(rule.getFunction().apply(input));
            }
        }
        return output;
    }

}