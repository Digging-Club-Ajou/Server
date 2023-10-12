package server.controller.genre;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.domain.member.vo.MemberSession;
import server.global.annotation.Login;
import server.mapper.genre.dto.GenreRequest;
import server.service.genre.GenreService;

@RequestMapping("/api")
@RestController
public class GenreController {

    private final GenreService genreService;

    public GenreController(final GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/genres")
    public void createGenre(@Login final MemberSession memberSession,
                            @RequestBody final GenreRequest genreRequest) {
        genreService.saveUserGenre(memberSession.id(),genreRequest);
    }
}
