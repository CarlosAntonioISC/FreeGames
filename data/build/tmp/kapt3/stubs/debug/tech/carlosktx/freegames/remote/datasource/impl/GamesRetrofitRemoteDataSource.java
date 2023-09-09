package tech.carlosktx.freegames.remote.datasource.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Ltech/carlosktx/freegames/remote/datasource/impl/GamesRetrofitRemoteDataSource;", "Ltech/carlosktx/freegames/remote/datasource/GamesRemoteDataSource;", "gamesApi", "Ltech/carlosktx/freegames/remote/retrofit/api/GamesApi;", "(Ltech/carlosktx/freegames/remote/retrofit/api/GamesApi;)V", "getGameById", "error/NonExistentClass", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopularGames", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class GamesRetrofitRemoteDataSource implements tech.carlosktx.freegames.remote.datasource.GamesRemoteDataSource {
    private final tech.carlosktx.freegames.remote.retrofit.api.GamesApi gamesApi = null;
    
    @javax.inject.Inject
    public GamesRetrofitRemoteDataSource(@org.jetbrains.annotations.NotNull
    tech.carlosktx.freegames.remote.retrofit.api.GamesApi gamesApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getPopularGames(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<? extends error.NonExistentClass>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getGameById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super error.NonExistentClass> continuation) {
        return null;
    }
}