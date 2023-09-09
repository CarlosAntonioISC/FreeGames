package tech.carlosktx.freegames.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\bH\u0016J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Ltech/carlosktx/freegames/repository/GamesRepositoryImpl;", "", "remoteDataSource", "Ltech/carlosktx/freegames/remote/datasource/GamesRemoteDataSource;", "localDataSource", "Ltech/carlosktx/freegames/remote/datasource/GamesLocalDataSource;", "(Ltech/carlosktx/freegames/remote/datasource/GamesRemoteDataSource;Ltech/carlosktx/freegames/remote/datasource/GamesLocalDataSource;)V", "getGameDetail", "Lkotlinx/coroutines/flow/Flow;", "error/NonExistentClass", "gameId", "", "getGamesById", "", "gamesId", "getPopularGames", "saveGameAsFavorite", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class GamesRepositoryImpl {
    private final tech.carlosktx.freegames.remote.datasource.GamesRemoteDataSource remoteDataSource = null;
    private final tech.carlosktx.freegames.remote.datasource.GamesLocalDataSource localDataSource = null;
    
    @javax.inject.Inject
    public GamesRepositoryImpl(@org.jetbrains.annotations.NotNull
    tech.carlosktx.freegames.remote.datasource.GamesRemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    tech.carlosktx.freegames.remote.datasource.GamesLocalDataSource localDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<error.NonExistentClass>> getPopularGames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<error.NonExistentClass>> getGamesById(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> gamesId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<error.NonExistentClass> getGameDetail(int gameId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Object saveGameAsFavorite(int gameId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}