package com.habithatch.demo.data.mappers

interface EntityModelMapper<E, M> {
    fun asEntity(model: M): E

    fun asModel(entity: E): M
}
