package com.hubspot.jinjava.el.ext.eager;

import de.odysseus.el.tree.Bindings;
import de.odysseus.el.tree.impl.ast.AstIdentifier;
import javax.el.ELContext;

public class EagerAstIdentifier extends AstIdentifier implements EvalResultHolder {
  protected Object evalResult;
  protected boolean hasEvalResult;

  public EagerAstIdentifier(String name, int index, boolean ignoreReturnType) {
    super(name, index, ignoreReturnType);
  }

  @Override
  public Object eval(Bindings bindings, ELContext context) {
    evalResult = super.eval(bindings, context);
    hasEvalResult = true;
    return evalResult;
  }

  @Override
  public Object getAndClearEvalResult() {
    Object temp = evalResult;
    evalResult = null;
    hasEvalResult = false;
    return temp;
  }

  @Override
  public boolean hasEvalResult() {
    return hasEvalResult;
  }
}
