/*
 * JEE 7 Archetype, base project for a 3 tiers JEE7 maven application
 *
 * Copyright (c) 2016, Luís Ribeiro or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Luís Ribeiro.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, please send an email to:
 * luismmribeiro@gmail.com
 */
package io.altar.test.fsm;

import io.altar.test.fsm.states.CreateProductState;
import io.altar.test.fsm.states.CreateShelfsState;
import io.altar.test.fsm.states.InitState;
import io.altar.test.fsm.states.ProductState;
import io.altar.test.fsm.states.ShelfState;
import io.altar.test.fsm.states.State;

/**
 * 
 * @author <a href="mailto:luismmribeiro@gmail.com">Luis Ribeiro</a>
 */
public class FiniteStateMachine {
    private State[] states = {new InitState(),                  // 0
                              new ProductState(),               // 1
                              new ShelfState(),                 // 2
                              new CreateProductState(),         // 3
                              null,
                              null,
                              null,
                              new CreateShelfsState()           // 7
                              };
    
    private Integer[][] transitionMatrix = {
                            /* TO_PRODUCT , TO_SHELF */
    /* init state */      {    1          , 2},
                            /* TO_CREATE , TO_READ, TO_UPDATE, TO_DELETE, TO_INIT */
    /* product state */   {    3         , 4      , 5        , 6        , 0},
    /* shelf state */     {    7         , 8      , 9        , 10       , 0},
                            /* TO_PRODUCT */
    /* product create st*/{    1},
    /* product read st*/  {    1},
    /* product update st*/{    1},
    /* product delete st*/{    1},
                                  /* TO_SHELF */
    /* shelf create stat*/{    null, 2},
    /* shelf read stat*/  {    null, 2},
    /* shelf update stat*/{    null, 2},
    /* shelf delete stat*/{    null, 2}
    };
    
    private int currentStateIndex = 0;
    
    public void executeTransition(Transition t) {
        currentStateIndex = transitionMatrix[currentStateIndex][t.getIndex()];
    }
    
    public void fsmEngine() {
        while(true) {
            Transition t = null;
            do {
                t = states[currentStateIndex].doAction();
                if(t == null) {
                    System.out.println("Opção inexistente.");
                }
            } while(t == null);
            executeTransition(t);
        }
    }
    
    
}
