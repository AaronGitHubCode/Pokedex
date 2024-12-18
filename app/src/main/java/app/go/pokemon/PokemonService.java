package app.go.pokemon;

import retrofit2.Call;

import retrofit2.http.Path;
import retrofit2.http.GET;

public interface PokemonService {
    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonById(@Path("id") int id);
}
