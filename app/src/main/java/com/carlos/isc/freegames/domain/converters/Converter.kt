package com.carlos.isc.freegames.domain.converters

interface FromResponse<Response, Model> {
    fun fromResponse(response: Response): Model
}