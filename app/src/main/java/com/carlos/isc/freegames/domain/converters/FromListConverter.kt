package com.carlos.isc.freegames.domain.converters

interface FromListConverter<ResponseList, ModelList> {
    fun fromListResponse(responseList: List<ResponseList>?): List<ModelList>
}