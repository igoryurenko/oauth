package com.iyurenko.client.service.converter;

/**
 * @author iyurenko
 * @since 12.05.16.
 */
public abstract class AbstractConverter<SOURCE, TARGET> {

    protected abstract TARGET generateTarget();

    public TARGET convert(SOURCE source) {
        if (source == null) {
            return null;
        }
        TARGET result = generateTarget();
        convert(source, result);
        return result;
    }

    public abstract void convert(SOURCE from, TARGET to);


}
