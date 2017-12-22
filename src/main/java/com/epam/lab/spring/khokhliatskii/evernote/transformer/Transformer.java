package com.epam.lab.spring.khokhliatskii.evernote.transformer;

/**
 * interface to convert dto from front-end to entities for database
 */

public interface Transformer<S, D> {

    /**
     * transformer entity to dto
     */
    D unbind(S source);

    /**
     * bind dto with entity
     */
    S bind(D source);

}
