package com.carlos.isc.freegames.domain.converters

interface FromListResponseConverter<ResponseList, ModelList> {
    fun fromListResponse(responseList: List<ResponseList>?): List<ModelList>
}