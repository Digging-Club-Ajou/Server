package server.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import server.domain.member.persist.Member;

import java.util.List;
import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByNickname(final String nickname);

    Optional<Member> findByEmail(final String email);

    List<Member> findByNicknameContaining(final String nickname);
}
