/*
 * Copyright (c) 2008 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.grammar;

import com.mysema.query.grammar.Types.*;

/**
 * VisitorAdapter provides
 *
 * @author tiwe
 * @version $Id$
 */
public abstract class VisitorAdapter<V extends VisitorAdapter<V>> extends Visitor<V>{
    
    @Override
    protected void visit(AliasForAnything<?> expr) {
        visit((Alias<?>)expr);        
    }
    
    @Override
    protected void visit(AliasForCollection<?> expr){
        visit((Alias<?>)expr);
    }
    
    @Override
    protected void visit(AliasForEntity<?> expr) {
        visit((Alias<?>)expr);        
    }
    
    @Override
    protected void visit(OperationBinaryBoolean<?,?> expr) {
        visit((OperationBinary<?,?,?,?>)expr);
    }
    
    @Override
    protected void visit(PathBoolean expr) {
        visit((Path<?>)expr);     
    }
    
    @Override
    protected void visit(PathCollection<?> expr){
        visit((Path<?>)expr);
    }
    
    @Override
    protected void visit(PathDomainType<?> expr) {
        visit((Path<?>)expr);        
    }
    
    @Override
    protected void visit(OperationTertiaryBoolean<?,?,?> expr) {
        visit((OperationTertiary<?,?,?,?,?>)expr);
    }
    
    @Override
    protected void visit(OperationUnaryBoolean<?> expr) {
        visit((OperationUnary<?,?,?>)expr);        
    }
    
}
