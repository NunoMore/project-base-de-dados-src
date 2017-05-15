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
package io.altar.test.fsm.states;

import java.util.Collection;

import io.altar.test.fsm.Transition;
import io.altar.test.repository.ProductRepository;

/**
 * 
 * @author <a href="mailto:luismmribeiro@gmail.com">Luis Ribeiro</a>
 */
public class ProductState extends State {

    /* (non-Javadoc)
     * @see io.altar.test.fsm.State#writeOutput()
     */
    @Override
    protected void writeOutput() {
        writeOutput("Produtos", ProductRepository.getInstance().findAll());
    }

    protected void writeOutput(String item, Collection<?> items) {
        System.out.println("Listagem de " + item + ":");
        items.forEach(System.out::println);
        System.out.println("Escolha uma das opções:");
        System.out.println("1 - Criar");
        System.out.println("2 - Detalhe");
        System.out.println("3 - Editar");
        System.out.println("4 - Apagar");
        System.out.println("5 - Ecra anterior");
    }

    /* (non-Javadoc)
     * @see io.altar.test.fsm.State#processOutput(java.lang.String)
     */
    @Override
    protected Transition processInput(String line) {
        switch(line) {
        case "1": return Transition.TO_CREATE;
        case "2": return Transition.TO_READ;
        case "3": return Transition.TO_UPDATE;
        case "4": return Transition.TO_DELETE;
        case "5": return Transition.TO_INIT;
        default: return null;
        }
    }

}
