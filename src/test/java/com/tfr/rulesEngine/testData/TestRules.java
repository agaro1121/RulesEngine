package com.tfr.rulesEngine.testData;

import com.tfr.rulesEngine.rule.Rule;
import com.tfr.rulesEngine.rule.chain.ChainingRule;
import com.tfr.rulesEngine.rule.chain.ChainingRuleSet;
import com.tfr.rulesEngine.rule.link.LinkingRule;
import com.tfr.rulesEngine.rule.link.LinkingRuleSet;
import com.tfr.rulesEngine.rule.simple.SimpleRule;

/**
 *
 * Created by Erik on 6/25/2017.
 */
public interface TestRules {

    /* Simple Rules */
    Rule<String, String> LONG_STRING_RULE = new SimpleRule<>("longString", 0, (i) -> i.length() > 10, (i) -> "String has more than 10 characters");
    Rule<String, String> SHORT_STRING_RULE = new SimpleRule<>("shortString", 0, (i) -> i.length() < 10, (i) -> "String has less than 10 characters");
    Rule<String, String> TEN_CHAR_RULE = new SimpleRule<>("tenChar", 0, (i) -> i.length() == 10, (i) -> "String has exactly 10 characters");

    Rule<Integer, Boolean> INT_EQUALS_10 = new SimpleRule<>("intEquals10", 0, (i) -> i==10, (i) -> true);
    Rule<Integer, Boolean> INT_EQUALS_1 = new SimpleRule<>("intEquals1", 0, (i) -> i==1, (i) -> true);

    Rule<Integer, String> SMALL_INT = new SimpleRule<>("smallInt",100, (i) -> i < 10, (i) -> "int<10");
    Rule<Integer, String> MED_INT = new SimpleRule<>("mediumInt",90, (i) -> i < 100, (i) -> "int<100");
    Rule<Integer, String> LARGE_INT = new SimpleRule<>("largeInt",80, (i) -> i < 1000, (i) -> "int<1000");
    Rule<Integer, String> HUGE_INT = new SimpleRule<>("hugeInt",70, (i) -> i >= 1000, (i) -> "int>=1000");

    Rule<Integer, Integer> SMALL_INT_INT = new SimpleRule<>("smallIntInt",100, (i) -> i < 10, (i) -> i);

    /* Linking Rules */
    Rule<Integer, Integer> DOUBLE_INT = new LinkingRule<>("doubleInt", 100, (i) -> i>10, (i) -> i*2, "set2");
    Rule<Integer, Integer> TRIPLE_INT = new LinkingRule<>("tripleInt", 150, (i) -> i<10, (i) -> i*3, "set3");
    Rule<Integer, Integer> PLUS_5 = new LinkingRule<>("plus5", 100, (i) -> true, (i) -> i+5, null);
    Rule<Integer, Integer> PLUS_10 = new LinkingRule<>("plus10", 100, (i) -> true, (i) -> i+10, null);

    LinkingRuleSet<Integer, Integer> SET_1 = new LinkingRuleSet<Integer, Integer>("set1") {{
        add(DOUBLE_INT);
        add(TRIPLE_INT);
    }};

    LinkingRuleSet<Integer, Integer> SET_2 = new LinkingRuleSet<Integer, Integer>("set2") {{
        add(PLUS_5);
    }};

    LinkingRuleSet<Integer, Integer> SET_3 = new LinkingRuleSet<Integer, Integer>("set3"){{
        add(PLUS_10);
    }};

    /* Chaining Rules */
    Rule<Integer, Integer> CHAIN_DOUBLE_INT = new ChainingRule<>("doubleInt", 100, (i) -> i>10, (i) -> i*2, "set2");
    Rule<Integer, Integer> CHAIN_TRIPLE_INT = new ChainingRule<>("tripleInt", 150, (i) -> i<10, (i) -> i*3, "set3");
    Rule<Integer, Integer> CHAIN_PLUS_5 = new ChainingRule<>("plus5", 100, (i) -> true, (i) -> i+5, null);
    Rule<Integer, Integer> CHAIN_PLUS_10 = new ChainingRule<>("plus10", 100, (i) -> true, (i) -> i+10, null);

    ChainingRuleSet<Integer> CHAIN_SET_1 = new ChainingRuleSet<Integer>("set1") {{
        add(CHAIN_DOUBLE_INT);
        add(CHAIN_TRIPLE_INT);
    }};

    ChainingRuleSet<Integer> CHAIN_SET_2 = new ChainingRuleSet<Integer>("set2") {{
        add(CHAIN_PLUS_5);
    }};

    ChainingRuleSet<Integer> CHAIN_SET_3 = new ChainingRuleSet<Integer>("set3"){{
        add(CHAIN_PLUS_10);
    }};
}
