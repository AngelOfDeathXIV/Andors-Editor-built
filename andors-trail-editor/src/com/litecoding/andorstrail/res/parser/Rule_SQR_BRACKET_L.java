/* -----------------------------------------------------------------------------
 * Rule_SQR_BRACKET_L.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.3
 * Produced : Fri Jun 07 20:56:54 MUT 2013
 *
 * -----------------------------------------------------------------------------
 */

package com.litecoding.andorstrail.res.parser;

import java.util.ArrayList;

final public class Rule_SQR_BRACKET_L extends Rule
{
  private Rule_SQR_BRACKET_L(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule_SQR_BRACKET_L parse(ParserContext context)
  {
    context.push("SQR_BRACKET_L");

    boolean parsed = true;
    int s0 = context.index;
    ArrayList<Rule> e0 = new ArrayList<Rule>();
    Rule rule;

    parsed = false;
    if (!parsed)
    {
      {
        ArrayList<Rule> e1 = new ArrayList<Rule>();
        int s1 = context.index;
        parsed = true;
        if (parsed)
        {
          boolean f1 = true;
          int c1 = 0;
          for (int i1 = 0; i1 < 1 && f1; i1++)
          {
            rule = Terminal_NumericValue.parse(context, "%x5b", "[\\x5b]", 1);
            if ((f1 = rule != null))
            {
              e1.add(rule);
              c1++;
            }
          }
          parsed = c1 == 1;
        }
        if (parsed)
          e0.addAll(e1);
        else
          context.index = s1;
      }
    }

    rule = null;
    if (parsed)
      rule = new Rule_SQR_BRACKET_L(context.text.substring(s0, context.index), e0);
    else
      context.index = s0;

    context.pop("SQR_BRACKET_L", parsed);

    return (Rule_SQR_BRACKET_L)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */