package tech.carlosktx.freegames.remote.datasource;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Ltech/carlosktx/freegames/remote/datasource/GamesRemoteDataSource;", "", "getGameById", "error/NonExistentClass", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopularGames", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface GamesRemoteDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPopularGames(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<? extends error.NonExistentClass>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getGameById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super error.NonExistentClass> continuation);
}