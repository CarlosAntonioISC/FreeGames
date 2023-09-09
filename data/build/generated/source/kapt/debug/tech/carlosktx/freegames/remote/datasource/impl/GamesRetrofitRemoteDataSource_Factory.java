// Generated by Dagger (https://dagger.dev).
package tech.carlosktx.freegames.remote.datasource.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import tech.carlosktx.freegames.remote.retrofit.api.GamesApi;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GamesRetrofitRemoteDataSource_Factory implements Factory<GamesRetrofitRemoteDataSource> {
  private final Provider<GamesApi> gamesApiProvider;

  public GamesRetrofitRemoteDataSource_Factory(Provider<GamesApi> gamesApiProvider) {
    this.gamesApiProvider = gamesApiProvider;
  }

  @Override
  public GamesRetrofitRemoteDataSource get() {
    return newInstance(gamesApiProvider.get());
  }

  public static GamesRetrofitRemoteDataSource_Factory create(Provider<GamesApi> gamesApiProvider) {
    return new GamesRetrofitRemoteDataSource_Factory(gamesApiProvider);
  }

  public static GamesRetrofitRemoteDataSource newInstance(GamesApi gamesApi) {
    return new GamesRetrofitRemoteDataSource(gamesApi);
  }
}
