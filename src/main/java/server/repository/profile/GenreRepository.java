package server.repository.profile;

import org.springframework.stereotype.Repository;
import server.domain.profile.Genre;

@Repository
public class GenreRepository {

    private GenreJpaRepository genreJpaRepository;

    public GenreRepository(final GenreJpaRepository genreJpaRepository){
        this.genreJpaRepository = genreJpaRepository;

    }


    public void save(final Genre genre){
        genreJpaRepository.save(genre);
        Systems.out.println(genre.getCreateAt());
    }
}
