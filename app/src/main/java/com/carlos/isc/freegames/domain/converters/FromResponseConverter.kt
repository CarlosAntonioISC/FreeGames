package com.carlos.isc.freegames.domain.converters

interface FromResponseConverter<Response, Model> {
    fun fromResponse(response: Response?): Model
}